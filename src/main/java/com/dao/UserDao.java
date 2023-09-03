package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DbConnection;
import com.entities.User;

public class UserDao {

	public boolean userRegister(User user) throws ClassNotFoundException, SQLException {

		boolean registered = false;
		Connection connection = DbConnection.getConnection();
		String query = "insert into user (name,email,password) values (?,?,?)";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getPassword());

		int i = statement.executeUpdate();
		if (i == 1) {
			registered = true;
		}

		return registered;
	}

	public User userLogin(String email, String password) throws SQLException, ClassNotFoundException {
		Connection connection = DbConnection.getConnection();
		User user = null;

		String sql = "select * from user where email=? and password=? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, email);
		statement.setString(2, password);

		ResultSet result = statement.executeQuery();
		while (result.next()) {
			user = new User();
			user.setId(result.getInt(1));
			user.setName(result.getString(2));
			user.setEmail(result.getString(3));
			user.setPassword(result.getString(4));

		}
		return user;
	}

	public boolean checkOldPassword(int userId, String oldPassword) {
		Connection connection;
		PreparedStatement statement;
		boolean checked = false;
		String query = "select * from user where id=? and password=?";
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, userId);
			statement.setString(2, oldPassword);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				checked = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		

		
		return checked;
	}

	public boolean changePassword(int userId, String password) {
		Connection connection;
		String query = "update user set password=? where id=?";
		PreparedStatement statement;
		int updated = 0;
		boolean changed = false;
		try {
			connection = DbConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, password);
			statement.setInt(2, userId);
			updated = statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (updated > 0) {
			changed = true;
		}
		return changed;
	}

}
