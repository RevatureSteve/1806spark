package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.Users;


public class UsersDaoImpl implements UsersDao {
	
	private final static String  USERNAME = "tyler_ers";
	private final static String  PASSWORD = "p4ssw0rd";
	private final static String  URL = "jdbc:oracle:thin:@tylertraining.cnmoc1mujdcw.us-east-2.rds.amazonaws.com:1521:ORCL"; 
			
	
	
	@Override
	public Users getUserByEmail(String email) {
		
		Users user = null;
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				user = new Users(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}

}
