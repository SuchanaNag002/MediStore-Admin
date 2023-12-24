<%@ page import="com.DAO.OrderedMedsDAO"%>
<%@ page import="com.DAO.MedicineDAO"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.Modals.OrderedMeds"%>
<%@ page import="com.Modals.Medicine"%>
<%@ page import="com.Modals.Patient"%>
<%@ page import="com.DAO.UserDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Page</title>
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

.delete-btn {
	background-color: #f44336;
	color: white;
	border: none;
	padding: 8px 12px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	cursor: pointer;
	border-radius: 4px;
	transition: background-color 0.3s ease;
}

.delete-btn:hover {
	background-color: #d32f2f;
}
</style>
</head>
<body>
	<div class="container">
		<%
		Patient pat = (Patient) request.getSession().getAttribute("patient");
		%>
		<h2>
			Cart Page For:
			<%=pat.getName()%></h2>
		<%
		UserDAO userDao = new UserDAO(DBConnect.getConn());
		int userId = userDao.getPatientId(pat);
		OrderedMedsDAO orderedMedsDAO = new OrderedMedsDAO(DBConnect.getConn());
		List<OrderedMeds> orderedMedsList = orderedMedsDAO.getOrderedMedsByUserId(userId);
		MedicineDAO medicineDAO = new MedicineDAO(DBConnect.getConn());

		if (orderedMedsList.isEmpty()) {
		%>
		<p>No items added to cart.</p>
		<%
		} else {
		%>
		<table>
			<thead>
				<tr>
					<th>Medicine Name</th>
					<th>Price</th>
					<th>Purchased Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
				for (OrderedMeds orderedMed : orderedMedsList) {
					String purchasedDate = dateFormatter.format(orderedMed.getPurchasedDate());
					Medicine medicine = medicineDAO.getMedicineById(orderedMed.getMedicineId());
				%>
				<tr>
					<td><%=medicine.getName()%></td>
					<td><%=medicine.getPrice()%></td>
					<td><%=purchasedDate%></td>
					<td>
						<form
							action="${pageContext.request.contextPath}/RemoveFromCartServlet"
							method="post">
							<input type="hidden" name="orderedMedId"
								value="<%=orderedMed.getOrderId()%>">
							<button type="submit" class="delete-btn">Delete From
								Cart</button>
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"></td>
					<td></td>
					<%
					int totalPrice = 0;
					for (OrderedMeds orderedMed : orderedMedsList) {
						Medicine medicine = medicineDAO.getMedicineById(orderedMed.getMedicineId());
						int price = Integer.parseInt(medicine.getPrice());
						totalPrice += price;
					}
					%>
					<td>Total Price: <%=totalPrice%></td>
				</tr>
			</tfoot>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>
