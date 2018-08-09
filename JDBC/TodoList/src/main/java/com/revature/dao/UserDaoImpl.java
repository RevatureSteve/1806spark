package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDaoImpl implements UserDao {
	
	@Override
	public User getUserByUsername(String username) {
		System.err.println("[LOG]---Starting----getUserByUsername() argument: " + username);
		// what is this method code going to contain? JDBC Code
		User user = null;

		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			System.err.println("[LOG]---inside try/catch---getUserByUser() db connection success");
			String sql = "Select * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);//precompiling the sql statement without the parameter values
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			
			//don't need a loop. . username is unique in the db and should only return 1 record or none
			System.err.println("[LOG]---resultset completed---getUserByUser()");
			if (rs.next()) {
				System.err.println("[LOG]---resultsert if---getUserByUser() is true");
				user = new User(rs.getInt("u_id"), rs.getString("username"), rs.getString("password"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.err.println("[LOG]---resultset if---getUserByUser() returning: " + user);
		return user;
	}

	
	
	
}
