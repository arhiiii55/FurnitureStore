package com.qlnt.model;

import java.sql.Date;
import java.util.List;

public class Inspection {

	private List<Staff> staffId;

	private List<Product> productId;

	private String checkStatus;

	private Date checkDate;

	public List<Staff> getStaffId() {
		return staffId;
	}

	public void setStaffId(List<Staff> staffId) {
		this.staffId = staffId;
	}

	public List<Product> getProductId() {
		return productId;
	}

	public void setProductId(List<Product> productId) {
		this.productId = productId;
	}

	public String getCheckStatu() {
		return checkStatus;
	}

	public void setCheckStatu(String checkStatu) {
		this.checkStatus = checkStatu;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	@Override
	public String toString() {
		return "Inspection [staffId=" + staffId + ", productId=" + productId + ", checkStatu=" + checkStatus
				+ ", checkDate=" + checkDate + "]";
	}

}
