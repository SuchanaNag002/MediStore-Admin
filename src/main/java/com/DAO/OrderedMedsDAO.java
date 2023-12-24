package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Modals.OrderedMeds;

public class OrderedMedsDAO {
	private Connection connection;

	public OrderedMedsDAO(Connection connection) {
		this.connection = connection;
	}

	public boolean addOrderedMed(OrderedMeds orderedMeds) {
		String query = "INSERT INTO orderedmeds (entryId, patient_id, med_id, purchased_date) VALUES (?, ?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, orderedMeds.getOrderId());
			preparedStatement.setInt(2, orderedMeds.getUserId());
			preparedStatement.setInt(3, orderedMeds.getMedicineId());
			preparedStatement.setDate(4, new Date(orderedMeds.getPurchasedDate().getTime()));
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<OrderedMeds> getOrderedMedsByUserId(int userId) throws SQLException {
		List<OrderedMeds> orderedMedsList = new ArrayList<>();
		String query = "SELECT entryId, med_id, purchased_date FROM orderedmeds WHERE patient_id = ?";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int entryId = resultSet.getInt("entryId");
				int medicineId = resultSet.getInt("med_id");
				Date purchasedDate = resultSet.getDate("purchased_date");

				OrderedMeds orderedMeds = new OrderedMeds(entryId, medicineId, userId, purchasedDate);
				orderedMedsList.add(orderedMeds);
			}
		} catch (SQLException e) {
			throw e;
		}
		return orderedMedsList;
	}

	public boolean removeOrderedMed(int orderedMedId) {
		boolean removed = false;
		try {
			String query = "DELETE FROM orderedmeds WHERE entryId = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, orderedMedId);
			int i = ps.executeUpdate();
			if (i == 1) {
				removed = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return removed;
	}

}
