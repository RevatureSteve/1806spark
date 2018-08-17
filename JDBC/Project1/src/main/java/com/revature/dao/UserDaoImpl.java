package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.domain.Users;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDaoImpl implements UserDao {
	
	
	//READ 
	/*
	 * Here I am using this to login as a specific user (employee/manager)
	 */
	public Users getUserByEmail(String email) {
		System.err.println("[LOG]---Starting UserDao---getUserByEmail() argument: " + email);

		Users users = null;//declare outside of the function to be able to use
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			System.err.println("[LOG]---UserDao try/catch---getUserByEmail() db connection success");
			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			System.err.println("[LOG]---UserDao ResultSet completed---getUserByEmail()");
			if (rs.next()) {
				//grabbing my sql data from the Users Table
				users = new Users(rs.getInt("U_Id"), rs.getString("Email"), rs.getString("Password"), rs.getString("fname"), rs.getString("lname"), rs.getInt("Pos_Id"));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//returning the DB info we grabbed from sql
		System.err.println("[LOG]---UserDao ResultSet if---getUserByEmail() returning: " + users);
		return users;
	}
	
	/*
	 * Here I show the entire list of Users both the Managers and Employees
	 */
	public List<Users> getAllUsers() {
		System.err.println("[LOG]---Starting UserDao---getUserByEmail()");
		
		List<Users> users = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			System.err.println("[LOG]---UserDao try/catch---getAllUsers() db connection success");
			
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			System.err.println("[LOG]---UserDao ResultSet completed---getAllUsers()");
			if (rs.next()) {
				Users user = new Users(rs.getInt("U_Id"), rs.getString("Email"), rs.getString("Password"), rs.getString("fname"), rs.getString("lname"), rs.getInt("Pos_Id"));
				users.add(user);
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.err.println("[LOG]---UserDao ResultSet if---getAllUsers() returning the list of Users");
		return users;
	}

}
