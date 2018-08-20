package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.interfaces.Dao;
import com.revature.pojo.Users;

public class UserDao implements Dao {

	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@mydbinstance.cu3okwucelpd.us-east-2.rds.amazonaws.com:1521:ORCL";

	@Override
	public int create(Object obj) {
		Users user = (Users) obj;
		int rowsAffected = 0;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "INSERT INTO users (username, password, fname, lname) VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			rowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsAffected;
	}

	@Override
	public List<Object> read() {

		List<Object> users = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public Users getUserByUserName(String username) {
		Users user = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM users WHERE username = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
