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
    app.controller('addDiscountController', function ($scope, $http, $location) {
        $scope.discount = {
            id: '',
            minQuantity: '',
            price: '',
            dateIn: new Date(),
            dateWith: new Date(),
            seller: '',
            product: ''
        };
        $http.get('/rest/findAllSellers').then(
            function (response) {
                $scope.sellers = response.data;
            },
            function (response) {
                alert("Вы не успешны! " + response.status);
            });
        $http.get('/rest/findAllProducts').then(
            function (response) {
                $scope.products = response.data;
            },
            function (response) {
                alert("Вы не успешны! " + response.status)
            });
        $scope.submit = function () {
            $http.post('/rest/insertDiscount', $scope.discount).then(
                function (response) {
                    $location.path("/rest/discountList");
                },
                function (response) {
                    alert("Error:" + response.status);
                });
        };
    })
</script>

<div class="autumn-spacer">

</div>
<div class="col-md-4" ng-app="myAppAdd" ng-controller="addDiscountController">
    <form id="discountForm" name="discountForm" ng-submit="submit()">
        <div class="form-group">
            <label class="control-label" for="minQuantityField">Минимальное количество</label>
            <input id="minQuantityField"
                   name="minQuantity"
                   class="form-control"
                   ng-model="discount.minQuantity"
                   type="number"
                   min="1"
                   required/>
            <span class="autumn-span-error" ng-show="discountForm.minQuantity.$invalid">
                    <span ng-show="discountForm.minQuantity.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="priceField">Цена</label>
            <input id="priceField"
                   name="price"
                   class="form-control"
                   ng-model="discount.price"
                   type="number"
                   min="1"
                   required>
            <span class="autumn-span-error" ng-show="discountForm.price.$invalid">
                    <span ng-show="priceField.price.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="dateInField">Дата от</label>
            <input id="dateInField"
                   name="inDate"
                   class="form-control"
                   ng-model="discount.dateIn"
                   placeholder="dd.MM.yyyy"
                   type="date"
                   required>
            </input>
            <span class="autumn-span-error" ng-show="discountForm.inDate.$invalid">
                    <span ng-show="discountForm.inDate.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="dateFromField">Дата до</label>
            <input id="dateFromField"
                   name="fromDate"
                   class="form-control"
                   ng-model="discount.dateWith"
                   placeholder="dd.MM.yyyy"
                   type="date"
                   required>
            <span class="autumn-span-error" ng-show="discountForm.fromDate.$invalid">
                    <span ng-show="discountForm.fromDate.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="sellerField">Продавец</label>
            <select id="sellerField"
                    name="sellerfield"
                    class="form-control"
                    ng-model="discount.seller"
                    ng-options="s.name for s in sellers"
                    type="text"
                    required>
            </select>
            <span class="autumn-span-error" ng-show="discountForm.sellerfield.$invalid">
                    <span ng-show="discountForm.sellerfield.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="productField">Товар</label>
            <select id="productField"
                    name="productfield"
                    class="form-control"
                    ng-model="discount.product"
                    ng-options="p.name for p in products"
                    type="text"
                    required>
            </select>
            <span class="autumn-span-error" ng-show="discountForm.productfield.$invalid">
                    <span ng-show="discountForm.productfield.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-inline">
            <button id="submit" class="btn btn-primary" type="submit">Добавить</button>
            <a href="/rest/discountList.html" class="btn btn-default" role="button">Отмена</a>
        </div>
    </form>
</div>

</body>
</html>
