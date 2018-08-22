package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD

=======
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Task;
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
import com.revature.domain.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDaoImpl implements UserDao{


<<<<<<< HEAD
	@Override							
	public User getUserByUsername(String username) {
		System.err.println("[LOG]---Starting----getUserByUsername() argument: " + username);
		// what is this method code going to contain? JDBC Code
=======
	// you need Driver which is the JAR for that specific
	
	@Override
	public User getUserByUsername(String username) {
		System.err.println("[LOG]---Starting----getUserByUsername() argument: " + username);
		//	Put JDBC here
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
		User user = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			System.err.println("[LOG]---inside try/catch----getUserByUsername() connection to db successful");
			String sql = "SELECT * FROM users WHERE username = ?";
<<<<<<< HEAD
			PreparedStatement ps = conn.prepareStatement(sql); // precompiling SQL statement without the parameter values
			ps.setString(1, username);
			ResultSet resultSet = ps.executeQuery();
	// don't need a loop..username is unique in the db and should only return 1 record or none
			System.err.println("[LOG]---resultset completed----getUserByUsername()");
			if( resultSet.next() ) {
				System.err.println("[LOG]---resultset if----getUserByUsername() true! ");
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			}
			
=======
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
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
<<<<<<< HEAD
		System.err.println("[LOG]---Ending----getUserByUser() returning: " + user);
		return user;
	}

=======
		System.err.println("[LOG]---Ending----getUserByUsername() returning: " + user);
		return user;
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<>();
		// I'm in the DAO so I can write JDBC logic to communicate with the db
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			String sql = "SELECT * FROM task";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tasks.add(new Task(rs.getInt("T_ID"), rs.getInt("U_ID"), rs.getString("T_NAME"), rs.getInt("TS_ID"), null));
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
}
