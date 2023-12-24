<%@ page import="java.sql.Connection" %>
<%@ page import="com.DB.DBConnect" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register/Login</title>
</head>
<body>
	<div class="col-md-3">
			<a href="login.jsp" class="btn btn-success">Login</a> <a href="register.jsp"
				class="btn btn-primary">Register</a>
		</div>
	<div class="container-fluid">
		<h2 class="text-center">Click on register for new entry or login for existing entry</h2>
	</div>
	<%Connection conn = DBConnect.getConn();
	out.println(conn);
	%>
	<div class="container" style="background-color: #f7f7f7">

	</div>
</body>
</html>