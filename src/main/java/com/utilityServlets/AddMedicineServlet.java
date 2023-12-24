package com.utilityServlets;

import java.io.File;
import java.io.IOException;

import com.DAO.MedicineDAO;
import com.DB.DBConnect;
import com.Modals.Medicine;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/AddMedicineServlet")
@MultipartConfig
public class AddMedicineServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			String price = req.getParameter("price");
			Part part = req.getPart("bimg");
			String fileName = part.getSubmittedFileName();
			Medicine medicine = new Medicine(0, name, description, price, fileName);
			MedicineDAO medicineDAO = new MedicineDAO(DBConnect.getConn());
			String path = getServletContext().getRealPath("") + "med_images";
			//System.out.println(path);->copy paste this path/med_images and get the stored pictures
			File f = new File(path);
			part.write(path + File.separator + fileName);
			boolean k = medicineDAO.addMedicine(medicine);
			if (k) {
				resp.sendRedirect("admin/addMedicine.jsp");
			} else {
				System.out.println("Error occurred");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
