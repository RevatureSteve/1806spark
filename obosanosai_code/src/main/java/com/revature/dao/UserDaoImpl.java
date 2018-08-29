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
		System.err.println("[LOG]---Starting----getUserByUsername() argument: " + username);
		// what is this method code going to contain? JDBC Code
		User user = null;
		try(Connection conn = SetConnectionPropertiesUtil.getConnection()){
			System.err.println("[LOG]---inside try/catch----getUserByUsername() connection to db successful");
			String sql = "SELECT * FROM users WHERE username = ?";
		PreparedStatement ps = 	conn.prepareStatement(sql); // precompiling the SQL statement without the parameter values.
		ps.setString(1, username);
		ResultSet resultSet = ps.executeQuery();
// don't need a loop..username is unique and should only return 1 record or none
		System.err.println("[LOG]---resultSet completed----getUserByUsername()");
		if(resultSet.next()) {
			System.err.println("[LOG]---resultSet completed----getUserByUsername() true!");
			user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.err.println("[LOG]---Ending----getUserByUsername() returning: User ");
		return user;
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<>();
		// I am in the dao so I can write JDBC logic to communicate with the DB.
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM task";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				tasks.add(new Task(rs.getInt("T_ID"), rs.getInt("U_ID"), rs.getNString("T_NAME"), rs.getInt("TS_ID"), null));
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public List<Task> getTasksByUserId(int id) {
		List<Task> tasks = new ArrayList<>();
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM task WHERE u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tasks.add(new Task(rs.getInt("T_ID"), rs.getInt("U_ID"), rs.getNString("T_NAME"), rs.getInt("TS_ID"), null));
			}
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();
		}
		return tasks;
	}

}
