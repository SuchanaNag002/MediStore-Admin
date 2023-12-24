<%@ page import="com.DAO.MedicineDAO"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.Modals.Medicine"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Medicine</title>
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
	text-align:center;
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
	background-color:  #5D6D7E;
	color: white;
	padding: 12px 24px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	transition: background-color 0.3s ease;
	margin-top: 30px;
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
		<%
		String idParam = request.getParameter("id");
		int id = (idParam != null && !idParam.isEmpty()) ? Integer.parseInt(idParam) : 0;
		MedicineDAO dao = new MedicineDAO(DBConnect.getConn());
		Medicine med = dao.getMedicineById(id);
		%>
		<h1>Edit Medicine: <%=med.getId()%></h1>
		<form action="../EditMedicineServlet" method="post">
			<input type="hidden" id="medicineId" name="medicineId"
				value="<%=id%>">
			<div class="form-group">
				<label for="name">Medicine Name:</label> <input type="text"
					id="name" name="name" value="<%=med.getName()%>" required>
			</div>
			<div class="form-group">
				<label for="description">Description:</label>
				<textarea id="description" name="description" required><%=med.getDescription()%></textarea>
			</div>
			<div class="form-group">
				<label for="price">Price:</label> <input type="text" id="price"
					value="<%=med.getPrice()%>" name="price" required>
			</div>
			<div class="form-group">
				<button type="submit">Edit</button>
			</div>
		</form>
	</div>
</body>
</html>
