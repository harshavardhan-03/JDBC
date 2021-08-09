package com.xworkz.tester;

import static com.xworkz.jdbc.constant.JdbcConstant.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.dto.ScamDTO;

public class ScamOrderedByNameTester {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String query = "SELECT * FROM scam ORDER BY s_name";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet resultSet = statement.getResultSet();
			ScamDTO dto = null;
			while (resultSet.next()) {
				connection.setAutoCommit(false);
				int anu = resultSet.getInt("s_id");
				String sha = resultSet.getString("s_name");
				String type = resultSet.getString("s_type");
				Date year = resultSet.getDate("s_year");
				String by = resultSet.getString("s_by");
				double amount = resultSet.getDouble("s_amount");
				String location = resultSet.getString("s_location");
				String description = resultSet.getString("s_description");
				dto = new ScamDTO(anu, sha, type, year, by, amount, location, description);
				System.out.println(dto);
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}