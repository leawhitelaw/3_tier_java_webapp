<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<tr>
	<td>${message}</td>
	</tr>
	<td>Please enter username and password:</td>
	<form action="Login" method="POST">
		<p>Username: <input type="text" name="username">
		<p>Password: <input type="password" name="password">
		<p><input type="submit" value="submit">
	</form>
</body>
</html>