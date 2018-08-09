package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDaoImpl implements UserDao {
	

	public User getUserByUsername(String username) {
		// Going to contain code for JDBC
		User user = null;
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
