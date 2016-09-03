<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Welcome</title>
<%response.sendRedirect("/JavaServer/login"); %>
           
</head>
<body>
<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
</body>

</html>