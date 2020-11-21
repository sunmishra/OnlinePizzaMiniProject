<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Veg Items</title>
</head>
<body>
	Hello ${customer.name}<br/> 
	<h3>Veg Items</h3>
	<table border="1">
		<thead>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Category</td>
				<td>Details</td>
			</tr>
		</thead>
		<c:forEach var="veg" items="${vegList}">
			<tr>
				<td>${veg.id}</td>
				<td>${veg.name}</td>
				<td>${veg.category}</td>
				<td><a href="details?id=${veg.id}">Details</a></td><!-- we need to fetch details by id hence we need to provide id in the link -->
			</tr>
		</c:forEach>
	</table>
	<a href="showCart">Show Cart</a>
</body>
</html>