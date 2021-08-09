package com.xworkz.delete.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamDeleteByIdTester {

	public static void main(String[] args) {

		String username = "root";
		String password = "Harsha@1";
		String url = "jdbc:mysql://localhost:3306/may_transformers";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Statement statement = connection.createStatement();
			String query = "DELETE FROM scam WHERE s_id = 20";
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}