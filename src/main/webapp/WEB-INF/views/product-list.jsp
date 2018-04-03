<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
th {text-align:center; padding:5;}
tr {line-height:1.5;}
</style>
<title>Products Management Page</title>
</head>
<body>


	<nav class="navbar navbar-inverse navbar-static-top"
		style="margin-top: -20px">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Product</a>
		</div>


	</div>
	</nav>
	<p style="margin-left:10">
	<a href="${pageContext.request.contextPath}/admin/viewproduct/create" class="btn btn-default btn-lg">Add
	Product</a>
	
	<br>
	<br>
	
	<c:if test="${fn:length(productList) gt 0}">		<!-- if this is empty, then dont print table -->
	<table align="center" style="cellspacing: 2; cellpadding: 2; border: 2;text-align: center;">
		<thead style="line-height:2; cellspacing: 2; cellpadding: 5; border: 2;text-align: center;">
			<tr class="listHeading">
				<th>Part No</th>
				<th>Name</th>
				<th>Price</th>
				<th>Desc</th>
				<th>Color</th>
				<th>Dimension</th> 		<!-- comes from i18n message properties, professionally done <spring:message code="caption.delete" />-->
				<th>SupplierID</th>		<!--  hard-coded currently - to amend with spring message, ^edit as well -->
				<th>ReOrder Pt</th>
				<th>Min Order</th>
				<th>Shelf</th>
				<th>Category</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${productList}">
				<tr class="listRecord">
				<td>${product.partNumber}</td>		<!-- from database -->
					<td>${product.partName}</td>
					<td><fmt:formatNumber value="${product.unitPrice}" currencySymbol="$" type="currency"></fmt:formatNumber></td>
					<td>${product.description}</td>
					<td>${product.color}</td>		<!-- from database -->
					<td>${product.dimension}</td>
					<td>${product.supplierId}</td>
					<td>${product.reorderPoint}</td>
					<td>${product.minOrder}</td>
					<td>${product.shelfLocation}</td>
					<td>${product.category}</td>
 					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/viewproduct/edit/${product.partNumber}.html">Edit</a></td> 
					<td><a
						href="${pageContext.request.contextPath}/admin/viewproduct/delete/${product.partNumber}.html">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>


<!-- with list file -->
<%-- 	<c:if test="${fn:length(supplierList) gt 0 }">
		<c:forEach var="s" items="${supplierList}">
			<div class="col-sm-12 col-md-4 col-lg-3">
				<ul class="list-group">
					<li class="list-group-item">Supplier ID : ${s.supplierid}</li>
					<li class="list-group-item">Supplier Name : ${s.name}</li>
					<li class="list-group-item">Supplier Address: ${s.address}</li>
					<li class="list-group-item">Country: ${s.country }</li>
					<li class="list-group-item"><button type="button" class="btn">Select</button></li>
				</ul>
			</div>
		</c:forEach>
	</c:if> --%>

</body>
</html>