<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Record Usage</title>
</head>
<body>
<form action="/record" method="post">
Vehicle License Plate No: <input type="text" value="licenceNo" style="width: 25px">
<table>
<tr>
	<th>Product Details</th>
	<th>Quantity</th>
</tr>
<tr>
<c:if test="${fn:length(catalog) gt 0 }">
		<c:forEach var="product" items="${catalog}">
			<div class="col-sm-12 col-md-4 col-lg-3">
				<ul class="list-group">
					<li class="list-group-item">Image Here</li>
					<li class="list-group-item">Part Name : ${product.partName}</li>
					<li class="list-group-item">Part Number :
						${product.partNumber}</li>
					<li class="list-group-item">Part UnitPrice :
						${product.unitPrice}</li>
					<li class="list-group-item">Qty in Stock: to be extracted</li>
					<li class="list-group-item"><button type="button" class="btn">Select</button></li>
				</ul>
			</div>
		</c:forEach>
	</c:if>
</tr>
<tr>
<td colspan="2"><input type="submit" class="btn btn-default btn-lg">Confirm</td>
</tr>
</table>
</form>
Hello
</body>
</html>