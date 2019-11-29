<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="web_application.data_layer.Employee" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style><%@include file="css/bootstrap.min.css"%></style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js">
<title>Home</title>
</script>
</head>
<body>
<div class="container">
	<h1>Welcome to DE-Store ${employee.getEmployeeName()}!</h1>
	<c:choose>
		<c:when test="${employee.getAccessLevel() == 1}">
		<h2>Access level = team member</h2>
		</c:when>
		<c:when test="${employee.getAccessLevel() == 2}">
		<h2>Access level = management</h2>
		</c:when>
		<c:when test="${employee.getAccessLevel() == 3}">
		<h2>Access level = Corporate</h2>
		</c:when>
	</c:choose>
</div>
</body>
</html>