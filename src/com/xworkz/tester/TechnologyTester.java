package com.xworkz.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TechnologyTester {

	public static void main(String[] args) {

		String username = "root";
		String password = "Harsha@1";
		String url = "jdbc:mysql://localhost:3306/may_transformers";
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			String query1 = "INSERT INTO technology VALUES(2, 'JAVA', 'James Gosling', 1995, 'Java SE 16')";
			String query2 = "INSERT INTO technology VALUES(3, 'Java script', 'Brendan Eich', 1995, 'ES6')";
			String query3 = "INSERT INTO technology VALUES(1, 'HTML', 'Tim Berners-Lee', 1993, 'HTML 5.3')";
			String query4 = "INSERT INTO technology VALUES(4, 'SQL', 'Donald D. Chamberlin & Raymond F. Boyce', 1974, '15.0')";
			statement.execute(query1);
			statement.execute(query2);
			statement.execute(query3);
			statement.execute(query4);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}