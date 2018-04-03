<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Product</title>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-static-top"
		style="margin-top: -20px">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Create Product</a>
		</div>
	</div>
	</nav>

	<br />


	<form:form method="POST" modelAttribute="product"
		action="${pageContext.request.contextPath}/admin/viewproduct/create">
		<!-- modelAttr must match with model -->
		<p style="margin-left:20"/>
		<table>
			<tbody>
				<tr>
					<td>Part Name</td>
					<td><form:input path="partName" /></td>
					<td><form:errors path="partName" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Unit Price</td>
					<td><form:input path="unitPrice" /></td>
					<td><form:errors path="unitPrice" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><form:input path="description" /></td>
					<td><form:errors path="description" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Color</td>
					<td><form:input path="color" /></td>
					<td><form:errors path="color" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Dimension</td>
					<td><form:input path="dimension" /></td>
					<td><form:errors path="dimension" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>SupplierID</td>
					<td><form:input path="supplierId" /></td>
					<td><form:errors path="supplierId" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>ReOrder Point</td>
					<td><form:input path="reorderPoint" /></td>
					<td><form:errors path="reorderPoint" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Min. Order</td>
					<td><form:input path="minOrder" /></td>
					<td><form:errors path="minOrder" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Shelf Location</td>
					<td><form:input path="shelfLocation" /></td>
					<td><form:errors path="shelfLocation" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><form:input path="category" /></td>
					<td><form:errors path="category" cssStyle="color: red;" /></td>
				</tr>
			</tbody>
		</table>
		<br/>
		<br/>
		<input type="submit" value="Create Product" class="btn btn-default btn-lg" />
	</form:form>

</body>
</html>