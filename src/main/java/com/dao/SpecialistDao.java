package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.entities.Specialist;

public class SpecialistDao {

	public boolean addSpecialist(String specialistName) throws ClassNotFoundException, SQLException {
		
		Connection connection = DbConnection.getConnection();
		boolean added = false;
		
		String sql = "insert into specialist(spec_name) values(?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,specialistName);
		
		int i = statement.executeUpdate();
		if(i >0) {
			added = true;
		}
		
		return added;
	}
	
	public List<Specialist> getAllSpecialist() throws ClassNotFoundException, SQLException{
		
		Connection connection = DbConnection.getConnection();
		List<Specialist> list = new ArrayList<Specialist>();
		Specialist s = null;
		
		String sql = " select * from specialist";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			s = new Specialist();
			s.setId(result.getInt(1));
			s.setSpecialistName(result.getString(2));
			list.add(s);
		}
		return list;
	}
}
