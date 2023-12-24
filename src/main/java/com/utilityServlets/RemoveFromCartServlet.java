package com.utilityServlets;

import com.DAO.OrderedMedsDAO;
import com.DB.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int orderedMedId = Integer.parseInt(request.getParameter("orderedMedId"));
            OrderedMedsDAO orderedMedsDAO = new OrderedMedsDAO(DBConnect.getConn());
            boolean removed = orderedMedsDAO.removeOrderedMed(orderedMedId);
            PrintWriter out = response.getWriter();
            if (removed) {
            	response.sendRedirect("patient/cartPage.jsp");;
            } else {
            	out.println("<script type=\"text/javascript\">");
				out.println("alert('Some error occured! Try again.');");
				out.println("location='patient/cartPage.jsp';");
				out.println("</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred while removing item from cart.");
        }
    }
}
