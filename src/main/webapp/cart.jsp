<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Cart</title>
</head>
<body>
	Hello, ${customer.name} <hr/>
	<c:set var="total" value="0.0"/>
	<table border="1">
		<thead>
			<tr>
				<td>Id</td>
				<td>Item Name</td>
				<td>Type</td>
				<td>Category</td>
				<td>Description</td>
				<td>Price</td>
			</tr>
		</thead>
		<c:forEach var="p" items="${priceList}">
			<%-- <c:set var="total" value="${total + i.price}"/> --%>
			<tr>
				<td>${p.itemId.id}</td>
				<td>${p.itemId.name}</td>
				<td>${p.itemId.type}</td>
				<td>${p.itemId.category}</td>
				<td>${p.itemId.description}</td>
				<td>${p.price }</td>
			</tr>			
		</c:forEach>
	</table>
	<br/>
	Total Bill: Rs. ${total}/- <br/><br/>
	<a href="logout">Log Out</a> 
</body>
</html>
