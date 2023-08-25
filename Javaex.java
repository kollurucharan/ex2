package com.charan;

import java.sql.Date;

public class Javaex {
	int product_id;
	String product_name;
	double price;
	int stock_quantity;
	String manufacturer;
	String category;
	java.sql.Date purchase_date;

	String computer;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock_quantity() {
		return stock_quantity;
	}

	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public java.sql.Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(java.sql.Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getComputer() {
		return computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}

	public Javaex(int product_id, String product_name, double price, int stock_quantity, String manufacturer,
			String category, Date purchase_date, String computer) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.stock_quantity = stock_quantity;
		this.manufacturer = manufacturer;
		this.category = category;
		this.purchase_date = purchase_date;
		this.computer = computer;
	}

}
