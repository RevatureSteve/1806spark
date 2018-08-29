package com.reavture.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.conn.ConnFactory;
import com.revature.dao.UserDAO;
import com.reavture.daoimpl.AccountDAOimpl;

public class UserDAOimpl implements UserDAO {
	
	AccountDAOimpl adao = new AccountDAOimpl();
	
	public static ConnFactory cf = ConnFactory.getInstance();

	
	//Create a new user
	@Override
	public void addUser(String fname, String lname, String username, String password) throws SQLException {
		
		Connection conn = cf .getConnection();
		User users = null;
		
		String sql = "INSERT INTO USERS VALUES (USERSSEQ.NEXTVAL, ?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, username);
			ps.setString(4, password);
			//ps.setInt(5, 0);
			ResultSet rs = ps.executeQuery();
			
		}catch(SQLException e){
			System.out.println("Couldn't register user at UserDAOImpl:  " + e.getMessage());
		}

	}
	
	
	//retrieve an individual with their username 
	@Override
	public User getUser(String username) throws SQLException {
		Connection conn = cf .getConnection();
		
		String sql = "SELECT * FROM USERS WHERE USERNAME = '" + username + "'";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			User u = null;
			
			while(rs.next())
			{
				//POPULATE HERE
				//u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			conn.close();
		}catch(SQLException e)
		{
			System.out.println("Couldn't get user at UserDAOImpl:  " + e.getMessage());

		}
		
		return null;
	}

	//return a list of users
	@Override
	public List<User> getUsers() throws SQLException {
		Connection conn = cf .getConnection();
		List<User> users = new ArrayList<User>();
		
		String sql = ("SELECT * FROM USERS");
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			User u = null;
			while(rs.next())
			{
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), adao.getAccounts(rs.getString(4)) );
				users.add(u);
			}
			conn.close();
		}catch(SQLException e){
			System.out.println("Couldn't get list of users at UserDAOImpl:  " + e.getMessage());
		}
		
		return users;
	}
	
	//getting user_id from username 
		@Override
		public int getUsersId(String username) throws SQLException {
			Connection conn = cf .getConnection();
			int usersId = 0;
			String sql = "SELECT USERS_ID FROM USERS WHERE USERNAME = '" + username + "'";
			try 
			{
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					usersId = rs.getInt(1);
				}
				conn.close();
			}catch(SQLException e)
			{
				System.out.println("Couldn't get user_id at UserDAOImpl:  " + e.getMessage());

			}
			return usersId;
		}
		
		
	//retrieve status from username
//		@Override
//		public int getStatus(String username) throws SQLException
//		{
//			Connection conn = cf .getConnection();
//			int status = 0;
//			String sql = "SELECT USERTYPE_ID FROM BANK_USER WHERE USERNAME = '" + username + "'";
//			try 
//			{
//				PreparedStatement ps = conn.prepareStatement(sql);
//				ResultSet rs = ps.executeQuery();
//				while(rs.next())
//				{
//					status = rs.getInt(1);
//				}
//				conn.close();
//			}catch(SQLException e)
//			{
//				System.out.println("Couldn't get status at UserDAOImpl:  " + e.getMessage());
//
//			}
//			return status;
//			
//		}

	
	//update user info
	@Override
	public void updateUsers(String username) throws SQLException {
		
		//update user info?
		
	}

	
	//delete a user with their id using a CallableStatement
	@Override
	public void deleteUsers(String username) throws SQLException {
		Connection conn = cf .getConnection();
		String sql = "{call DELETEUSERS(?,?)";
		
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, username);
			cs.execute();
			conn.close();
		}catch(SQLException e)
		{
			System.out.println("Couldn't delete user at UserDAOImpl:  " + e.getMessage());

		}
		
	}


	

}
