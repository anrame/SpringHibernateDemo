<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<h1>CRM-Customer RelationShip Manager</h1>
</div>


<input type="button" value="Add Customer" onclick="window.location.href='addCustomer';return false;">


<div id="container">
<div id="content">

<table border="1">
<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email</th>
	<th>Action</th>
</tr>
<c:forEach var="cus" items="${customer}">
<!-- Create update link -->
<c:url var="updateLink" value="/customers/updateCustomer">
<c:param name="customerId" value="${cus.id}"></c:param>
</c:url>
<!-- Create delete link -->
<c:url var="deleteLink" value="/customers/deleteCustomer">
<c:param name="customerId" value="${cus.id}"></c:param>
</c:url>
<tr>
<td>${cus.firstName}</td>
<td>${cus.lastName}</td>
<td>${cus.email}</td>
<td><a href=${updateLink}>Update</a>|<a href=${deleteLink} onclick="if (!confirm('Are you sure?')) return false;">Delete</a></td>
</tr>
</c:forEach>
</table>
</div>
</div>
</div>
</body>
</html>