package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.domain.User;
import com.revature.exceptions.DatabaseRetrievalFailure;
import com.revature.util.SetConnectionPropertiesUtil;

public class UsersDaoImpl implements UsersDao {

	public ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();

		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "SELECT * FROM users INNER JOIN position ON position.pos_id = users.pos_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				users.add(new User(rs.getInt("u_id"), rs.getString("email"), rs.getString("password"),
						rs.getString("fname"), rs.getString("lname"), rs.getInt("pos_id"), rs.getString("pos_type")));
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
						rs.getString("fname"), rs.getString("lname"), rs.getInt("pos_id"), rs.getString("pos_type"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (user == null) {
			throw new DatabaseRetrievalFailure();
		}
		return user;
	}

	@Override
	public int updateUserInfo(int id, String email, String psw, String fname, String lname) {
		int rowsAffected = 0;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "{updateUser(?,?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.setString(2, email);
			cs.setString(3, psw);
			cs.setString(4, fname);
			cs.setString(5, lname);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
}
