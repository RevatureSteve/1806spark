package com.drake.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.drake.domain.User;
import com.drake.util.SetConnectionPropertiesUtil;

public class UserDao {

	//Create
	public void createUser(User user) {
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "INSERT INTO u_sers (email, password, fname, lname, pos_id) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFname());
			ps.setString(4, user.getLname());
			ps.setInt(5, user.getPos_id());
			ps.executeQuery();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//Read
	/**
	 * get one user from DB based on email
	 * @param email
	 * @return User
	 */
	public User getUserByEmail(String email) {
		User user = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM u_sers u INNER JOIN positions p ON u.pos_id = p.pos_id WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User(rs.getInt(1), rs.getString("email"), rs.getString("password"), rs.getString("fname"), rs.getString("lname"), rs.getInt("pos_id"),rs.getString("pos_type"));
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
	 * get all the users from the User table
	 * @return 
	 */
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM u_sers u INNER JOIN positions p ON u.pos_id = p.pos_id ORDER BY u_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString("email"), rs.getString("password"), rs.getString("fname"), rs.getString("lname"), rs.getInt("pos_id"),rs.getString("pos_type"));
				users.add(user);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	//Update
	/**
	 * Update employee info
	 * @param user
	 */
	public void updateUsers(User user) {
		
		System.out.println("update user dao");
		
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			System.out.println("in try catch");
			String sql = "UPDATE u_sers SET email = ? , fname = ?, lname = ? WHERE u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("created prepared statement");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getFname());
			ps.setString(3, user.getLname());
			ps.setInt(4, user.getU_id());
			System.out.println("set values");
			ps.executeQuery();
			System.out.println("exectuted query");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}