package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.abstractClasses.UserDao;
import com.revature.concreteClasses.User;


public class UserDaoImplementation implements UserDao {

	private static final String USERNAME = "bank_db";
	private static final String PASSWORD = "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@octohumphrey.cnwfdjrtsq2o.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	
	
	@Override
	public  int createUser(User person) {
		int rowsAffected = 0;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
			
			connection.setAutoCommit(false);
			String sql = "INSERT INTO users(username,password,fname,lname) Values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,person.getUsername());
			ps.setString(2,person.getPassword());
			ps.setString(3,person.getFname());	
			ps.setString(4,person.getLname());	
			rowsAffected = ps.executeUpdate();
			connection.commit();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsAffected;
	}

	@Override
	public  List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
			connection.setAutoCommit(false);
			String sql = "SELECT * FROM users WHERE users_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
			connection.setAutoCommit(false);
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("USERS_ID"),rs.getString("USERNAME"),rs.getString("PASSWORD"),rs.getString("FNAME"),rs.getString("LNAME"));
			}
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	
	
	
	
	

}
