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
		statement.setString(1,user.getName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getPassword());
		
		int i = statement.executeUpdate();
		if(i == 1 ) {
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
		while(result.next()) {
			user = new User();
			user.setId(result.getInt(1));
			user.setName(result.getString(2));
			user.setEmail(result.getString(3));
			user.setPassword(result.getString(4));
			
		}
		return user;
	}
	
}
