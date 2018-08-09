package com.cpo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cpo.beans.User;

public class UserDatabaseDao implements UserDao, DatabaseDao {
	//TODO: Make this into a singleton
	
	private static UserDatabaseDao instance;
	
	
	private UserDatabaseDao() {
	}
	
	public static UserDatabaseDao getInstance() {
		if (instance == null) {
			instance = new UserDatabaseDao();
		}
		return instance;
	}

	@Override
	public int createUser(User user) {
		
		int rowsAffected = 0;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "INSERT INTO users(fname, lname, username, password) VALUES (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql); //Will first take in your sql code without variable (variable place holder
			//Now need to register parameters of the SQL statement
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			rowsAffected = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
	}

	@Override
	public User getUser(String username, String password) {
		User user =  null;
		
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);) {
			String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {				
				user = new User(rs.getInt(1),rs.getString("fname"),rs.getString("lname"),rs.getString("username"),rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
