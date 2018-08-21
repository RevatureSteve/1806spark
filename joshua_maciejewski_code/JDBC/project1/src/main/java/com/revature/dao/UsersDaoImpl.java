package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Users;

public class UsersDaoImpl implements UsersDao {

	private final static String USERNAME = "project1_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com:1521:ORCL";
	
public Users getUserByEmail(String email) {	
	Users user = null;
	
	try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
		String sql = "SELECT * FROM users WHERE email = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}

	} catch(SQLException e) {
			e.printStackTrace();
	}
	System.out.println(user);
	return user;
	
}

@Override
public List<Users> getAllEmployees() {
	List<Users> users = new ArrayList<>();
	
	try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
		String sql = "select * from users u, position p where u.pos_id = p.pos_id AND p.pos_id = 1";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Users user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			users.add(user);
		}

	} catch(SQLException e) {
			e.printStackTrace();
	}
	System.out.println(users);
	
	
	return users;
}

public Users getViewEmployeeInfo(int id) {
	Users user = null;
	
	try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
		String sql = "SELECT * FROM users WHERE u_id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}

	} catch(SQLException e) {
			e.printStackTrace();
	}
	System.out.println(user);
	return user;
}

public void updateEmployeeInfo (int uID, String email, String password, String fname, String lname) {
	
	try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
		String sql ="UPDATE users SET email = ? AND password = ? AND fname = ? AND lname= ? WHERE u_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,  uID);
		ps.setString(2, email);
		ps.setString(3, password);
		ps.setString(4, fname);
		ps.setString(5, lname);
		ps.executeQuery();
		
	} catch(SQLException e) {
			e.printStackTrace();
	}
	
	
}
	
}
