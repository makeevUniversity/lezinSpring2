<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <head>
        <title>Lezin Spring</title>
        <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
        <spring:url value="/resources/css/modern-business.css" var="starterTemplate"/>
        <spring:url value="/resources/angular/angular.min.js" var="minJS"/>
        <spring:url value="/resources/angular/angular-resource.min.js" var="resourceJS"/>
        <spring:url value="/resources/angular/angular-route.min.js" var="routeJS"/>
        <link href="${starterTemplate}" rel="stylesheet"/>
        <link href="${bootstrap}" rel="stylesheet"/>
        <script src="${minJS}"></script>
        <script src="${routeJS}"></script>
        <script src="${resourceJS}"></script>
    </head>
</head>
<body>

<script>
    var app = angular.module('myAppAdd', []);
    app.controller('addBuyerController', function ($scope, $http, $location) {
        $scope.buyer = {
            id: '',
            name: '',
            email:'',
            birthday: new Date(),
            phoneNumber: '',
            address: ''
        };
        $scope.submit = function () {
            $http.post('/rest/insertBuyer', $scope.buyer).then(
                function (response) {
                    document.location.href = "/rest/buyerList.html";
                },
                function (response) {
                    alert("Error:" + response.status);
                });
        };
    })

</script>

<div class="autumn-spacer">

</div>
<div class="col-md-4" ng-app="myAppAdd" ng-controller="addBuyerController">
    <form id="buyerForm" name="buyerForm" ng-submit="submit()">
        <div class="form-group">
            <label class="control-label" for="nameField">Имя</label>
            <input id="nameField"
                   name="name"
                   class="form-control"
                   ng-model="buyer.name"
                   type="text"
                   required/>
            <span class="autumn-span-error" ng-show="buyerForm.name.$invalid">
                    <span ng-show="buyerForm.name.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="birthdayField">Дата дня рождения</label>
            <input id="birthdayField"
                   name="birthday"
                   class="form-control"
                   ng-model="buyer.birthday"
                   placeholder="dd.MM.yyyy"
                   type="date"
                   required>
            <span class="autumn-span-error" ng-show="buyerForm.birthday.$invalid">
                    <span ng-show="buyerForm.birthday.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="emailField">Email</label>
            <input id="emailField"
                   name="email"
                   class="form-control"
                   ng-model="buyer.email"
                   type="email"
                   required>
            </input>
            <span class="autumn-span-error" ng-show="buyerForm.email.$invalid">
                    <span ng-show="buyerForm.email.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="phoneNumberField">Номер телефона</label>
            <input id="phoneNumberField"
                    name="phoneNumber"
                    class="form-control"
                    ng-model="buyer.phoneNumber"
                    min="1"
                    type="number"
                    required>
            </input>
            <span class="autumn-span-error" ng-show="buyerForm.phoneNumber.$invalid">
                    <span ng-show="buyerForm.phoneNumber.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="addressField">Адрес</label>
            <input id="addressField"
                    name="address"
                    class="form-control"
                    ng-model="buyer.address"
                    type="text"
                    required>
            </input>
            <span class="autumn-span-error" ng-show="buyerForm.address.$invalid">
                    <span ng-show="buyerForm.address.$error.required">Поле обязательно</span>
  			    </span>
        </div>

        <div class="form-inline">
            <button id="submit" class="btn btn-primary" type="submit">Добавить</button>
            <a href="/rest/buyerList.html" class="btn btn-default" role="button">Отмена</a>
        </div>
    </form>
</div>

</body>
</html>
