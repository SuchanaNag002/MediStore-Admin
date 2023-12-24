<%@ page import="com.DAO.MedicineDAO"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.Modals.Medicine"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicine Store</title>
<style>
body {
	background-color: #f2f2f2;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

.container {
	width: 80%;
	margin: 50px auto;
	background-color: white;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
	text-align: center; /* Center align text */
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	text-align: left;
	padding: 12px;
}

th {
	background-color: #333;
	color: white;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

.btn-edit {
	background-color: #34495E; color : white;
	border: none;
	padding: 8px 12px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	cursor: pointer;
	border-radius: 4px;
	transition: background-color 0.3s ease;
	color: white;
}

.btn-edit:hover {
	background-color: #5D6D7E;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Medicine Store</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Image</th>
					<th scope="col">Medicine</th>
					<th scope="col">Description</th>
					<th scope="col">Price</th>
					<th scope="col">Add To Cart</th>
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
					<td style="vertical-align: middle;"><%=med.getPrice()%></td>
					<td style="text-align: center; vertical-align: middle;">
						<form action="${pageContext.request.contextPath}/AddToCartServlet"
							method="post">
							<input type="hidden" name="medicineId" value="<%=med.getId()%>">
							<button type="submit" class="btn-edit">+</button>
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<div style="text-align: center; margin-top: 20px;">
			<a href="cartPage.jsp" class="btn-edit">Go To Cart</a>
		</div>
	</div>
</body>
</html>
