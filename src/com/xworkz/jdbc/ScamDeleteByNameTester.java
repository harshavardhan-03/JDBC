package com.xworkz.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamDeleteByNameTester {

	public static void main(String[] args) {

		String username = "root";
		String password = "Anusha@1";
		String url = "jdbc:mysql://localhost:3306/anushasri_ks";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Statement statement = connection.createStatement();
			String query = "DELETE FROM scam WHERE s_name = 'Social Media Scam'";
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}