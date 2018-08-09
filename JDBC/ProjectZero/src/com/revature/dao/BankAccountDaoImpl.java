package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojo.BankAccount;

public class BankAccountDaoImpl implements BankAccountDao {
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@hearthstone.cxazmpz2rlnm.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	@Override
	public BankAccount getAccountById(int userId) {
		BankAccount account = null;
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM bank_account WHERE users_id = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			//pre-compiling SQL statement without the parameter values
			ps.setInt(1, userId);
			//this is what goes inside the ?
			ResultSet rs = ps.executeQuery();
			//Use ResultSet and executeQuery for SELECT
			//since users_id is unique, should only get one bank account
			//therefore, no need to loop
			if (rs.next()) {
				account = new BankAccount(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				//ResultSet is true, retrieve account info and give it to account
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	@Override
	public int updateAccount(BankAccount ba) {
		BankAccount account = (BankAccount) ba;
		//set account info with new balance from current account
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "UPDATE bank_account SET balance = (?) WHERE account_number = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			//pre-compiling SQL statement without the parameter values
			ps.setInt(1, account.getBalance());
			//this is what goes inside the 1st ?, the new balance
			ps.setInt(2, account.getAcNum());
			//this is what goes inside the 2nd ?, the current account's number
			rowsAffected = ps.executeUpdate();
			//Use rowsAffected and executeUpdate for UPDATE
			System.out.println("Processing Transaction...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}

}