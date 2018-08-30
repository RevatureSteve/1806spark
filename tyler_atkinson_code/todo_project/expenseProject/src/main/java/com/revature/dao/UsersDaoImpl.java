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

import com.revature.domain.Reimbursement;
import com.revature.domain.Users;
import com.revature.util.SetConnectionPropertiesUtil;


public class UsersDaoImpl implements UsersDao {
	
	private final static String  USERNAME = "tyler_ers";
	private final static String  PASSWORD = "p4ssw0rd";
	private final static String  URL = "jdbc:oracle:thin:@tylertraining.cnmoc1mujdcw.us-east-2.rds.amazonaws.com:1521:ORCL"; 
			
	
	
	@Override
	public Users getUserByEmail(String email) {
		
		Users user = null;
		
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				user = new Users(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}



	public List<Users> getAllUsers(){
		
		System.out.println("usersDAO");
		
		List<Users> users = new ArrayList<>();
		
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				users.add(new Users(rs.getInt("U_ID"), rs.getString("FNAME"),rs.getString("LNAME"),rs.getString("EMAIL"),rs.getString("PASSWORD"),rs.getInt("Pos_ID") ));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	@Override
	public int updateUser(Users x) {
		int rowsAffected = 0;
		System.out.println("updating" + x);
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "UPDATE users SET FNAME = ?, LNAME = ?, EMAIL = ?,password = ? where u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, x.getFname());
			ps.setString(2, x.getLname());
			ps.setString(3,x.getEmail());
			ps.setString(4, x.getPassword());
			ps.setInt(5, x.getUid());
			rowsAffected = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
	}
