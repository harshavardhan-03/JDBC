package com.xworkz.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTester {

	public static void main(String[] args) {

		String username = "root";
		String password = "Harsha@1";
		String url = "jdbc:mysql://localhost:3306/may_transformers";
		
		// protocol:vendor://hostname(ipaddress):port/schema_name
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";
		// java.jdbc.Driver --> com.mysql.cj.jdbc.Driver

		try {
			Class.forName(fqnOfDriverImpl);
			Connection connection = DriverManager.getConnection(url, username, password);
			String query1 = "INSERT INTO insurance_table values(1, 'Anushasri KS', 'Wealth', 5, 'ICICI', 120000)";
			String query2 = "INSERT INTO insurance_table values(2, 'Harsha', 'Car', 3, 'Max Life', 45680)";
			String query3 = "INSERT INTO insurance_table values(3, 'Sahana', 'Property', 20, 'SBI', 200000)";
			String query4 = "INSERT INTO insurance_table values(4, 'Teju', 'Property', 15, 'ICICI', 305000)";
			String query5 = "INSERT INTO insurance_table values(5, 'Rakshitha', 'Car', 2, 'Max Life', 50000)";
			Statement statement = connection.createStatement();
			statement.execute(query1);
			statement.execute(query2);
			statement.execute(query3);
			statement.execute(query4);
			statement.execute(query5);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}