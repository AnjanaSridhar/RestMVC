<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Details page</title>
</head>
<body>
	<table border="1" align="center" style="width: 50%">
		<thead>
			<tr>
				<th>Person Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>House Number</th>
				<th>Street Name</th>
				<th>City</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${personAndAddress.person.person_id}" /></td>
				<td><c:out value="${personAndAddress.person.name}" /></td>
				<td><c:out value="${personAndAddress.person.age}" /></td>
				<td><c:out value="${personAndAddress.address.house_number}" /></td>
				<td><c:out value="${personAndAddress.address.street_name}" /></td>
				<td><c:out value="${personAndAddress.address.city}" /></td>
			</tr>
		</tbody>
	</table>

	<a href="${pageContext.request.contextPath}">Home Page</a>
	<br>
</body>
</html>