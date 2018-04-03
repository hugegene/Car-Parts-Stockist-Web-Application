<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Edit Employee</title>
</head>
<body>
	<c:url value="/admin/users/edit" var="editUser" />
	<form:form action="${editUser}" method="POST"
		modelAttribute="selectedUser">
		<div class="col-sm-12 col-md-1 col-lg-3">
			<div class="form-group">
				<label>Staff ID</label>
				<form:input path="staffId" class="form-control" readonly="true" />
			</div>
			<div class="form-group">
				<label>Name</label>
				<form:input path="name" class="form-control" />
				<form:errors path="name" cssStyle="color: red;"/>
			</div>
			<div class="form-group">
				<label>Is Administrator</label>
				No<form:radiobutton path="role" value="ROLE_STAFF"/>
				Yes<form:radiobutton path="role" value="ROLE_ADMIN"/>
				<form:errors path="role" cssStyle="color: red;"/>
			</div>
			<div class="form-group">
				<input type="submit" value="Save Changes" class="btn btn-default btn-lg" />
			</div>
		</div>
	</form:form>
</body>
</html>