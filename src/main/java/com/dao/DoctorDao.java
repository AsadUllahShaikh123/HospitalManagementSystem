package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.entities.Doctor;

public class DoctorDao {

	public boolean registerDoctor(Doctor doctor) throws ClassNotFoundException, SQLException {
		boolean registered = false;
		
		Connection connection = DbConnection.getConnection();
		
		String sql = "insert into doctor (fullName, dob, qualification, specialist, email, mobile, password) values(?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, doctor.getFullName());
		statement.setString(2, doctor.getDate());
		statement.setString(3, doctor.getQualification());
		statement.setString(4, doctor.getSpecialist());
		statement.setString(5, doctor.getEmail());
		statement.setString(6, doctor.getMobile());
		statement.setString(7, doctor.getPassword());
		
		int i = statement.executeUpdate();
		if(i > 0 ) {
			registered = true;
		}
		return registered;
	}
	
	public List<Doctor> getAllDoctors() throws ClassNotFoundException, SQLException{
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor doctor ;
		Connection connection =  DbConnection.getConnection();
		String sql = "select * from doctor order by id desc";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			doctor = new Doctor();
			doctor.setId(result.getInt(1));
			doctor.setFullName(result.getString(2));
			doctor.setDate(result.getString(3));
			doctor.setQualification(result.getString(4));
			doctor.setSpecialist(result.getString(5));
			doctor.setEmail(result.getString(6));
			doctor.setMobile(result.getString(7));
			doctor.setPassword(result.getString(8));
			list.add(doctor);
			
		}
		return list;
	}
	
	public Doctor getDoctorById(int id) throws ClassNotFoundException, SQLException{
		Doctor doctor =null;
		Connection connection =  DbConnection.getConnection();
		String sql = "select * from doctor where id =? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id); 
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			doctor = new Doctor();
			doctor.setId(result.getInt(1));
			doctor.setFullName(result.getString(2));
			doctor.setDate(result.getString(3));
			doctor.setQualification(result.getString(4));
			doctor.setSpecialist(result.getString(5));
			doctor.setEmail(result.getString(6));
			doctor.setMobile(result.getString(7));
			doctor.setPassword(result.getString(8));
			
			
		}
		return doctor;
	}
	public boolean updateDoctor(Doctor doctor) throws ClassNotFoundException, SQLException {
		Connection connection = DbConnection.getConnection();
		
		boolean updated = false;
		
		String query = "update doctor set fullName=?,dob=?,qualification=?,specialist=?,email=?,mobile=?,password=? where id =? ";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, doctor.getFullName());
		statement.setString(2, doctor.getDate());
		statement.setString(3, doctor.getQualification());
		statement.setString(4, doctor.getSpecialist());
		statement.setString(5, doctor.getEmail());
		statement.setString(6, doctor.getMobile());
		statement.setString(7, doctor.getPassword());
		statement.setInt(8, doctor.getId());
		int id = statement.executeUpdate();
		System.out.println("Id :: " +id);
		if(id > 0) {
			System.out.println("Updated successfully");
			updated = true;
		}
	        
		
		return updated;
	}
	
	public boolean deleteDoctor(int id) throws ClassNotFoundException, SQLException {
		boolean deleted = false;
		
		Connection connection = DbConnection.getConnection();
		String query = "delete from doctor where id =? ";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		int i = statement.executeUpdate();
		if(i > 0)
			deleted = true;
		
		return deleted ;
	}
	
	public Doctor login(String email, String password) throws ClassNotFoundException, SQLException {
		Doctor doctor = null;
		Connection connection = DbConnection.getConnection();
		String query = "select * from doctor where email =? and password=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, email);
		statement.setString(2, password);
		
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			doctor= new Doctor();
			doctor.setId(result.getInt(1));
			doctor.setFullName(result.getString(2));
			doctor.setDate(result.getString(3));
			doctor.setQualification(result.getString(4));
			doctor.setSpecialist(result.getString(5));
			doctor.setEmail(result.getString(6));
			doctor.setMobile(result.getString(7));
			doctor.setPassword(result.getString(8));
		}
		
		return doctor;
	}
	
	
	
	
	
	
}
