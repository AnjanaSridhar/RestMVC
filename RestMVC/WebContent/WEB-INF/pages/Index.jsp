<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
	<a href="add_person"> add person</a>
	<br>

	<c:choose>
		<c:when test="${fn:length(people) gt 0}">
			<table border="1" align="center" style="width: 50%">
				<thead>
					<tr>
						<th>Person Id</th>
						<th>Name</th>
						<th>Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="person" items="${people}">
						<tr>
							<td><c:out value="${person.person_id}" /></td>
							<td><c:out value="${person.name}" /></td>
							<td><c:out value="${person.age}" /></td>
							<td><a
								href="<c:url value='add_address/${person.person_id}' />">
									add address</a></td>
							<td><a
								href="<c:url value='get_person/${person.person_id}' />">
									View Details</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<p>There are no people in the database</p>. 
        <br />
		</c:otherwise>
	</c:choose>


	</div>

</body>
</html>