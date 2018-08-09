package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDaoImpl implements UserDao{


	// you need Driver which is the JAR for that specific
	
	@Override
	public User getUserByUsername(String username) {
		System.err.println("[LOG]---Starting----getUserByUsername() argument: " + username);
		//	Put JDBC here
		User user = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			System.err.println("[LOG]---inside try/catch----getUserByUsername() connection to db successful");
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			//pre-compiling SQL statement without the parameter values
			ps.setString(1, username);
			//this is what goes inside the ?
			ResultSet resultSet = ps.executeQuery();
			//no need a loop...username is unique in the db and should only return 1 record or none
			//ResultSet & executeQuery are only for SELECT
			System.err.println("[LOG]---ResultSet completed----getUserByUsername()");
			if (resultSet.next()) {
				System.err.println("[LOG]---ResultSet if----getUserByUsername() true");
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.err.println("[LOG]---Ending----getUserByUsername() returning: " + user);
		return user;
	}

}
