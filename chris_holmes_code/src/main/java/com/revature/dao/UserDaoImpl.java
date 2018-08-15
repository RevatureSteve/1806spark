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
	
	@Override
	public User getUserbyEmail(String email) {
		System.err.println("[LOG]--Starting---getUserByUsername() argument:" + email);
		User user = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			System.err.println("[LOG]---inside try/catch----getUserByEmail() connection to db successful");
			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql); // Precompiles the sql statement without the parameter values
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();
		// we do not need a loop because emails are unique
			System.err.println("[LOG]---resultset completed----getUserByEmail()");
			if(resultSet.next()) {
				System.err.println("[LOG]---resultset if----getUserByEmail() true!");
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("[LOG]---Ending----getUserByEmail() returning: " + user);
	}
	
	

}
