<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Non Veg Items</title>
</head>
<body>
	Hello ${name}<br/> 
	<h3>NonVeg Items</h3>
	<table border="1">
		<thead>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Category</td>
				<td>Description</td>
			</tr>
		</thead>
		<c:forEach var="nveg" items="${nonVegList}">
			<tr>
				<td>${nveg.id}</td>
				<td>${nveg.name}</td>
				<td>${nveg.category}</td>
				<td><a href="details?id=${nveg.id}">Details</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="showCart">Show Cart</a>
</body>
</html>