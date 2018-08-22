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
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@hearthstone.cxazmpz2rlnm.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	@Override
	public List<User> readUser() {
		List<User> users = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			//pre-compiling SQL statement without the parameter values
			ResultSet rs = ps.executeQuery();
			//Use ResultSet and executeQuery for SELECT
			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)); 
				users.add(user);
				//loop through and select users from the table and add them to the list
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}