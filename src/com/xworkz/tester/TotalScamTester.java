package com.xworkz.tester;

import static com.xworkz.jdbc.constant.JdbcConstant.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TotalScamTester {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			connection.setAutoCommit(false);
			String query = "SELECT * FROM scam";
			Statement statement = connection.createStatement();
			statement.execute(query);
			connection.commit();
			ResultSet resultSet = statement.getResultSet();
			int count = 0;
			while (resultSet.next()) {
				count++;
			}
			System.out.println("Total scam = "+count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
