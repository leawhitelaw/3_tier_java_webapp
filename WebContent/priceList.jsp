<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="web_application.data_layer.ProductPrice" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="css/bootstrap.min.css"%></style>
<title>Price List</title>
<meta charset="UTF-8">
<div class="container">
<table class="table table-striped">
		<caption>Product Pricing</caption>
		<thead>
			<th>ProductID</th>
			<th>Price</th>
			<th>Store</th>
		</thead>
<tbody>
 <!-- <h2> Product Pricing </h2> -->
 <c:forEach items="${products}" var="p">
<tr>
		<td>${p.productID}</td>
		<td>${p.price}</td>
		<td>${p.storeID}</td>
	</tr>
 </c:forEach>
 </tbody>
 </table>
 </div>