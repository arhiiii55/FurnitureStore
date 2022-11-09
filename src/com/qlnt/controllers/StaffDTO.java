package com.qlnt.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qlnt.db.ConnectDB;
import com.qlnt.model.Staff;

public class StaffDTO {
	public static List<Staff> getListStaff() {
		List<Staff> staffList = new ArrayList<>();
		String sql = "SELECT * FROM `staff`";
		Connection connection = null;
		try {
			connection = ConnectDB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Staff staff = new Staff();
				staff.setId(resultSet.getInt("id"));
				staffList.add(staff);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeQuietly(connection);
		}
		return staffList;
	}

	public static void main(String[] args) {
		StaffDTO staffDto = new StaffDTO();
		staffDto.getListStaff();
	}

}
