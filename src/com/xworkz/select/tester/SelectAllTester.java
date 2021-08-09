package com.xworkz.select.tester;

import static com.xworkz.jdbc.constant.JdbcConstant.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.dto.ScamDTO;

public class SelectAllTester {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String query = "SELECT * FROM scam WHERE s_amount >= 10000";
			Statement statement = connection.createStatement();
			statement.execute(query);
			ResultSet resultSet = statement.getResultSet();
			ScamDTO dto = new ScamDTO();
			while (resultSet.next()) {
				dto.setAmount(resultSet.getDouble("s_amount"));
				int id = resultSet.getInt("s_id");
				String name = resultSet.getString("s_name");
				String type = resultSet.getString("s_type");
				Date year = resultSet.getDate("s_year");
				String by = resultSet.getString("s_by");
				double amount = resultSet.getDouble("s_amount");
				String location = resultSet.getString("s_location");
				String description = resultSet.getString("s_description");
				dto = new ScamDTO(id, name, type, year, by, amount, location, description);
				System.out.println(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}