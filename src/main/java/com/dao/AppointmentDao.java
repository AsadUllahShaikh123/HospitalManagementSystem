package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
