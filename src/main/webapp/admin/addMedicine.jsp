<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Medicine</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
}

.container {
	width: 60%;
	margin: 50px auto;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
	text-align: center;
}

h1 {
	text-align: center;
	color: #333;
}

form {
	display: flex;
	flex-direction: column;
}

.form-group {
	margin-bottom: 15px;
}

label {
	font-weight: bold;
	margin-bottom: 10px;
	display: block;
	font-size: 18px;
}

#exampleFormControlFile1{
	width: 25%;
}

input[type="text"], textarea {
	width: 100%;
	padding: 10px;
	border-radius: 4px;
	border: 1px solid #ccc;
	box-sizing: border-box;
	font-size: 16px;
}

button[type="submit"] {
	background-color: #34495E;
	color: white;
	padding: 12px 24px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	transition: background-color 0.3s ease;
	margin-top: 30px;
}

button[type="submit"]:hover {
	background-color: #5D6D7E;
	color: white;
	padding: 12px 24px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	transition: background-color 0.3s ease;
	margin-top: 30px;
}

.form-group input[type="file"] {
	display: block;
	margin: 0 auto;
}

.error-message {
	color: #e74c3c;
	font-size: 14px;
	margin-top: 5px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Add Medicine</h1>
		<form action="../AddMedicineServlet" method="post"
			enctype="multipart/form-data">
			<div class="form-group">
				<label for="name">Medicine Name:</label> <input type="text"
					id="name" name="name" required>
			</div>
			<div class="form-group">
				<label for="description">Description:</label>
				<textarea id="description" name="description" required></textarea>
			</div>
			<div class="form-group">
				<label for="price">Price:</label> <input type="text" id="price"
					name="price" required>
			</div>
			<div class="form-group">
				<label for="exampleFormControlFile1">Upload Photo:</label><input
					name="bimg" type="file" class="form-control-file"
					id="exampleFormControlFile1">
			</div>
			<div class="form-group">
				<button type="submit">Add</button>
			</div>
		</form>
	</div>
</body>
</html>
