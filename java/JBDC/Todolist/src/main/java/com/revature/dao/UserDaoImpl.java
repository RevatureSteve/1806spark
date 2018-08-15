/**
 * 
 */
package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.User;

/**
 * @author sethc
 *
 */
public  class UserDaoImpl implements UserDao {

	//what do i need for JDBC connection?
	private final static String USERNAME ="task_db";
	private final static String PASSWORD = "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@octocat.czuadbiw1r4y.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	@Override
	public User getUserByUsernamw(String username) {
		System.err.println("[Log]---Starting -------getUserByUser()  argument: " + username);
		// TODO Auto-generated method stub
		
		// what is the method code going to contain? jbdc code 
		User user = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); ) {
			System.err.println("[Log]---Starting ---in try catch----getUserByUser()  argument: " + username);
			//connection change to java.sql
			String sql = "Select * from users where username = ?";
															//ps get this question
			PreparedStatement ps = conn.prepareStatement(sql); // precompiling SQL without the parameter value values
			ps.setString(1, username);
			// w.e username pass in will be ps getting the value from the ? 
			ResultSet resultSet = ps.executeQuery();
			// this return a result set
			
			//  dont need to add a loop.. username is unique in the db and should only return 1 record or more
			
			if(resultSet.next()) {
				System.err.println("[Log]---Starting ---resultset----getUserByUser()  argument: " + username);
			user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			//declare user scope	//int1 is result u_id   //username          // bring back last comlumn in database
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("[Log]---Starting ----return user---getUserByUser()  argument: " + username);
		return user;
	}
	
	

}
