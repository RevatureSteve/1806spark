package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.User;

public class UserDaoImpl implements UserDao{

	//what do I need for a JDBC Connection?
	private final static String USERNAME = "";
	private final static String PASSWORD = "";
	private final static String URL = "";
	//and the last thin? Driver which is the jar for that specific database
	
	@Override
	public User getUserByUsername(String username) {
		//what is this method code going to contain? JDBC code
		User user = null;
		try (Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);){
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql); //precompiling the SQL statement without the parameter values
			ps.setString(1, username);
			ResultSet resultSet = ps.executeQuery();
			//don't need a loop..username is unique in the db and should only return 1 record or none
			if(resultSet.next()){
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
