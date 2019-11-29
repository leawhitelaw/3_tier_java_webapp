<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="web_application.data_layer.ProductPrice" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="css/bootstrap.min.css"%></style>
<title>Product List</title>
<meta charset="UTF-8">
<div class="container">
<table class="table table-striped">
		<caption>Products</caption>
		<thead>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Recommended Retail Price</th>
		</thead>
<tbody>
 <!-- <h2> Product Pricing </h2> -->
 <c:forEach items="${products}" var="p">
<tr>
		<td>${p.productID}</td>
		<td>${p.productName}</td>
		<td>${p.rrp}</td>
	</tr>
 </c:forEach>
 </tbody>
 </table>
 </div>