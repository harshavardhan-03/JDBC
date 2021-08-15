package com.xworkz.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.customer.constant.Education;
import com.xworkz.customer.dto.CustomerDTO;

import static com.xworkz.customer.constant.JdbcConstant.*;

public class CustomerDAOimpl implements CustomerDAO {

	@Override
	public int save(CustomerDTO dto) {
		int aiId = 0;
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "INSERT INTO customer_table(c_name, c_from, c_to, c_address, c_married, c_passport_no, c_education) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, dto.getName());
			statement.setString(2, dto.getFrom());
			statement.setString(3, dto.getTo());
			statement.setString(4, dto.getAddress());
			statement.setBoolean(5, dto.isMarried());
			statement.setInt(6, dto.getPassportNo());
			statement.setString(7, dto.getEducation().toString());
			statement.execute();
			ResultSet resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				aiId = resultSet.getInt(1);
			}
			dto.setId(aiId);
			connection.commit();
			System.out.println(dto);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return aiId;
	}

	@Override
	public void saveAll(Collection<CustomerDTO> collection) {
		Collection<CustomerDTO> col = new ArrayList<>();
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "INSERT INTO customer_table(c_name, c_from, c_to, c_address, c_married, c_passport_no, c_education) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			collection.forEach(dto -> {
				int aiId = 0;
				try {
					statement.setString(1, dto.getName());
					statement.setString(2, dto.getFrom());
					statement.setString(3, dto.getTo());
					statement.setString(4, dto.getAddress());
					statement.setBoolean(5, dto.isMarried());
					statement.setInt(6, dto.getPassportNo());
					statement.setString(7, dto.getEducation().toString());
					statement.execute();
					ResultSet resultSet = statement.getGeneratedKeys();
					if (resultSet.next()) {
						aiId = resultSet.getInt(1);
					}
					dto.setId(aiId);
				} catch (Exception e) {
					e.printStackTrace();
				}
				col.addAll(collection);
			});
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		System.out.println("find one with predicate");
		Optional<CustomerDTO> opt = Optional.empty();
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String query = "SELECT * FROM customer_table";
			PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			while (resultSet.next()) {
				int id = resultSet.getInt("c_id");
				String name = resultSet.getString("c_name");
				String from = resultSet.getString("c_from");
				String to = resultSet.getString("c_to");
				String address = resultSet.getString("c_address");
				boolean married = resultSet.getBoolean("c_married");
				int passportNo = resultSet.getInt("c_passport_no");
				String education = resultSet.getString("c_education");
				CustomerDTO dto = new CustomerDTO(name, from, to, address, married, passportNo,
						Education.valueOf(education));
				dto.setId(id);
				if (predicate.test(dto)) {
					opt = Optional.of(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return opt;
	}

	@Override
	public Collection<CustomerDTO> findAll() {
		System.out.println("find all");
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String query = "SELECT * FROM customer_table";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			while (resultSet.next()) {
				int id = resultSet.getInt("c_id");
				String name = resultSet.getString("c_name");
				String from = resultSet.getString("c_from");
				String to = resultSet.getString("c_to");
				String address = resultSet.getString("c_address");
				boolean married = resultSet.getBoolean("c_married");
				int passportNo = resultSet.getInt("c_passport_no");
				String education = resultSet.getString("c_education");
				CustomerDTO dto = new CustomerDTO(name, from, to, address, married, passportNo,
						Education.valueOf(education));
				dto.setId(id);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {
		System.out.println("findAll with predicate");
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String query = "SELECT * FROM customer_table";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			while (resultSet.next()) {
				int id = resultSet.getInt("c_id");
				String name = resultSet.getString("c_name");
				String from = resultSet.getString("c_from");
				String to = resultSet.getString("c_to");
				String address = resultSet.getString("c_address");
				boolean married = resultSet.getBoolean("c_married");
				int passportNo = resultSet.getInt("c_passport_no");
				String education = resultSet.getString("c_education");
				CustomerDTO dto = new CustomerDTO(name, from, to, address, married, passportNo,
						Education.valueOf(education));
				dto.setId(id);
				if (predicate.test(dto)) {
					collection.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {
		System.out.println("findAllSortByNameDesc");
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String query = "SELECT * FROM customer_table ORDER BY c_name DESC";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			while (resultSet.next()) {
				int id = resultSet.getInt("c_id");
				String name = resultSet.getString("c_name");
				String from = resultSet.getString("c_from");
				String to = resultSet.getString("c_to");
				String address = resultSet.getString("c_address");
				boolean married = resultSet.getBoolean("c_married");
				int passportNo = resultSet.getInt("c_passport_no");
				String education = resultSet.getString("c_education");
				CustomerDTO dto = new CustomerDTO(name, from, to, address, married, passportNo,
						Education.valueOf(education));
				dto.setId(id);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public int total() {
		int count = 0;
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String query = "SELECT count(*) FROM customer_table";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			System.out.println("Total Customer : ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}