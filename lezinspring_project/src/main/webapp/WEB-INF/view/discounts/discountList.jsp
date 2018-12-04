<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Lezin Spring</title>
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/modern-business.css" var="starterTemplate"/>
    <spring:url value="/resources/angular/angular.min.js" var="minJS"/>
    <spring:url value="/resources/css/angular-growl.min.css" var="cssGrowl"/>
    <spring:url value="/resources/angular/angular-growl.min.js" var="growl"/>
    <spring:url value="/resources/angular/angular-resource.min.js" var="resourceJS"/>
    <spring:url value="/resources/angular/angular-route.min.js" var="routeJS"/>
    <spring:url value="/resources/angular/smart-table.min.js" var="smartTable"/>
    <link href="${starterTemplate}" rel="stylesheet"/>
    <link href="${bootstrap}" rel="stylesheet"/>
    <script src="${minJS}"></script>
    <script src="${routeJS}"></script>
    <script src="${resourceJS}"></script>
    <script src="${smartTable}"></script>
    <link href="${cssGrowl}" rel="stylesheet" media="screen"/>
    <script src="${growl}"></script>

</head>
<body>

<script>
    var app = angular.module('myApp', ['smart-table']);
    app.controller('getAllDiscountController', ['$scope', '$http',
        function ($scope, $http) {
            $http.get('/rest/findAllDiscounts').then(function (response) {
                    $scope.discounts = response.data;
                    console.log(response)
                },
                function (response) {
                    alert("Ошибка: " + response.code);
                    console.log(response)
                });

            $scope.removeItem = function removeItem(row) {
                var index = $scope.discounts.indexOf(row);
                if (index !== -1) {
                    $http.post('/rest/deleteDiscount', $scope.discounts[index]).then(function () {
                            $scope.discounts.splice(index, 1);
                        },
                        function () {
                            alert("Вы не успешны!");
                        });
                }
            }
            $scope.updateItem = function (row) {
                document.location.href = "/rest/updateDiscountEntity.html"
                    + "?id=:" + row.id;
            }
        }]);
</script>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/rest/index.html">Главная</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/rest/productList.html">Все товары</a>
                </li>
                <li>
                    <a href="/rest/buyerList.html">Все покупатели</a>
                </li>
                <li>
                    <a href="/rest/saleList.html">Все заказы</a>
                </li>
                <li>
                    <a href="/rest/discountList.html">Все скидки</a>
                </li>
                <li>
                    <a href="/rest/sellerList.html">Все продавцы</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<h3>Список скидок:</h3>
<div ng-app="myApp" ng-controller="getAllDiscountController">
    <table class="table table-striped" st-table="displayedList" st-safe-src="discounts">
        <tr>
            <td>Минимальное количество:</td>
            <td>Цена:</td>
            <td>От:</td>
            <td>До:</td>
            <td>Имя продавца:</td>
            <td>Название товара:</td>
            <td>
                <div class="row" style="width: 300px; padding: 10px">
                    <a class="btn btn-default" role="button" href="/rest/addDiscount.html">Добавить</a>
                </div>
            </td>
        </tr>
        <tr>
            <th>
                <input st-search="minQuantity" placeholder="Поиск по названию" class="input-sm form-control"
                       type="search"/>
            </th>
            <th>
                <input st-search="price" placeholder="Поиск по др" class="input-sm form-control" type="search"/>
            </th>
            <th>
                <input st-search="dateIn" placeholder="Поиск телефонному номеру" class="input-sm form-control"
                       type="search"/>
            </th>
            <th>
                <input st-search="dateWith" placeholder="Поиск по email" class="input-sm form-control"
                       type="search"/>
            </th>
            <th>
                <input st-search="sellerByIdSeller.name" placeholder="Поиск по адресу" class="input-sm form-control"
                       type="search"/>
            </th>
            <th>
                <input st-search="productByIdProduct.name" placeholder="Поиск по адресу" class="input-sm form-control"
                       type="search"/>
            </th>
        </tr>
        <tr ng-repeat="discount in displayedList">
            <td>{{ discount.minQuantity }}</td>
            <td>{{ discount.price }}</td>
            <td>{{ discount.dateIn | date:"dd/MM/yyyy" }}</td>
            <td>{{ discount.dateWith | date:"dd/MM/yyyy" }}</td>
            <td>{{ discount.seller.name }}</td>
            <td>{{ discount.product.name }}</td>
            <td>
                <button type="button" ng-click="updateItem(discount)" class="btn btn-sm btn-warning">
                    <i class="glyphicon glyphicon-edit"> </i>
                </button>
            </td>
            <td>
                <button type="button" class="button" ng-click="removeItem(discount)">
                    <i class="glyphicon glyphicon-remove"></i>
                </button>
            </td>
        </tr>
    </table>
</div>

</body>