<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<style><%@include file="css/bootstrap.min.css"%></style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<div class="container">
	<h1>Login</h1>
	<tr>
	<td>${message}</td>
	</tr>
	<td>Please enter username and password:</td>
	<form action="login" method="POST">
	<div class="form-group col-xs-5">
		<p>Username: <input type="text" name="username">
		<p>Password: <input type="password" name="password">
	</div>
	<button type="submit" class="btn btn-info" value="login">Login</button>
	</form>
	</div>
</body>
</html>