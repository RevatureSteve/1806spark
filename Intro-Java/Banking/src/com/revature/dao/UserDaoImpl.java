package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;
import com.revature.singletons.LoggedUser;

public class UserDaoImpl implements UserDao{
	private static final String URL = "jdbc:oracle:thin:@marcin-salamon-oracle.ch2v7k2we1qt.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static final String USERNAME = "bank_db";
	private static final String PASSWORD = "p4ssw0rd";

	public List<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
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
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
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

	public int insertUser(User user) {
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call create_new_user(?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, user.getUsername());
			cs.setString(2, user.getPassword());
			cs.setString(3, user.getFirstname());
			cs.setString(4, user.getLastname());
			rowsAffected =  cs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
}
