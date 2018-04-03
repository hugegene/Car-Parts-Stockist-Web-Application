<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
th {text-align:center; padding:10;}
tr {line-height:1.5;}
</style>
<title>Suppliers Management Page</title>
</head>
<body>


	<nav class="navbar navbar-inverse navbar-static-top"
		style="margin-top: -20px">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Suppliers</a>
		</div>

	</div>
	</nav>
	<p style="margin-left:10">
	<a href="${pageContext.request.contextPath}/admin/suppliers/create" class="btn btn-default btn-lg">Add
	Supplier</a>

	<br>
	<br>
	
	<c:if test="${fn:length(supplierList) gt 0}">		<!-- if this is empty, then dont print table -->
	<table align="center" style="spacing:5; padding:5; border:1;text-align:center;">
		<thead style="line-height:2; line-width:2; cellspacing:5; cellpadding:5; border:1;text-align:center;">
			<tr class="listHeading">
				<th>Supplier ID</th>
				<th>Supplier Name</th>
				<th>Supplier Address</th>
				<th>Country</th>
				<th>Contact No.</th>
				<th>Edit</th> 		<!-- comes from i18n message properties, professionally done <spring:message code="caption.delete" />-->
				<th>Delete</th>		<!--  hard-coded currently - to amend with spring message, ^edit as well -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="suppliers" items="${supplierList}">
				<tr class="listRecord">
					<td>${suppliers.supplierid}</td>		<!-- from database -->
					<td>${suppliers.name}</td>
					<td>${suppliers.address}</td>
					<td>${suppliers.country}</td>
					<td>${suppliers.contact}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/suppliers/edit/${suppliers.supplierid}.html">Edit</a></td> <!--  hard-coded currently - to amend with spring message, ^edit as well -->
					<td><a
						href="${pageContext.request.contextPath}/admin/suppliers/delete/${suppliers.supplierid}.html">Delete</a></td> <!--  hard-coded currently - to amend with spring message, ^edit as well -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>




</body>
</html>