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
    app.controller('addSaleController', function ($scope, $http) {
        $scope.sale = {
            id: '',
            orderDate: new Date(),
            dateOfDelivery: new Date(),
            quantity: 1,
            price: 1,
            comment: '',
            address: '',
            seller: '',
            buyer: '',
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
        $http.get('/rest/findAllBuyers').then(
            function (response) {
                $scope.buyers = response.data;
            },
            function (response) {
                alert("Вы не успешны! " + response.status)
            });
        $scope.submit = function () {
            $http.post('/rest/insertSale', $scope.sale).then(
                function (response) {
                    document.location.href = "/rest/saleList.html";
                },
                function (response) {
                    alert("Error:" + response.status);
                });
        };
        $scope.totalPrice = function () {
            if ($scope.sale.product == '' || $scope.sale.seller == '' || $scope.sale.quantity == '' || $scope.sale.orderDate=='') {
                alert("Заполните поля с товаром, продавцом и кол-вом товаров, дату заказа");
                return;
            }
            $http({
                method: 'GET',
                url: '/rest/findDiscountByIdSellerAndProduct',
                params: {'idSeller': $scope.sale.seller.id, 'idProduct': $scope.sale.product.id}
            }).then(
                function (response) {
                    $scope.discount = response.data;

                    if($scope.discount.minQuantity>$scope.sale.quantity){
                        alert("Товара не достаточно для скидки!");
                    }else {
                        if($scope.discount.dateIn >= $scope.sale.orderDate >= $scope.dateWith){
                            alert("Скидка не действует");
                        }else {
                            $scope.sale.price=$scope.discount.price*$scope.sale.quantity;
                            return;
                        }
                    }
                    $scope.sale.price=$scope.sale.price*$scope.sale.quantity;
                },
                function (response) {
                    alert("Error:" + response.status);
                }
            );

        };
    })

</script>

<div class="autumn-spacer">

</div>
<div class="col-md-4" ng-app="myAppAdd" ng-controller="addSaleController">
    <form id="saleForm" name="saleForm" ng-submit="submit()">
        <div class="form-group">
            <label class="control-label" for="orderDateField">Дата заказа</label>
            <input id="orderDateField"
                   name="orderDate"
                   class="form-control"
                   ng-model="sale.orderDate"
                   placeholder="dd.MM.yyyy"
                   type="date"
                   required/>
            <span class="autumn-span-error" ng-show="saleForm.orderDate.$invalid">
                    <span ng-show="saleForm.orderDate.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="dateOfDeliveryField">Дата доставки</label>
            <input id="dateOfDeliveryField"
                   name="dateOfDelivery"
                   class="form-control"
                   ng-model="sale.dateOfDelivery"
                   placeholder="dd.MM.yyyy"
                   type="date"
                   required>
            <span class="autumn-span-error" ng-show="saleForm.dateOfDelivery.$invalid">
                    <span ng-show="saleForm.dateOfDelivery.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="quantityField">Количество</label>
            <input id="quantityField"
                   name="quantity"
                   class="form-control"
                   ng-model="sale.quantity"
                   type="number"
                   min="1"
                   required>
            </input>
            <span class="autumn-span-error" ng-show="saleForm.quantity.$invalid">
                    <span ng-show="saleForm.quantity.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="commentField">Комментарий</label>
            <input id="commentField"
                   name="comment"
                   class="form-control"
                   ng-model="sale.comment"
                   type="text"
                   required>
            </input>
            <span class="autumn-span-error" ng-show="saleForm.comment.$invalid">
                    <span ng-show="saleForm.comment.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="addressField">Адрес</label>
            <input id="addressField"
                   name="address"
                   class="form-control"
                   ng-model="sale.address"
                   type="text"
                   required>
            </input>
            <span class="autumn-span-error" ng-show="saleForm.address.$invalid">
                    <span ng-show="saleForm.address.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="productField">Товар</label>
            <select id="productField"
                    name="product"
                    class="form-control"
                    ng-model="sale.product"
                    ng-options="p.name for p in products"
                    type="text"
                    required>
            </select>
            <span class="autumn-span-error" ng-show="saleForm.product.$invalid">
                    <span ng-show="saleForm.product.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="sellerField">Продавец</label>
            <select id="sellerField"
                    name="seller"
                    class="form-control"
                    ng-model="sale.seller"
                    ng-options="s.name for s in sellers"
                    type="text"
                    required>
            </select>
            <span class="autumn-span-error" ng-show="saleForm.seller.$invalid">
                    <span ng-show="saleForm.seller.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="buyerField">Покупатель</label>
            <select id="buyerField"
                    name="buyer"
                    class="form-control"
                    ng-model="sale.buyer"
                    ng-options="b.name for b in buyers"
                    type="text"
                    required>
            </select>
            <span class="autumn-span-error" ng-show="saleForm.buyer.$invalid">
                    <span ng-show="saleForm.buyer.$error.required">Поле обязательно</span>
  			    </span>
        </div>
        <div class="form-group">
            <label class="control-label" for="priceField">Цена</label>
            <input id="priceField"
                   name="price"
                   class="form-control"
                   ng-model="sale.price"
                   min="1"
                   type="number"
                   required>
            </input>
            <span class="autumn-span-error" ng-show="saleForm.price.$invalid">
                    <span ng-show="saleForm.price.$error.required">Поле обязательно</span>
  			    </span>
            <div class="form-inline">
                <button class="btn btn-primary" ng-click="totalPrice()" type="button">Посчитать</button>
            </div>
        </div>
        <div class="form-inline">
            <button id="submit" class="btn btn-primary" type="submit">Добавить</button>
            <a href="/rest/saleList.html" class="btn btn-default" role="button">Отмена</a>
        </div>
    </form>
</div>

</body>
</html>

