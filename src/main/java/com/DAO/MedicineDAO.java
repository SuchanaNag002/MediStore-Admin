package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.Modals.Medicine;

public class MedicineDAO {
	private Connection conn;

	public MedicineDAO(Connection conn) {
		this.conn = conn;
	}

	public List<Medicine> getAllMedicines() {
		List<Medicine> medicines = new ArrayList<>();
		String query = "select * from medicines";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String price = rs.getString("price");
				String pictureUrl = rs.getString("picture_url");
				Medicine medicine = new Medicine(id, name, description, price, pictureUrl);
				medicines.add(medicine);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicines;
	}

	public boolean addMedicine(Medicine medicine) {
		String query = "INSERT INTO medicines (name, description, price, picture_url) VALUES (?, ?, ?, ?)";
		int f = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, medicine.getName());
			ps.setString(2, medicine.getDescription());
			ps.setString(3, medicine.getPrice());
			ps.setString(4, medicine.getPictureUrl());
			f = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f > 0;

	}

	public Medicine getMedicineById(int id) {
		Medicine medicine = null;
		String query = "SELECT * FROM medicines WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				medicine = new Medicine(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getString("price"), rs.getString("picture_url"));

				medicine.setId(rs.getInt("id"));
				medicine.setName(rs.getString("name"));
				medicine.setDescription(rs.getString("description"));
				medicine.setPrice(rs.getString("price"));
				medicine.setPictureUrl(rs.getString("picture_url"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return medicine;
	}

	public boolean updateMedicine(Medicine medicine) {
		String query = "UPDATE medicines SET name=?, description=?, price=? WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, medicine.getName());
			ps.setString(2, medicine.getDescription());
			ps.setString(3, medicine.getPrice());
			ps.setInt(4, medicine.getId());

			int rowsUpdated = ps.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteMedicine(int id) {
	    try {
	        // Delete related entries from orderedmeds table
	        String query1 = "DELETE FROM orderedmeds WHERE med_id = ?";
	        PreparedStatement psOrderedMeds = conn.prepareStatement(query1);
	        psOrderedMeds.setInt(1, id);
	        psOrderedMeds.executeUpdate();

	        // Delete medicine from medicines table
	        String query2 = "DELETE FROM medicines WHERE id = ?";
	        PreparedStatement psMedicine = conn.prepareStatement(query2);
	        psMedicine.setInt(1, id);

	        int rowsDeleted = psMedicine.executeUpdate();
	        return rowsDeleted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}


}
