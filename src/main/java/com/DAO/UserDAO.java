package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Modals.Patient;
import com.Modals.User;

public class UserDAO {
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public Patient getPatient(User us) {
		try {
			String query = "Select * from patients where email=? AND password=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, us.getEmail());
			ps.setString(2, us.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Patient(rs.getString("name"), rs.getString("email"), rs.getString("password"),
						rs.getString("gender"));
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addPatient(Patient pat) {
		boolean f = false;
		try {
			String query = "insert into patients(email,name,password,gender) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, pat.getEmail());
			ps.setString(2, pat.getName());
			ps.setString(3, pat.getPassword());
			ps.setString(4, pat.getGender());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public int getPatientId(Patient pat) {
		int userId = 0;
		try {
			String query = "SELECT id FROM patients WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, pat.getEmail());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				userId = rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}

}
