package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;
import com.revature.singletons.LoggedUser;

public class UserDao {
	private static final String URL = "jdbc:oracle:thin:@marcin-salamon-oracle.ch2v7k2we1qt.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static final String USERNAME = "bank_db";
	private static final String PASSWORD = "p4ssw0rd";
	public List<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		try (Connection conn = DriverManager.getConnection(URL, LoggedUser.getUser().getUsername(),
				LoggedUser.getUser().getPassword());) {
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return users;
	}

	public User getUserBy(int id) {
		User user = null;
		try (Connection conn = DriverManager.getConnection(URL, LoggedUser.getUser().getUsername(),
				LoggedUser.getUser().getPassword());) {
			String sql = "SELECT * FROM users WHERE user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
}
