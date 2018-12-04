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
    app.controller('updateSellerController', function ($scope, $http, $location) {
        var params = window
            .location
            .search
            .replace('?', '')
            .split('&')
            .reduce(
                function (p, e) {
                    var a = e.split('=:');
                    p[decodeURIComponent(a[0])] = decodeURIComponent(a[1]);
                    return p;
                },
                {}
            );
        $http({method: 'GET', url: '/rest/findByIdSeller', params: {'id': params['id']}}).then(
            function (response) {
                $scope.seller = response.data;
//                $scope.discount.dateIn =  new Date(response.data.dateIn);
//                $scope.discount.dateWith = new Date(response.data.dateWith);
            },
            function (response) {
                alert("Error:" + response.status);
            }
        );
        $scope.submit = function () {
            $http.post('/rest/insertSeller', $scope.seller).then(
                function (response) {
                    $location.path("/rest/sellerList");
                },
                function (response) {
                    alert("Error:" + response.status);
                });
        };
    })

</script>

<div class="autumn-spacer">

</div>
<div class="col-md-4" ng-app="myAppAdd" ng-controller="updateSellerController">
    <form id="sellerForm" name="sellerForm" ng-submit="submit()">
        <div class="form-group">
            <label class="control-label" for="nameField">Имя</label>
            <input id="nameField"
                   name="name"
                   class="form-control"
                   ng-model="seller.name"
                   type="text"
                   required/>
            <span class="autumn-span-error" ng-show="sellerForm.name.$invalid">
                    <span ng-show="sellerForm.name.$error.required">Поле обязательно</span>
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
            <span class="autumn-span-error" ng-show="sellerForm.birthday.$invalid">
                    <span ng-show="sellerForm.birthday.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="dateOfEmploymentField">Дата трудоустройства</label>
            <input id="dateOfEmploymentField"
                   name="dateOfEmployment"
                   class="form-control"
                   ng-model="seller.dateOfEmployment"
                   placeholder="dd.MM.yyyy"
                   type="date"
                   required>
            <span class="autumn-span-error" ng-show="sellerForm.dateOfEmployment.$invalid">
                    <span ng-show="sellerForm.dateOfEmployment.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="emailField">Email</label>
            <input id="emailField"
                   name="email"
                   class="form-control"
                   ng-model="seller.email"
                   type="email"
                   required>
            </input>
            <span class="autumn-span-error" ng-show="sellerForm.email.$invalid">
                    <span ng-show="sellerForm.email.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="phoneNumberField">Номер телефона</label>
            <input id="phoneNumberField"
                   name="phoneNumber"
                   class="form-control"
                   ng-model="seller.phoneNumber"
                   min="1"
                   type="number"
                   required>
            </input>
            <span class="autumn-span-error" ng-show="sellerForm.phoneNumber.$invalid">
                    <span ng-show="sellerForm.phoneNumber.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="addressField">Адрес проживания</label>
            <input id="addressField"
                   name="address"
                   class="form-control"
                   ng-model="seller.address"
                   type="text"
                   required>
            </input>
            <span class="autumn-span-error" ng-show="sellerForm.address.$invalid">
                    <span ng-show="sellerForm.address.$error.required">Поле обязательно</span>
  			    </span>
        </div>

        <div class="form-inline">
            <button id="submit" class="btn btn-primary" type="submit">Обновить</button>
            <a href="/rest/sellerList.html" class="btn btn-default" role="button">Отмена</a>
        </div>
    </form>
</div>

</body>
</html>
