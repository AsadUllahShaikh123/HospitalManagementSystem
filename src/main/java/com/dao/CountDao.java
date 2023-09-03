package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountDao {

	Connection connection ;
	public CountDao(Connection connection ) {
		this.connection = connection;
	}
	
	public int countDoctor() throws SQLException {
		int count = 0 ;
		String query = "select * from doctor";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			count++;
		}
		return count;
	}
	public int countUser() throws SQLException {
		int count = 0 ;
		String query = "select * from user";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			count++;
		}
		return count;
	}
	public int countSpecialist() throws SQLException {
		int count = 0 ;
		String query = "select * from specialist";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			count++;
		}
		return count;
	}
	public int countAppointment() throws SQLException {
		int count = 0 ;
		String query = "select * from appointment";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			count++;
		}
		return count;
	}
	public int countAppointmentByDoctorId(int d_id) throws SQLException {
		int count = 0;
		String query = "select * from appointment where doctor_id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, d_id);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			count++;
		}
		return count ;
	}
}
