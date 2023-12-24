<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@include file="components/allCss.jsp"%>
</head>
<body>
	<div class="container p-2">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="text-center">Login Page</h5>
						<form action="login" method="post">
							<div class="mb-3">
								<label for="exampleInputEmail" class="form-label">Email
									address</label> <input type="email" class="form-control" name="email"
									id="exampleInputEmail" aria-describedby="emailHelp">

							</div>
							<div class="mb-3">
								<label for="exampleInputPassword" class="form-label">Password</label>
								<input type="password" class="form-control" name="password"
									id="exampleInputPassword">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Login</button>
								<br> <a href="register.jsp">Create account</a>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>