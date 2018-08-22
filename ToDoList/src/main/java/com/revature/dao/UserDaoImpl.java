package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Task;
import com.revature.domain.User;
import com.revature.util.SetConnectionProperties;

public class UserDaoImpl implements UserDao{

	
	
	// and the DRIVER which is the JAR for that specific 
	
	@Override
	public User getUserByUsername(String username) {
		System.err.println("[LOG]-------Starting--------getUserByUsername() arguement: " + username);
		User user=null;
		//What is the method code going to contain? JDBC Code!
		
		try(Connection conn = SetConnectionProperties.getConnection()) {
			System.err.println("[LOG]-------Inside try/catch--------getUserByUsername() connection to db success arguement: " + username);
			String sql = "SELECT * FROM users WHERE username= ?";
			PreparedStatement ps = conn.prepareStatement(sql); //pre-compiling the sql statement without the parameter values
			ps.setString(1, username);
			ResultSet resultSet = ps.executeQuery();
			// don't need to do a loop... username is unique, will only return 1 record
			System.err.println("[LOG]-------resultset completed--------getUserByUsername() arguement: " + username);
			if(resultSet.next()) {
				System.err.println("[LOG]-------Resultset IF--------getUserByUsername() arguement: " + username);
				user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.err.println("[LOG]-------Ending--------returning: " + user);
		return user;
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList();
		try(Connection conn = SetConnectionProperties.getConnection()) {
			
			String sql = "SELECT * FROM task";
			PreparedStatement ps =conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tasks.add(new Task(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),null));
				
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return tasks;
	}

	@Override
	public List<Task> getTasksByUserId(int id) {
		List<Task> tasks = new ArrayList();
		
		try(Connection conn = SetConnectionProperties.getConnection()) {
			
			String sql = "SELECT * FROM task WHERE u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				tasks.add(new Task(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),null));
			}
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tasks;
	}
	
	
	
	
	
	
	
	
	

}
