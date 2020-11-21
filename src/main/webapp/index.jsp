<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Index </title>
</head>
<body>
	<sf:form action="auth">
		Email: <sf:input path="email" />
		<br/>
		Password: <sf:password path="password" />
		<br/>
		<input type="submit" value="Sign In" />
	</sf:form>
</body>
</html>