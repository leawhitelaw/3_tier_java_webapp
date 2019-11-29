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
<h1>Product: ${item.getProductName()}</h1>
<h4> Product ID: ${item.getProductID()}</h4>
<form action="/software_architecture_cw/store/stock/item" method="POST">
 <p>Current Stock: ${item.getQuantity()}
 <p>To order stock, enter quantity to order below:
 <c:set var="currentItem" value="${item}" scope="session"/>
 <div class="input-group mb-3">
 <p>Order Quantity: <input type="text" name="orderstock">
<%--   <div class="input-group-prepend">
    <label class="input-group-text" for="inputGroupSelect01">Select Deal</label>
  </div>
  <select class="custom-select" name="deal">
    <option selected>${product.getDeal()}</option>
    <option value="None">None</option>
    <option value="Buy1Get1Free">Buy1Get1Free</option>
    <option value="FreeDelivery">FreeDelivery</option>
    <option value="3For2">3For2</option>
  </select> --%>
</div>
 <button type="submit" class="btn btn-info" value="Login">Order Stock</button>
 </form>
 </div>