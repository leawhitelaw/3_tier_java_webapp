<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="web_application.data_layer.StoreInventory" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="css/bootstrap.min.css"%></style>
<title>Stock List</title>
<meta charset="UTF-8">
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #e3f2fd;">
  <a class="navbar-brand" href="/software_architecture_cw/store">DE-Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link" href="/software_architecture_cw/store/products">Pricing</a>
      <a class="nav-item nav-link" href="/software_architecture_cw/store/stock">Stock</a>
      <a class="nav-item nav-link" href="/software_architecture_cw/store/loyalty">Loyalty</a>
      <a class="nav-item nav-link" href="/software_architecture_cw/store/report">Analytics</a>
      <a class="nav-item nav-link" href="/software_architecture_cw/store/finance">Finance Approval</a>
      <a class="nav-item nav-link" href="/software_architecture_cw/logout">Log Out</a>
    </div>
  </div>
</nav>
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
<c:choose>
<c:when test="${lowStockItem.getQuantity() < 10}">
<div class="alert alert-danger" role="alert">
  Item: "${lowStockItem.getProductName()}" with 
  Product ID: ${lowStockItem.getProductID()} is low in stock. 
  Current stock: ${lowStockItem.getQuantity()}. 
  Recommended to order more.
  An email has been sent to manager@management.com .
</div> 
</c:when>
</c:choose>
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