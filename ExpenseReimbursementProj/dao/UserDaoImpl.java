package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.User;
import com.revature.util.SetConnectionProperties;

public class UserDaoImpl implements UserDao{

	
	
	//What do I need for a JDBC Connection
	private final static String USERNAME = "";
	private final static String PASSWORD = "";
	private final static String URL = "";
	// and the DRIVER which is the JAR for that specific 
	
	@Override
	public User getUserByUsername(String username) {
		System.err.println("[LOG]-------Starting--------getUserByUsername() arguement: " + username);
		User user=null;
		//What is the method code going to contain? JDBC Code!
		
		try(Connection conn = SetConnectionProperties.getConnection()) {
			System.err.println("[LOG]-------Inside try/catch--------getUserByUsername() connection to db success arguement: " + username);
			String sql = "SELECT * FROM users WHERE username= ?";
			PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
			ps.setString(1, username);
			ResultSet resultSet = ps.executeQuery();
			// don't need to do a loop... username is unique, will only return 1 record
			System.err.println("[LOG]-------resultset completed--------getUserByUsername() arguement: " + username);
			if(resultSet.next()) {
				System.err.println("[LOG]-------Resultset IF--------getUserByUsername() arguement: " + username);
				user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.err.println("[LOG]-------Ending--------returning: " + user);
		return user;
	}
	
	
	
	
	
	
	
	
	

}
