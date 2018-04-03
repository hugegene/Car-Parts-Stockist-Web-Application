<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Registration Complete!</title>
</head>
<body>
	<c:url value="/home" var="homepage"/>
	<form:form action="${homepage}" method="GET" modelAttribute="newUser">
		<c:choose>
			<c:when test="${newUser.adminStatus}">
				<div class="alert alert-success">
					New Admin Account Created
				</div>				
			</c:when>
			<c:otherwise>
				<div class="alert alert-success">
					New Staff Account Created
				</div>
			</c:otherwise>
		</c:choose>	
		<div  class="form-group">
			<label>Staff ID</label>
			<input type="text" readonly="readonly" class="form-control" value="${newUser.userId}"/>
		</div>
		<div  class="form-group">
			<label>Name</label>
			<input type="text" readonly="readonly" class="form-control" value="${newUser.name}"/>
		</div>
		<div  class="form-group">
			<label>User name</label>
			<input type="text" readonly="readonly" class="form-control" value="${newUser.userName}"/>
		</div>
		<div  class="form-group">
			<label>Password</label>
			<input type="text" readonly="readonly" class="form-control" value="${newUser.password}"/>
		</div>
		<div class="form-group">	
			<input type="submit" value="Return" class="btn btn-default btn-lg"/>
		</div>
	</form:form>
	
		
</body>
</html>