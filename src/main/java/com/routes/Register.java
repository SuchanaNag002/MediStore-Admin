package com.routes;

import java.io.IOException;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.Modals.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO(DBConnect.getConn());
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		try {
			Patient p = new Patient(name, email, password, gender);
			boolean f = userDAO.addPatient(p);
			if (f) {
				req.getSession().setAttribute("auth", true);
				req.getSession().setAttribute("userType", "patient");
				req.getSession().setAttribute("patient", p);

			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
