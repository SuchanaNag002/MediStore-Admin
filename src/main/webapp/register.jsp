<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<%@include file="components/allCss.jsp"%>
</head>
<body>
	<div class="container p-2">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Registration Page</h4>
						<form action="/MedistoreAndAdmin/register" method="post">
						<input  name="userType" type="hidden" value="patient"/>
							<div class="mb-3">
								<label for="exampleInputName" class="form-label">Enter
									Name</label> <input type="text" class="form-control" name="name"
									id="exampleInputName">

							</div>
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
							<div class="select mb-3">
							<label for="exampleInputName" class="form-label">Gender</label>
								<select name="gender" id="gender">
									<option value="M">Male</option>
									<option value="F">FEMALE</option>
								</select>
							</div>
							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input" name="ucheck"
									id="exampleCheck"> <label class="form-check-label"
									for="exampleCheck">I agree to the terms and conditions</label>
							</div>
							
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>