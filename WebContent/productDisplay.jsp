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
<title>Product</title>
</head>
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
<c:choose>
	<c:when test="${nullParams == 'yes'}">
		<div class="alert alert-danger" role="alert">
			Please input/select valid field values
		</div>
	</c:when>
	<c:when test="${updatedPrice != null}">
		<div class="alert alert-success" role="alert">
			New price of ${updatedPrice} has been set.
		</div>
	</c:when>
</c:choose>
<h1>Product: ${product.getProductName()}</h1>
<h4> Product ID: ${product.getProductID()}</h4>
<form action="/software_architecture_cw/store/products/product" method="POST">
 <p>Current Product Price: £${product.getPrice()}
 <p>New Price: £<input type="text" name="newprice" value = "${product.getPrice()}">
 <c:set var="currentProduct" value="${product}" scope="session"/>
 <div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Select Deal</label>
  </div>
  <select class="custom-select" name="deal">
    <option selected>${product.getDeal()}</option>
    <option value="None">None</option>
    <option value="Buy1Get1Free">Buy1Get1Free</option>
    <option value="FreeDelivery">FreeDelivery</option>
    <option value="3For2">3For2</option>
  </select>
</div>
 <button type="submit" class="btn btn-info" value="Login">Update</button>
 </form>
 </div>