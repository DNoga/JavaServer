<%@include file="/WEB-INF/pages/templates/header.jsp"%>
<link href="resources/webjars/css/generic_center_form.css" rel="stylesheet">

<title>Web App</title>
</head>

<body>
<script src="resources/webjars/js/jsLogout/jsLogout.js"></script>
 <div class="modal-dialog modal-lg centered-form">
 	<div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">You have successfully logged out!</h4>
        </div>
        <div class="modal-body">
          <p>You will be redirected in 5 seconds</p>
        </div>
        <div class="modal-footer">
          <a href="/JavaServer" >Return to login</a>
        </div>
      </div>
	</div>

<%@include file="/WEB-INF/pages/templates/footer.jsp"%>