package com.qlnt.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qlnt.db.ConnectDB;
import com.qlnt.model.TypeProductModel;

public class TypeDTO {

	public static List<TypeProductModel> getListTypeProduct() {
		List<TypeProductModel> typeProductModels = new ArrayList<>();
		String sql = "SELECT * FROM `type_product`";
		Connection connection = null;
		try {
			connection = ConnectDB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				TypeProductModel model = new TypeProductModel(resultSet.getInt("id"), resultSet.getString("name_type"));
				typeProductModels.add(model);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeQuietly(connection);
		}
		return typeProductModels;
	}

	public static void main(String[] args) {
		TypeDTO typeDTO = new TypeDTO() ;
		typeDTO.getListTypeProduct();
	}

}
