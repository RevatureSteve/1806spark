package com.revature.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class AccountInfoDaoImpl implements BankDao {
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	public BankAccount getAccountInfo(int id) {
		BankAccount acc = null;
		
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM bank_account  WHERE users_id = ?" ;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				acc = new BankAccount(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();		
	}
		return acc;
	
	
		
	}

	@Override
	public Users getUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void enterDeposit(double amt, int accNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterWithdrawal(double amt, int accNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(String username, String password, String fname, String lname) {
		// TODO Auto-generated method stub
		
	}

}
