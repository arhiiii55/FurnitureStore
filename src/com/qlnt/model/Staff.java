package com.qlnt.model;

public class Staff {
	private int id;

	private String staffId;

	private String fullNameString;

	private String phoneNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getFullNameString() {
		return fullNameString;
	}

	public void setFullNameString(String fullNameString) {
		this.fullNameString = fullNameString;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", staffId=" + staffId + ", fullNameString=" + fullNameString + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
}
