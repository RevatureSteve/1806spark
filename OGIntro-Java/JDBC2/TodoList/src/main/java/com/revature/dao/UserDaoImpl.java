package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.User;

public class UserDaoImpl implements UserDao {

	//what do I need for a JDBC Connection?
	private final static String USERNAME = "todo_db";
	private final static String PASSWORD = "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:octocat.ckichuqa168o.us-east-2.rds.amazonaws.com:1521:ORCL";
	// and the last thing? Driver
	
	@Override
	public User getUserByUsername(String username) {
		//what is this method code going to contain JDBC Code
		User user = null; //declare user at the proper scope
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			//when we are done with this try catch block it's gonna close the connection. must implement autoclosable
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);// precompiling SQL statement without the parameter value
			ps.setString(1, username);
			ResultSet resultSet = ps.executeQuery();
		// don't need a loop.. username is unique in the db and should only return 1 record or none
			if(resultSet.next()) {
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
				//1 = u_id, 2 = username, 3 = pw converted from a database record to a java object
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
