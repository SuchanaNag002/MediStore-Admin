package com.routes;

import java.io.IOException;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.Modals.Patient;
import com.Modals.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		if (email.equals("admin@gmail.com") && password.equals("admin")) {
			resp.sendRedirect("admin/allMeds.jsp");
		} else {
			try {
				UserDAO userDAO = new UserDAO(DBConnect.getConn());
				Patient p = userDAO.getPatient(new User(email, password));
				System.out.println(p);
				if (p != null) {
					req.getSession().setAttribute("auth", true);
					req.getSession().setAttribute("userType", "patient");
					req.getSession().setAttribute("patient", p);
					resp.sendRedirect(req.getContextPath() + "/patient/patientDashboard.jsp");

				} else {
					req.setAttribute("authInvalid", true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
