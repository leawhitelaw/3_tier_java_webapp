<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="web_application.data_layer.StoreInventory" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="css/bootstrap.min.css"%></style>
<title>Stock List</title>
<meta charset="UTF-8">
<div class="container">
<table class="table table-striped">
		<caption>Stock</caption>
		<thead>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Quantity</th>
			<th></th>
		</thead>
<tbody>
 <!-- <h2> Product Pricing </h2> -->
 <c:forEach items="${stock}" var="item">
<tr>
		<td>${item.productID}</td>
		<td>${item.productName}</td>
		<td>${item.quantity}</td>
		<c:choose>
			<c:when test= "${item.quantity <= 5}"> 
				<td><a href="stock/item?id=${item.productID}" class="btn btn-danger btn-lg active" role="button" aria-pressed="true">Order</a></td>
			</c:when>
			<c:when test= "${item.quantity > 5 && item.quantity < 11}"> 
				<td><a href="stock/item?id=${item.productID}" class="btn btn-warning btn-lg active" role="button" aria-pressed="true">Order</a></td>
			</c:when>
			<c:otherwise>
				<td><a href="stock/item?id=${item.productID}" class="btn btn-success btn-lg active" role="button" aria-pressed="true">Order</a></td>
			</c:otherwise>
		</c:choose>
	</tr>
 </c:forEach>
 </tbody>
 </table>
 </div>