package com.Modals;

public class Medicine {
	private int id;
	private String name;
	private String description;
	private String price;
	private String pictureUrl;

	public Medicine(int id, String name, String description, String price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Medicine(int id, String name, String description, String price, String pictureUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.pictureUrl = pictureUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

}
