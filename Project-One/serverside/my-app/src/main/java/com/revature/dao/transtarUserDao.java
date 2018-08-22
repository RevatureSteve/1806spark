package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.TranstarUsers;
import com.revature.util.ConnectionsPropertiesUtil;

public class transtarUserDao {
	
	private final static String USERNAME = "transtar";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@gooddata.chd4toccqgaj.us-east-2.rds.amazonaws.com:1521:ORCL";

	
	//Read
	/**
	 * Pulls a table of all users in the database
	 * @return
	 */
	public List<TranstarUsers> readUsers() {
		List<TranstarUsers> users = new ArrayList<>();
		try (Connection con = ConnectionsPropertiesUtil.newConnection()){
			String sql = "SELECT * FROM users a INNER JOIN position b ON a.pos_id = b.pos_id";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TranstarUsers user = new TranstarUsers(rs.getInt(1), rs.getString("email"), rs.getString("password"), rs.getString("fname"), rs.getString("lname"), rs.getInt("pos_id"),rs.getString("pos_type"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
		/**
		 * Pulls a user from the username based of the email that is sent as a param. 
		 * @param email
		 * @return Users
		 */
		public TranstarUsers getUser(String email) {
			TranstarUsers user = null;
			try (Connection con = ConnectionsPropertiesUtil.newConnection()){
				String sql = "SELECT * FROM users a INNER JOIN position b ON a.pos_id = b.pos_id WHERE email = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					user = new TranstarUsers(rs.getInt(1), rs.getString("email"), rs.getString("password"), rs.getString("fname"), rs.getString("lname"), rs.getInt("pos_id"),rs.getString("pos_type"));
				}
				
			} catch (SQLException e) {
				System.out.println("SQL fail");
				e.printStackTrace();
			}
			return user;
		}
		
		

}
