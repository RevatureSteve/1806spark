package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.User;

public class UserDaoImpl implements UserDao {
	
	private final static String USERNAME = "revaturenisat";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@blackcat.cob89bumroku.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	@Override
	public int createUser(User u) {
		return 0;
	}
	
	@Override
	public void createUserProc(User u) {
		
	}
	
	@Override
	public List<User> readUser() {
		
		List<User> users = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				User user = new User(resultSet.getInt(1), resultSet.getString(4), resultSet.getString(5), resultSet.getString(2), resultSet.getString(3)); 
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Oops, something went wrong. Pray for deliverance.");
		}
		return users;
	}
	
	@Override
	public User getUserById(int id) {
		return null;
	}

	@Override
	public int updateUser(User u) {
		return 0;
	}

	@Override
	public List<User> readUser(String URL, String USERNAME, String PASSWORD) {
		return null;
	}

}
