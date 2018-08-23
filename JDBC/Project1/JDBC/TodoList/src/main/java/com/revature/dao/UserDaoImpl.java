package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Task;
import com.revature.domain.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDaoImpl implements UserDao {
	
	@Override
	public User getUserByUsername(String username) {
		System.err.println("[LOG]---Starting---getUserByUsername() argument: " + username);
		// what is this method code going to contain? JDBC Code
		User user = null;

		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			System.err.println("[LOG]---inside try/catch---getUserByUser() db connection success");
			String sql = "Select * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);//precompiling the sql statement without the parameter values
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			
			//don't need a loop. . username is unique in the db and should only return 1 record or none
			System.err.println("[LOG]---resultset completed---getUserByUser()");
			if (rs.next()) {
				System.err.println("[LOG]---resultsert if---getUserByUser() is true");
				user = new User(rs.getInt("u_id"), rs.getString("username"), rs.getString("pw"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.err.println("[LOG]---resultset if---getUserByUser() returning: " + user);
		return user;
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			String sql = "SELECT * FROM task";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				tasks.add(new Task(rs.getInt("T_Id"), rs.getInt("U_Id"), rs.getString("T_Name"), rs.getInt("Ts_Id"), null));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
		
	}

	@Override
	public List<Task> getTasksByUserId(int id) {
		List<Task> tasks = new ArrayList<>();
		
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			String sql = "SELECT * FROM task WHERE u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				tasks.add(new Task(rs.getInt("T_Id"), rs.getInt("U_Id"), rs.getString("T_Name"), rs.getInt("Ts_Id"), null));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}
	
	
}
