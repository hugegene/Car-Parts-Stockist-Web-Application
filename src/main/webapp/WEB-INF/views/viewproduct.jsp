<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-static-top"
		style="margin-top: -20px">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/catalog">Catalog</a>
		</div>
	</nav>

	<form:form modelAttribute="emptyproduct"
		action="${pageContext.request.contextPath}/viewproduct/${currentproduct.partNumber}"
		method="POST">

		<div class="col-sm-12 col-md-4 col-lg-3">
			<ul class="list-group">
				<li class="list-group-item"><div style="width:200px; height:150px"><img src="/Stockist/image/part/${currentproduct.partName}.jpg" class="img-thumbnail"></div></li>
				<li class="list-group-item">Part Name :
					${currentproduct.partName}</li>
				<li class="list-group-item">Part Number :
					${currentproduct.partNumber}</li>
				<li class="list-group-item">UnitPrice :
					${currentproduct.unitPrice}</li>
				<li class="list-group-item">Description :
					${currentproduct.description}</li>
				<li class="list-group-item">Color : ${currentproduct.color}</li>
				<li class="list-group-item">Dimension :
					${currentproduct.dimension}</li>
				<li class="list-group-item">Supplier:
					${currentproduct.supplierId}</li>
				<li class="list-group-item">Reorder Point:
					${currentproduct.reorderPoint}</li>
				<li class="list-group-item">Min.Order:
					${currentproduct.minOrder}</li>
				<li class="list-group-item">ShelfLocation:
					${currentproduct.shelfLocation}</li>
				<li class="list-group-item">Category:
					${currentproduct.category}</li>
			</ul>
			Quantity Selected:<br>
			<form:input path="partNumber" class="form-control" />
			<form:errors path="partNumber" cssStyle="color: red;"/>
			<input type="submit" value="Save" class="btn btn-default btn-lg"/>

		</div>

	</form:form>
</body>
</html>