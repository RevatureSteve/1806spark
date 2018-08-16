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
		// Going to contain code for JDBC
		User user = null;
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch ( IOException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	@Override
	public List<Task> getTasksByUserId(int userId){
		List<Task> tasks = new ArrayList<Task>();
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "SELECT * FROM task WHERE u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Task task = new Task(rs.getInt("T_ID"),rs.getInt("U_ID"), rs.getString("T_NAME"), rs.getInt("TS_ID"), null);
				tasks.add(task);
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
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<Task>();
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "SELECT * FROM task";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Task task = new Task(rs.getInt("T_ID"),rs.getInt("U_ID"), rs.getString("T_NAME"), rs.getInt("TS_ID"), null);
				tasks.add(task);
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

}
