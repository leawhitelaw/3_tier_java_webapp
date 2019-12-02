<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="web_application.data_layer.LoyaltyDeal" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="css/bootstrap.min.css"%></style>
<title>Loyalty Deals</title>
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
<c:choose>
	<c:when test="${nullParams == 'yes'}">
		<div class="alert alert-danger" role="alert">
			Please input all field values
		</div>
	</c:when>
</c:choose>
<table class="table table-striped">
		<caption>Loyalty Deals</caption>
		<thead>
			<th>ProductID</th>
			<th>Required Points</th>
			<th>Deal</th>
			<th></th>
			<!-- <th>Store</th> -->
		</thead>
<tbody>
 <!-- <h2> Product Pricing </h2> -->
 <c:forEach items="${deals}" var="deal">
<tr>
		<td>${deal.getProductID()}</td>
		<td>${deal.getReqPoints()}</td>
		<td>${deal.getDealName()}</td>
		<td><a href="loyalty/deal?pid=${deal.getProductID()}&did=${deal.getDealID()}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">View Deal</a></td>
	</tr>
 </c:forEach>
 </tbody>
 </table>
 <form action="/software_architecture_cw/store/loyalty" method="POST">

 <div class="input-group mb-3">
  <div class="input-group-prepend">
  <p>Product ID: <input type="text" name="prodid" >
  <p>Deal Name: <input type="text" name="dealname" >
  <p>Required Minimum Points: <input type="text" name="minpoints" >
  </div>
</div>
 <button type="submit" class="btn btn-info" value="Login">Add New Deal</button>
 </form>
 </div>