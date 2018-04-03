<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
</head>
<body>	
	<div class="container-fluid">
        <div class="row">
            <div class="col-md-12 " style="padding-top: 30px;">
                <div style="min-width: 300px; text-align: center;">
                    <div style="text-align: center;">
                        <div class="panel panel-default" style="width: 350px; margin-left: auto; margin-right: auto; margin-top: 10px; margin-bottom: 10px; padding-left: 60px; padding-bottom: 10px;">
	                        <form action="login" method="POST">
								<table class="framed" cellpadding="1" cellspacing="0" style="border-collapse: collapse;">
									<tr>
										<td>
											<div style="padding: 10px;" />
										</td>
									</tr>
									<tr>
										<td colspan="4">
											<c:if test="${not empty param.error}">
												<div class="alert alert-warning">
													Invalid Login
												</div>
											</c:if>
										</td>
									</tr>									
									<tr>
										<td align="right" style="padding: 5px;">
											User name
										</td>										
										<td colspan="3">
											<input type="text" id="userid" name="userid" size="20" />
										</td>
									</tr>
									<tr>
										<td>
											<div style="padding: 10px;" />
										</td>
									</tr>
									<tr>
										<td align="right" style="padding: 5px;">
											Password
										</td>										
										<td colspan="3">
											<input type="password" id="password" name="password" size="20" />
										</td>
									</tr>
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>
									<tr>
										<td colspan="3">
											<button class="btn btn-default btn-lg" name="Submit" value="Submit" type="Submit">
												Login
											</button>
										</td>
									</tr>
								</table>
							</form>             
                        </div>
                    </div>
                </div>
            </div>
        </div>
     </div>	
</body>
</html>