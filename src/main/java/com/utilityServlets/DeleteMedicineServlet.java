package com.utilityServlets;
import java.io.IOException;
import java.io.PrintWriter;

import com.DAO.MedicineDAO;
import com.DB.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteMedicineServlet")
public class DeleteMedicineServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int medicineId = Integer.parseInt(req.getParameter("id"));
			MedicineDAO dao = new MedicineDAO(DBConnect.getConn());
			boolean removed = dao.deleteMedicine(medicineId);
			PrintWriter out = resp.getWriter();
			if (removed) {
				resp.sendRedirect("admin/allMeds.jsp");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Some error occurred! Try again.');");
				out.println("location='admin/allMeds.jsp';");
				out.println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("An error occurred while deleting item from store.");
		}
	}
}
