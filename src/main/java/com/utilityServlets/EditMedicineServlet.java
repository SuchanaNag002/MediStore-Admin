package com.utilityServlets;

import java.io.IOException;

import com.DAO.MedicineDAO;
import com.DB.DBConnect;
import com.Modals.Medicine;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditMedicineServlet")
public class EditMedicineServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int medId = Integer.parseInt(req.getParameter("medicineId"));
			 String name = req.getParameter("name");
	            String description = req.getParameter("description");
	            String price = req.getParameter("price");
	            Medicine medicine = new Medicine(medId, name, description, price);
	            MedicineDAO medicineDAO = new MedicineDAO(DBConnect.getConn());
	            boolean updated = medicineDAO.updateMedicine(medicine);
	            if(updated) {
	            	resp.sendRedirect("admin/allMeds.jsp");
	            }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}