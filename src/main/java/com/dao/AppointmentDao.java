package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.entities.Appointment;

public class AppointmentDao {

	public boolean addAppointment(Appointment appointment) throws ClassNotFoundException, SQLException {
		boolean added = false;
		Connection connection = DbConnection.getConnection();
		String query = "insert into appointment(user_id, fullName, gender, age, appoint_date, email, "
				+ "phone, diseases, doctor_id, address, status) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, appointment.getUserId());
		statement.setString(2, appointment.getFullName());
		statement.setString(3, appointment.getGender());
		statement.setString(4,appointment.getAge());
		statement.setString(5, appointment.getAppointDate());
		statement.setString(6, appointment.getEmail());
		statement.setString(7, appointment.getPhoneNo());
		statement.setString(8, appointment.getDiseases());
		statement.setInt(9, appointment.getDoctorId());
		statement.setString(10,appointment.getAddress());
		statement.setString(11,appointment.getStatus());
		
		int result = statement.executeUpdate();
		if(result > 0) {
			added = true;
		}
		
		return added;
	}
	
	public List<Appointment> getAllAppointmentByLoginUser(int userId) throws SQLException, ClassNotFoundException{
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment appointment = null;
		Connection connection = DbConnection.getConnection();
		String query ="select * from appointment where user_id =? ";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, userId);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			appointment = new Appointment();
			appointment.setId(result.getInt(1));
			appointment.setUserId(result.getInt(2));
			appointment.setFullName(result.getString(3));
			appointment.setGender(result.getString(4));
			appointment.setAge(result.getString(5));
			appointment.setAppointDate(result.getString(6));
			appointment.setEmail(result.getString(7));
			appointment.setPhoneNo(result.getString(8));
			appointment.setDiseases(result.getString(9));
			appointment.setDoctorId(result.getInt(10));
			appointment.setAddress(result.getString(11));
			appointment.setStatus(result.getString(12));
			list.add(appointment);
			System.out.println("Running ....");
		}
		return list;
	}
	
	
	public List<Appointment> getAllAppointmentByDoctorUser(int doctorId) throws SQLException, ClassNotFoundException{
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment appointment = null;
		Connection connection = DbConnection.getConnection();
		String query ="select * from appointment where doctor_id =? ";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, doctorId);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			appointment = new Appointment();
			appointment.setId(result.getInt(1));
			appointment.setUserId(result.getInt(2));
			appointment.setFullName(result.getString(3));
			appointment.setGender(result.getString(4));
			appointment.setAge(result.getString(5));
			appointment.setAppointDate(result.getString(6));
			appointment.setEmail(result.getString(7));
			appointment.setPhoneNo(result.getString(8));
			appointment.setDiseases(result.getString(9));
			appointment.setDoctorId(result.getInt(10));
			appointment.setAddress(result.getString(11));
			appointment.setStatus(result.getString(12));
			list.add(appointment);
		}
		return list;
	}
	
	
	
	
	
	
}
