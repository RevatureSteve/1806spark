package com.revature.dao;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.domain.User;
import com.revature.util.DbConnection;

public class UserDaoImpl implements UserDao{

	
	@Override
	public User getUserByEmail(String email) {
		User user=null;
		//What is the method code going to contain? JDBC Code!
		
		try(Connection conn = DbConnection.getConnection()) {
			String sql = "SELECT * FROM users WHERE email= ?";
			PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
//				user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	
	
	
	
	
	

}
