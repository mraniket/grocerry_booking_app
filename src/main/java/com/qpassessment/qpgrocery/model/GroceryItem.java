package com.qpassessment.qpgrocery.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String itemName;
	private int price;
	private int quantity;
	private Date manifactureDate;
	private boolean available; // Avaialibility of items
	private int discount; // discount will be in percentage

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getManifactureDate() {
		return manifactureDate;
	}

	public void setManifactureDate(Date manifactureDate) {
		this.manifactureDate = manifactureDate;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
