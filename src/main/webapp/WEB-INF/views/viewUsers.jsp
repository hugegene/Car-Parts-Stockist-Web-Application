<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Manage Users</title>
</head>
<body>	
	<c:forEach var="u" items="${users}">
		<div class="col-sm-6 col-md-2 col-lg-3">
			<ul class="list-group">					
				<li class="list-group-item">Staff ID : ${u.staffId}</li>
				<li class="list-group-item">Staff Name: ${u.name}</li>
				<li class="list-group-item">Staff Role : ${u.role}</li>
				<c:url value="/admin/users/edit/${u.staffId}" var="editUser"/>
				<li class="list-group-item"><a href="${editUser}">Edit</a></li>
				<c:url value="/admin/users/delete/${u.staffId}" var="deleteUser"/>
				<li class="list-group-item"><a href="${deleteUser}">Delete</a></li>
			</ul>
		</div>
	</c:forEach>

</body>
</html>