<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
<%@ page import="web_application.data_layer.LoyaltyDeal" %>
<!DOCTYPE html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="css/bootstrap.min.css"%></style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js">
</script>
<title>Loyalty Deal</title>
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
			Please fill out all fields
		</div>
	</c:when>
	<%-- <c:when test="${orderedQty != null}">
		<div class="alert alert-success" role="alert">
			${orderedQty} item(s) have been ordered.
		</div>
	</c:when> --%>
</c:choose>
<h1>Deal: ${deal.getDealName()}</h1>
<h4> Product ID: ${deal.getProductID()}</h4>
<form action="/software_architecture_cw/store/loyalty/deal" method="POST">
 <p>Current required points: ${deal.getReqPoints()}
 <p>Delete Deal?
<c:set var="currentdeal" value="${deal}" scope="session"/> 
 <div class="input-group mb-3">
<!--  <p>Points: <input type="text" name="points">
 <p>Deal Name: <input type="text" name="dealName">
</div> -->
 <button type="submit" class="btn btn-danger" value="delete">Delete</button>
 </form>
 </div>