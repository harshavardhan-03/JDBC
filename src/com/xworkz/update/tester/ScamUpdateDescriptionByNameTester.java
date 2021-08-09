package com.xworkz.update.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamUpdateDescriptionByNameTester {

	public static void main(String[] args) {

		String username = "root";
		String password = "Harsha123@";
		String url = "jdbc:mysql://localhost:3306/may_transformers";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Statement statement = connection.createStatement();
			String query = "UPDATE scam SET s_description = 'He cheated various banks of over 9000 crore which he had taken has a loan' WHERE s_name = 'Vijay Mallya Scam'";
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}