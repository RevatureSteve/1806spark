package com.revature.dao;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.Task;
import com.revature.domain.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDaoImpl implements UserDao{


	@Override							
	public User getUserByUsername(String username) {
		System.err.println("[LOG]---Starting----getUserByUsername() argument: " + username);
		// what is this method code going to contain? JDBC Code
		User user = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			System.err.println("[LOG]---inside try/catch----getUserByUsername() connection to db successful");
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql); // precompiling SQL statement without the parameter values
			ps.setString(1, username);
			ResultSet resultSet = ps.executeQuery();
	// don't need a loop..username is unique in the db and should only return 1 record or none
			System.err.println("[LOG]---resultset completed----getUserByUsername()");
			if( resultSet.next() ) {
				System.err.println("[LOG]---resultset if----getUserByUsername() true! ");
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.err.println("[LOG]---Ending----getUserByUser() returning: " + user);
		return user;
	}
	
//	public List<Task> getAllTasks(){
//		// ia am in dao so ican write jdbc logic to communciate wwith a database
//		
//		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
//			String sql = "select * from task";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next() ) {
//				tasks.add(new Task(rs.getInt("t_id"),rs.getInt("u_id"), rs.getString("T_name"),rs.getInt("ts_id")));
//			}
//			
//		}
//	}

}
