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
 <p>To edit required points enter values for all fields below:
<c:set var="currentdeal" value="${deal}" scope="session"/> 
 <div class="input-group mb-3">
 <p>Points: <input type="text" name="points">
 <p>Deal Name: <input type="text" name="dealName">
</div>
 <button type="submit" class="btn btn-danger" value="delete">Delete</button>
 </form>
 </div>