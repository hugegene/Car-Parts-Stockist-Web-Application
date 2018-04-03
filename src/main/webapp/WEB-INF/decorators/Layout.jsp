<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>	
	<c:url value="/css/bootstrap.min.css" var="bootstrapcss"/>
	<c:url value="/css/starter-template.css" var="startertemplate"/>
	<c:url value="/css/semantic.min.css" var="semanticmincss"/>
	<c:url value="/js/semantic.min.js" var="semanticminjs"/>
	
	<!-- Bootstrap Code -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="STYLESHEET" type="text/css" href="${bootstrapcss}" />
	<link rel="STYLESHEET" type="text/css" href="${startertemplate}" />
	
	<link rel="STYLESHEET" type="text/css" href="${semanticmincss}" />
	<script src="${semanticminjs}"></script>

	<dec:head />
	<title><dec:title default="Stockist"/></title>
</head>
<body>

	<!-- Top Bar -->
	<c:url value="/image/carmechanic(white).png" var="carmechanicw"/>
	<c:url value="/home" var="homepage"/>	
    <nav class="navbar navbar-inverse navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/about" />">
                    <img src="${carmechanicw}" height="30" style="padding-bottom: 5px;"></img>
                </a>
                <c:choose>
                   	<c:when test="${pageContext.request.userPrincipal.name != null}">
						<a class="navbar-brand" href="${homepage}">
							${pageContext.request.userPrincipal.name}
						</a>
					</c:when>
					<c:otherwise>
						<a class="navbar-brand" href="${homepage}">Stockist</a>
					</c:otherwise>							
				</c:choose>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                	<% if (request.isUserInRole("ROLE_ADMIN")) { %>
                		<li>
						<a href="<c:url value="/admin/viewproduct/list" />">Manage Products</a>
              		</li>
                		<li>
						<a href="<c:url value="/admin/suppliers/list" />">Manage Suppliers</a>
              		</li>
                		<li>
						<a href="<c:url value="/admin/users/view" />">View Users</a>
              		</li>
   					<li>
						<a href="<c:url value="/admin/register" />">Create New User</a>
              		</li>
              		<li>
						<a href="<c:url value="/generateReport" />">Reorder Report</a>
              		</li>
					<% } %>  
                    <li>
                    <% if (request.isUserInRole("ROLE_STAFF")) { %>
                		<li>
						<a href="<c:url value="/catalog" />">View Catalog</a>
              		</li>
					<% } %>  
                    <li>                  	
                    	<!-- LOGIN STATUS -->
                    	<c:if test="${HideLoginPageFlag != 1}">
	                    	<c:choose>
		                    	<c:when test="${pageContext.request.userPrincipal.name != null}">								
									<a href="<c:url value="/logout" />" >Logout</a>
								</c:when>	
								<c:otherwise>	
									<a href="<c:url value="/login" />" >Login</a>
								</c:otherwise>
							</c:choose>
						</c:if>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container-fluid -->
    </nav>	
    
    <dec:body />
    
	<!-- Footer -->

	<div style="clear:both;">
		<div id="col-12 footer" align="center">
		  <hr>
			<small>For CA Assignment</small>
		</div>
	</div>
	
	<!-- Bootstrap Code -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<c:url value="/js/jquery.min.js" var="jqueryjs"/>
	<c:url value="/js/bootstrap.min.js" var="bootstrapminjs"/>
    <script src="${jqueryjs}"></script>
    <script src="${bootstrapminjs}"></script>
</body>
</html>
