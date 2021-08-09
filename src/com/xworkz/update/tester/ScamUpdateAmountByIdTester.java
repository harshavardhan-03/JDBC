package com.xworkz.update.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamUpdateAmountByIdTester {

	public static void main(String[] args) {
		
		String username = "root";
		String password = "Harsha123@";
		String url = "jdbc:mysql://localhost:3306/may_transformers";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Statement statement = connection.createStatement();
			String query = "UPDATE scam SET s_amount = '16,000 crore' WHERE s_id = 15";
			statement.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}