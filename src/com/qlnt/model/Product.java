package com.qlnt.model;

public class Product {
	private int id;

	private String name;

	private String image;

	private Storage storage;

	private TypeProductModel typeProduct;

	private String brand;

	private int quantity;

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public TypeProductModel getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(TypeProductModel typeProduct) {
		this.typeProduct = typeProduct;
	}

}
