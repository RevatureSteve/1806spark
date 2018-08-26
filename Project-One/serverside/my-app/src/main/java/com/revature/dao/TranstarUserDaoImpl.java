package com.revature.dao;

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

public class TranstarUserDaoImpl implements TranstarUserDao{


	
	//Read
	/**
	 * Pulls a table of all users in the database
	 * @return
	 */
	public List<TranstarUsers> readUsers() {
		List<TranstarUsers> users = new ArrayList<>();
		try (Connection con = ConnectionsPropertiesUtil.newConnection()){
			String sql = "SELECT u_id,fname,lname,email FROM USERS " + 
					"WHERE pos_id = 1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TranstarUsers user = new TranstarUsers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
