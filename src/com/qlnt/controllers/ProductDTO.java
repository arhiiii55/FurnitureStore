package com.qlnt.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qlnt.db.ConnectDB;
import com.qlnt.model.Product;
import com.qlnt.model.Storage;
import com.qlnt.model.TypeProductModel;

public class ProductDTO {

	public static List<Product> getListProduct() {
		List<Product> products = new ArrayList<>();
		String sql = "SELECT * FROM `product` AS p INNER JOIN `storage` AS s ON p.store_id = s.id INNER JOIN `type_product` AS tp ON p.type_id = tp.id";
		Connection connection = null;
		try {
			connection = ConnectDB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setBrand(resultSet.getString("brand"));
				product.setQuantity(resultSet.getInt("quantity"));
				product.setPrice(resultSet.getInt("price"));
				TypeProductModel typeProductModel = new TypeProductModel();
				typeProductModel.setId(resultSet.getInt("type_id"));
				typeProductModel.setNameType(resultSet.getString("name_type"));
				product.setTypeProduct(typeProductModel);
				Storage storage = new Storage();
				storage.setId(resultSet.getInt("store_id"));
				storage.setSumProduct(resultSet.getInt("quantity_sum_product"));
				storage.setArea(resultSet.getString("area"));
				product.setStorage(storage);
				products.add(product);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeQuietly(connection);
		}
		return products;
	}

	public static boolean insertProduct(int id, String name, int storeId, int typeId, String brand, int quantity,
			int price) {
		boolean result = false;
		String sql = "INSERT INTO `product` (id,name,store_id,type_id,brand,quantity,price) VALUES (?,?,?,?,?,?,?);";
		Connection connection = null;
		try {
			connection = ConnectDB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, storeId);
			preparedStatement.setInt(4, typeId);
			preparedStatement.setString(5, brand);
			preparedStatement.setInt(6, quantity);
			preparedStatement.setInt(7, price);
			preparedStatement.executeUpdate();
			result = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeQuietly(connection);
		}
		return result;
	}

	public static boolean updateProduct(int id, String name, int storeId, int typeId, String brand, int quantity,
			int price) {
		boolean result = false;
		String sql = "UPDATE `product` SET name = ?, store_id = ?, type_id = ?, brand = ?, quantity = ?,price = ? WHERE id = ?";
		Connection connection = null;
		try {
			connection = ConnectDB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, storeId);
			preparedStatement.setInt(3, typeId);
			preparedStatement.setString(4, brand);
			preparedStatement.setInt(5, quantity);
			preparedStatement.setInt(6, price);
			preparedStatement.setInt(7, id);
			preparedStatement.executeUpdate();
			result = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeQuietly(connection);
		}
		return result;
	}

	public static boolean deleteProductById(int id) {
		boolean result = false;
		String sql = "DELETE FROM `product` WHERE id = ?";
		Connection connection = null;
		try {
			connection = ConnectDB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
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
