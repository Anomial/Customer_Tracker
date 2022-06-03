<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

<meta charset="ISO-8859-1">
<title>Customers list</title>
</head>
<body>
	<div id="wrapper">
	<div id="header">
		<h2>CRM- Customer Relationship Manager</h2>
	</div>
		<div id="container">
			<div id="content">
			
			<!-- button add new customer -->
			<input type="button" value="Add customer" 
				onclick="window.location.href='showFormForAdd';return false;"
				class="add-button"
			/>
			<!-- add html table -->
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>email name</th>
				</tr>
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
					<td> ${tempCustomer.firstName}</td>
					<td> ${tempCustomer.lastName}</td>
					<td> ${tempCustomer.email}</td>
					
					</tr>
					
				
				</c:forEach>
				
				
			</table>
			</div>
		</div>
	</div>

</body>
</html>