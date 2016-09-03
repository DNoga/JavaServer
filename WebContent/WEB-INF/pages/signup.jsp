<%@include file="/WEB-INF/pages/templates/header.jsp"%>

<link href="resources/webjars/css/generic_center_form.css" rel="stylesheet">
<script src="resources/webjars/js/jsSignup/jsSignup.js"></script>

<title>Sign Up</title>
</head>

<body align>

	<div align='center' >
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Create Account</h3>
					</div>
					<div class="panel-body">
						<form:form role="form" modelAttribute="registerForm"
							id="registerForm" method="POST" action="/JavaServer/signup.html">


							<div class="form-group">
								<label>User Name</label> <input type="text" name="userName"
									id="userName" class="form-control input-sm"
									placeholder="User Name">
							</div>

							<div class="form-group">
								<label>Password</label> <input type="password" name="password"
									id="password" class="form-control input-sm"
									placeholder="Password">
							</div>

							<div class="form-group">
								<label>Confirm password</label> <input type="password"
									name="password_confirmation" id="password_confirmation"
									class="form-control input-sm" placeholder="Confirm Password">

							</div>

							<input type="submit" value="Register"
								class="btn btn-info btn-block">

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/pages/templates/footer.jsp"%>