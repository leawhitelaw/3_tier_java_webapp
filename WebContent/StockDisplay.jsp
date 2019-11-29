<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
<%@ page import="web_application.data_layer.ProductPrice" %>
<!DOCTYPE html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="css/bootstrap.min.css"%></style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js">
</script>
<title>Stock Item</title>
</head>
<div class="container">
<c:choose>
	<c:when test="${nullParams == 'yes'}">
		<div class="alert alert-danger" role="alert">
			Please give field a value over 0
		</div>
	</c:when>
	<c:when test="${orderedQty != null}">
		<div class="alert alert-success" role="alert">
			${orderedQty} item(s) have been ordered.
		</div>
	</c:when>
</c:choose>
<h1>Product: ${item.getProductName()}</h1>
<h4> Product ID: ${item.getProductID()}</h4>
<form action="/software_architecture_cw/store/stock/item" method="POST">
 <p>Current Stock: ${item.getQuantity()}
 <p>To order stock, enter quantity to order below:
 <c:set var="currentItem" value="${item}" scope="session"/>
 <div class="input-group mb-3">
 <p>Order Quantity: <input type="text" name="orderstock">
</div>
 <button type="submit" class="btn btn-info" value="Login">Order Stock</button>
 </form>
 </div>