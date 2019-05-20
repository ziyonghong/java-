package com.zyh.day0917;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	public static Connection getConnection(String dbName) {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;

	}

	public static Connection getConnection() {
		return getConnection("");
	}
}
