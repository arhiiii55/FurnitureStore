package com.qlnt.model;

public class TypeProductModel {
	
	private int id;
	
	private String nameType;
	

	public TypeProductModel(int id, String nameType) {
		super();
		this.id = id;
		this.nameType = nameType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	@Override
	public String toString() {
		return "TypeProduct [id=" + id + ", nameType=" + nameType + "]";
	}
	
	
}
