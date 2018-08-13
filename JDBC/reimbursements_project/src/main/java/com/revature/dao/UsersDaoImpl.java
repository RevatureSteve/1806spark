package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.revature.domain.User;
import com.revature.exceptions.DatabaseRetrievalFailure;
import com.revature.util.SetConnectionPropertiesUtil;

public class UsersDaoImpl implements UsersDao {

	private static final String URL = "";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";

	public ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			String sql = "SELECT * FROM users INNER JOIN position ON position.pos_id = users.pos_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				users.add(new User(rs.getInt("u_id"), rs.getString("email"), rs.getString("password"),
						rs.getString("fname"), rs.getString("lname"),rs.getInt("pos_id") ,rs.getString("pos_type")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return users;
	}

	public User getUserByUsername(String username) throws DatabaseRetrievalFailure {
		User user = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			String sql = "SELECT * FROM users INNER JOIN position ON position.pos_id = users.pos_id WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt("u_id"), rs.getString("email"), rs.getString("password"),
						rs.getString("fname"), rs.getString("lname"),rs.getInt("pos_id") ,rs.getString("pos_type"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (user == null) {
			throw new DatabaseRetrievalFailure();
		}
		return user;
	}
}
