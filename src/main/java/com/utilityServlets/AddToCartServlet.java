package com.utilityServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import com.DAO.OrderedMedsDAO;
import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.Modals.OrderedMeds;
import com.Modals.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int medicineId = Integer.parseInt(req.getParameter("medicineId"));
			Patient pat = (Patient) req.getSession().getAttribute("patient");
			UserDAO dao = new UserDAO(DBConnect.getConn());
			int userId = dao.getPatientId(pat);
			Date purchasedDate = new Date(System.currentTimeMillis());
			OrderedMeds orderedMeds = new OrderedMeds(0, medicineId, userId, purchasedDate);
			OrderedMedsDAO orderedMedsDAO = new OrderedMedsDAO(DBConnect.getConn());
			boolean added = orderedMedsDAO.addOrderedMed(orderedMeds);
			PrintWriter out = resp.getWriter();
			if(added) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Item added to cart successfully!');");
				out.println("location='patient/medStore.jsp';");
				out.println("</script>");
			}else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Some error occured! Try again.');");
				out.println("location='patient/cartPage.jsp';");
				out.println("</script>");
			}
		}catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("An error occurred while adding item to cart.");
		}
		
	}
}
