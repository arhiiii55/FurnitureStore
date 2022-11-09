package com.qlnt.controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qlnt.db.ConnectDB;
import com.qlnt.model.Inspection;
import com.qlnt.model.Product;
import com.qlnt.model.Staff;

public class InspectionDTO {

	public static List<Inspection> getListInspection() {
		List<Inspection> inspections = new ArrayList<>();
		String sql = "SELECT * FROM `inspection` AS i INNER JOIN `staff` AS s ON i.id_staff = s.id INNER JOIN `product` AS p ON i.id_product = p.id";
		Connection connection = null;
		try {
			connection = ConnectDB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Inspection inspection = new Inspection();
				inspection.setId(resultSet.getInt("id"));
				Staff staff = new Staff();
				staff.setId(resultSet.getInt("id_staff"));
				staff.setFullNameString(resultSet.getString("fullname"));
				staff.setPhoneNumber(resultSet.getString("phone_number"));
				inspection.setStaff(staff);
				Product product = new Product();
				product.setId(resultSet.getInt("id_product"));
				product.setName(resultSet.getString("name"));
				product.setBrand(resultSet.getString("brand"));
				product.setQuantity(resultSet.getInt("quantity"));
				product.setPrice(resultSet.getInt("price"));
				inspection.setProduct(product);
				inspection.setCheckStatus(resultSet.getString("check_status"));
				inspection.setCheckDate(resultSet.getDate("date_check"));
				inspections.add(inspection);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeQuietly(connection);
		}
		return inspections;
	}

	public static boolean insertInspection(int idStaff, int idProduct, String checkStatus, Date dateCheck) {
		boolean result = false;
		String sql = "INSERT INTO `inspection` (id_staff,id_product,check_status,date_check) VALUES (?,?,?,?);";
		Connection connection = null;
		try {
			connection = ConnectDB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idStaff);
			preparedStatement.setInt(2, idProduct);
			preparedStatement.setString(3, checkStatus);
			preparedStatement.setDate(4, dateCheck);
			preparedStatement.executeUpdate();
			result = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeQuietly(connection);
		}
		return result;
	}

	public static boolean updateInspection(int id, String checkStatus) {
		boolean result = false;
		String sql = "UPDATE `inspection` SET check_status = ? WHERE id = ?";
		Connection connection = null;
		try {
			connection = ConnectDB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, checkStatus);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			result = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeQuietly(connection);
		}
		return result;
	}
}
