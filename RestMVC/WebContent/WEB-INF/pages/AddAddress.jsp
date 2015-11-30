<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Address</title>
</head>
<body>
	<form:form method="POST"
		action="${pageContext.request.contextPath}/addAddress"
		modelAttribute="address">
		<table>
			<tr>
				<td><form:label path="person_id">Person Id</form:label></td>
				<td><form:input readonly="true" path="person_id" /></td>
			</tr>
			<tr>
				<td><form:label path="house_number">House Number</form:label></td>
				<td><form:input path="house_number" /></td>
			</tr>
			<tr>
				<td><form:label path="street_name">Street Name</form:label></td>
				<td><form:input path="street_name" /></td>
			</tr>
			<tr>
				<td><form:label path="city">City</form:label></td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Address" /></td>
			</tr>
		</table>
	</form:form>
	<c:out value="${msg}" />
</body>
<a href="${pageContext.request.contextPath}">Home Page</a>
<br>
</body>
</html>