<%@ page import="com.DAO.MedicineDAO"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="java.util.*"%>
<%@ page import="com.Modals.Medicine"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:All Medicines</title>
<style>
/* allMeds.css */
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
}

h2 {
	text-align: center;
	color: #333;
}

table {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 12px;
	text-align: left;
}

th {
	background-color: #333;
	color: white;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

.btn {
	display: inline-block;
	padding: 8px 12px;
	text-decoration: none;
	border-radius: 4px;
	transition: background-color 0.3s ease;
	margin-right: 5px;
	color: #fff;
}

.btn-edit {
	background-color: #34495E;
}

.btn-delete {
	background-color: #e74c3c;
}

.btn:hover {
	opacity: 0.8;
}

img {
	width: 50px;
	height: 50px;
}
</style>
</head>
<body>
	<h2 class="text-center">Medicines In Store</h2>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Image</th>
				<th scope="col">Medicine</th>
				<th scope="col">Description</th>
				<th scope="col">Price</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<%
			MedicineDAO dao = new MedicineDAO(DBConnect.getConn());
			List<Medicine> medsList = dao.getAllMedicines();
			for (Medicine med : medsList) {
			%>
			<tr>
				<td><%=med.getId()%></td>
				<td><img
					src="${pageContext.request.contextPath}/med_images/<%=med.getPictureUrl()%>"
					style="width: 50px; height: 50px;"></td>
				<td><%=med.getName()%></td>
				<td><%=med.getDescription()%></td>
				<td><%=med.getPrice()%></td>

				<td><a href="editMedicine.jsp?id=<%=med.getId()%>"
					class="btn btn-edit">Edit</a> <a
					href="${pageContext.request.contextPath}/DeleteMedicineServlet?id=<%=med.getId()%>"
					class="btn btn-delete">Delete</a>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
	<div style="text-align: center; margin-top: 70px;">
		<a href="${pageContext.request.contextPath}/admin/addMedicine.jsp"
			style="display: inline-block; padding: 10px 10px; text-decoration: none; border-radius: 4px; background-color: #34495E;; color: white; transition: background-color 0.3s ease;">Add
			a Medicine >></a>
	</div>
</body>
</html>