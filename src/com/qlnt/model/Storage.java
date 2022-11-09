package com.qlnt.model;

public class Storage {
	private int id;
	
	private String area;
	
	private int sumProduct ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getSumProduct() {
		return sumProduct;
	}

	public void setSumProduct(int sumProduct) {
		this.sumProduct = sumProduct;
	}

	@Override
	public String toString() {
		return "Storage [id=" + id + ", area=" + area + ", sumProduct=" + sumProduct + "]";
	}
	
	

}
