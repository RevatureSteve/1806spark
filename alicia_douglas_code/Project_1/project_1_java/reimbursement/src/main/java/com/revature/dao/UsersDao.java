package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Users;
import com.revature.util.SetConnectionPropertiesUtil;

public class UsersDao {

	//Create
	
	
	
	//Read
	/**
	 * get one user from DB based on email
	 * @param email
	 * @return Users
	 */
	public Users getUserByEmail(String email) {
		Users user = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new Users(rs.getInt(1), rs.getString("email"), rs.getString("password"), rs.getString("fname"), rs.getString("lname"), rs.getInt("pos_id"));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * get all the users from the Users table
	 * @return 
	 */
	public List<Users> readUsers() {
		List<Users> users = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Users user = new Users(rs.getInt(1), rs.getString("email"), rs.getString("password"), rs.getString("fname"), rs.getString("lname"), rs.getInt("pos_id"));
				users.add(user);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	//Update
	
	
	
	//Delete
	
}
