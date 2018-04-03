<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Register</title>
</head>
<body>
	<c:url value="/admin/register" var="registerPage" />
	<form:form action="${registerPage}" method="POST"
		modelAttribute="userDetails">
		<div class="col-sm-12 col-md-1 col-lg-3">
			<div class="form-group">
				<label>Name</label>
				<form:input path="name" class="form-control"/>
				<form:errors path="name" cssStyle="color: red;"/>
			</div>
			<div class="form-group">
				<label>User Name </label>
				<form:input path="userName" class="form-control"/>
				<form:errors path="userName" cssStyle="color: red;"/>
			</div>
			<div class="form-group">
				<label>Password </label>
				<form:password  path="password" class="form-control"/>
				<form:errors path="password" cssStyle="color: red;"/>
			</div>
			<div class="form-group">
				<label>Is Administrator</label>
				No<form:radiobutton path="adminStatus" value="false"/>
				Yes<form:radiobutton path="adminStatus" value="true"/>
			</div>
			<div class="form-group">
				<input type="submit" value="Create" class="btn btn-default btn-lg" />
			</div>
		</div>
	</form:form>
</body>
</html>