package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class JdbcTester {

	public static void main(String[] args) {

		String username = "root";
		String password = "Harsha123@";
		String url = "jdbc:mysql://127.0.0.1:3306/may_transformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(fqnOfDriverImpl); // Its Optional for use --it will load the class into memory
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
