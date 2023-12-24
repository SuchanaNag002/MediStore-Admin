package com.Modals;

import java.sql.Date;

public class OrderedMeds {
	private int orderId;
	private int medicineId;
	private int userId;
	private Date purchasedDate;

	public OrderedMeds(int orderId, int medicineId, int userId, Date purchasedDate) {
		this.orderId = orderId;
		this.medicineId = medicineId;
		this.userId = userId;
		this.purchasedDate = purchasedDate;
	}

	public Date getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
