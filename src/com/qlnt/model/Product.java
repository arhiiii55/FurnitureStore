package com.qlnt.model;

import java.util.List;

public class Product {
	private int id;

	private String name;

	private String image;

	private List<Storage> storageId;

	private List<TypeProductModel> typeId;

	private String brand;

	private String quantity;

	private int price;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Storage> getStorageId() {
		return storageId;
	}

	public void setStorageId(List<Storage> storageId) {
		this.storageId = storageId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<TypeProductModel> getTypeId() {
		return typeId;
	}

	public void setTypeId(List<TypeProductModel> typeId) {
		this.typeId = typeId;
	}

}
