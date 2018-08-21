package com.revature.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.User;

public class UserDaoImpl implements UserDao {
	
	//what do i need for a JDBC Connection?
	private final static String USERNAME = "todo_db";
	private final static String PASSWORD = "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com:1521:ORCL";
	//and the last thing? Driver which is the JAR for that specific database
	
	@Override
	public User getUserByUsername(String username) {
		// what is the method code going to contain?
		// try with resources::: opening a connection, when done with I'm going to go ahead and close. Anything in 
		//parenthesis must implement auto closeable 
		
		//System.err.println -------------review!
		User user = null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);  //precompiling the sql statement without the parameter values
		
			ps.setString(1,  username);
			//ps.executeQuery();
			ResultSet resultSet = ps.executeQuery();
			
			//don't need a loop.. username is unique in the db and should only return 1 record or none
			
			if(resultSet.next()) {
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)); 
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return user; //is this right?
	}

}
