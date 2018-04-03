<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Record Usage</title>
<style>
</style>
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
	<div>
		<form action="${pageContext.request.contextPath}/translist" method="post">
			
			<c:if test="${fn:length(productlist) gt 0 }">
				<c:forEach var="product" varStatus="loop" items="${productlist}">
					<div class="col-sm-12 col-md-4 col-lg-3">
						<ul class="list-group">
							<li class="list-group-item"><div style="width:200px; height:150px"><img src="/Stockist/image/part/${product.partName}.jpg" class="img-thumbnail"></div></li>
							<li class="list-group-item">Part Name : ${product.partName}</li>
							<li class="list-group-item">Part Number :
								${product.partNumber}</li>
							<li class="list-group-item">Part UnitPrice :
								${product.unitPrice}</li>
							<li class="list-group-item">Quantity : ${qtyist[loop.index]}</li>

						</ul>
					</div>
				</c:forEach>
				<br />
			</c:if>
			<div style="clear:both;">
			<input type="submit" value="Confirm" class="btn btn-default btn-lg"
				> 
				
				<a
				href="${pageContext.request.contextPath}/translist/cancel"><button class="btn btn-default btn-lg"
					value="cancel">Clear Cart</button></a>
					
					
					 <br /> <b><font
				face="Georgia, Garamond, Palatino, serif" size="3"> </font></b><br />
			Select Date Time:
			<%=new java.util.Date()%>
			</div>
		</form>
	</div>







</body>
</html>