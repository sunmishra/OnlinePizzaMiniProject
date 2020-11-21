<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
</head>
<body>
Hello ${customer.name }<hr/>
<sf:form modelAttribute="sp" action="addCart?type=${item.type}">
	Id:			${item.id}		<br/>
	Name: 		${item.name}	<br/>
	Type:		${item.type}	<br/>
	Category:	${item.category}	<br/>
	Description:${item.description}	<br/>
	Price:  	<br/>

				<c:forEach var="list" items="${spList}">
       				<tr>
       					<td><sf:checkbox path="sp" value="${list.id }" label="${list.size}"  /></td>  : <!-- Here value of checkbox is priceId --> 
       					<td>${list.price} </td>
   					</tr>
					<br/>
				</c:forEach><br/>

			            <input type="submit" value="Add cart"/>
<!-- Attribute 'value' is required when binding to non-boolean value : if u skip value or label in checkbox then u will get this error -->
</sf:form>
	
	</body>
</html>





<%-- <sf:checkbox path="sp" label="${list.size}" />
<!-- <input type="Submit" value="Add Cart" /> --> --%>

<%-- 
<sf:checkbox path="sp" value="${list.price }" label="${list.size}"  />
        				${list.price } --%>