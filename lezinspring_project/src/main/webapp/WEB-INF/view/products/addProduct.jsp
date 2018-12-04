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
    app.controller('addProductController', function ($scope, $http, $location) {
        $scope.product = {
            id: '',
            name: '',
            unit: '',
            price: ''
        };
        $scope.submit = function () {
            $http.post('/rest/insertProduct', $scope.product).then(
                function (response) {
                    $location.path("/rest/productList");
                },
                function (response) {
                    alert("Error:" + response.status);
                });
        };
    })

</script>

<div class="autumn-spacer">

</div>
<div class="col-md-4" ng-app="myAppAdd" ng-controller="addProductController">
    <form id="productForm" name="productForm" ng-submit="submit()">
        <div class="form-group">
            <label class="control-label" for="nameField">Название</label>
            <input id="nameField"
                   name="name"
                   class="form-control"
                   ng-model="product.name"
                   type="text"
                   required/>
            <span class="autumn-span-error" ng-show="productForm.name.$invalid">
                    <span ng-show="productForm.name.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="unitField">Единица измерения</label>
            <input id="unitField"
                   name="unit"
                   class="form-control"
                   ng-model="product.unit"
                   type="text"
                   required>
            <span class="autumn-span-error" ng-show="productForm.unit.$invalid">
                    <span ng-show="productForm.unit.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="priceField">Цена</label>
            <input id="priceField"
                   name="price"
                   class="form-control"
                   ng-model="product.price"
                   type="number"
                   required>
            </input>
            <span class="autumn-span-error" ng-show="productForm.price.$invalid">
                    <span ng-show="productForm.price.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-inline">
            <button id="submit" class="btn btn-primary" type="submit">Добавить</button>
            <a href="/rest/productList.html" class="btn btn-default" role="button">Отмена</a>
        </div>
    </form>
</div>

</body>
</html>
