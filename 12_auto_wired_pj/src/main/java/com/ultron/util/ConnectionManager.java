package com.ultron.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/jdc_class";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";
	
	

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
