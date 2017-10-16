<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="saveCustomer" modelAttribute="customer" method="POST">
<form:hidden path="id"/>
<table>
<tr>
<td>FirstName</td>
<td><form:input path="firstName"/></td>
</tr>
<tr>
<td>LastName</td>
<td><form:input path="lastName"/></td>
</tr>
<tr>
<td>Email</td>
<td><form:input path="email"/></td>
</tr>
<tr>
<tr>
<td colspan="2"> <input type="submit" value="Save Customer"/> </td>
</tr>
</table>
</form:form>
</body>
</html>