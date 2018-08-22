package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.BankAccount;
import com.revature.model.BankUser;

public class BankUserDaoImpl implements BankUserDao{

	private static final String USERNAME = "bank_db";
	private static final String PASSWORD = "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@octocat.ccwgu9dykdjd.us-west-2.rds.amazonaws.com:1521:ORCL";
	
	static {
		try {
			// tomcat issue
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public BankUser getUserByUsername(BankUser user) {
			BankUser dbUser = null;
			try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
				String sql = "SELECT * FROM users WHERE USERNAME = ?";
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, user.getUsername());
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					dbUser = new BankUser(rs.getInt("USERS_ID"),rs.getString("USERNAME"),rs.getString("FNAME"),
							rs.getString("LNAME"), rs.getString("PASSWORD"));
				};
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		return dbUser;
	}



	@Override
	public BankAccount getBankAccountByUserId(BankUser user) {
		BankAccount dbAccount = null;
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM bank_account WHERE ACCOUNT_NUMBER = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("-----------------BankAccount found---------------");
				dbAccount = new BankAccount(rs.getInt("ACCOUNT_NUMBER"), rs.getDouble("BALANCE"), rs.getInt("USERS_ID"));
				System.out.println(dbAccount);
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return dbAccount;
		
	}

}
