package com.qlnt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.qlnt.constant.Constant;

public class ConnectDB {
	private static Connection connection;

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (connection == null || connection.isClosed()) {
			return getMySQLConnection(Constant.HOST_NAME, Constant.DB_NAME, Constant.USER_NAME, Constant.PASSWORD);
		} else {
			return connection;
		}
	}

	public static void closeQuietly(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String connectionURL = String.format("jdbc:mysql://%s:3306/%s?useUnicode=true&characterEncoding=utf-8",
				hostName, dbName);
		connection = DriverManager.getConnection(connectionURL, userName, password);
		return connection;
	}

}
