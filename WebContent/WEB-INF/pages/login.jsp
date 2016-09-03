<%@include file="/WEB-INF/pages/templates/header.jsp"%>

<link href="resources/webjars/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<link href="resources/webjars/css/login.css" rel="stylesheet">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" import="javax.servlet.jsp.PageContext"%>
<title>Login</title>
</head>
<body>
	<form:form class="form-signin" id="form-login" method="POST"
		action="/JavaServer/login">
		<div class="modal-dialog modal-sm-4 center" align='center'>
			<div class="modal-content">
				<div class="modal-header">

					<div id="sign in">
						<h1 class="modal-header">Login</h1>
						<a href="/JavaServer/signup" style="display: inline-block;">create
							account</a>
					</div>
					<input type="text" class="form-control" placeholder="User Name"
						name="userName" id="userName" required> <input
						type="password" class="form-control" placeholder="Password"
						name="password" id="password" required>
					<button class="btn btn-lg btn-primary btn-block" type="submit">
						Sign In</button>
						<br>
							<core:if test="${not empty error}">
					<div class="error alert alert-warning text-center">${error}</div>
					</core:if>
				</div>
			</div>
		</div>
	</form:form>
	<%@include file="/WEB-INF/pages/templates/footer.jsp"%>