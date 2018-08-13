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

	// and the last thing? Driver which is the JAR for that specific database
	
	@Override
	public User getUserByUsername(String username) {
		
		System.err.println("[LOG]---Starting----getUserByUser() argument: " + username); 
		// what is this method code going to contain? JDBC Code
		
		User user = null;
		try(Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			System.err.println("[LOG]---inside try/catch----getUserByUser() connection to db successful"); 
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql); // precompiling the SQL statement without the parameter values
			ps.setString(1, username);
			ResultSet resultSet = ps.executeQuery();
			System.err.println("[LOG]---resultset completed----getUserByUser()"); 
			// don't need a loop... username is unique in the db and should only return 1 record or none
			if(resultSet.next()) {
				System.err.println("[LOG]---resultSet----getUserByUser()"); 
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.err.println("[LOG]---Ending"); 
		return user;
	}

}
