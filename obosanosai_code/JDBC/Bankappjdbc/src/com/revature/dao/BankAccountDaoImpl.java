package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.BankAccount;

public class BankAccountDaoImpl implements BankAccountDao {
	
	//Database connection
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@areah.cszwhyxgdjx2.us-east-2.rds.amazonaws.com:1521:ORCL";
    
	//overriding the parent method
	@Override
	public int createAccount(BankAccount bacc) {
		return 0;
	}
	
	//overriding the super method
	@Override
	public void createAccountProc(BankAccount bacc) {
		
	}
	 
	// method overriding aka polymophism
	@Override
	public List<BankAccount> readAccount() {
		List<BankAccount> bankAccounts = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM bank_account";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BankAccount account = new BankAccount(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
				bankAccounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankAccounts;
	}
	//same as previous descriptions
	@Override
	public BankAccount getAccountById(int userId) {
		BankAccount account = null;
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM bank_account WHERE users_id = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				account = new BankAccount(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return account;
	}
	
	@Override
	public int updateAccount(BankAccount bacc) {
		BankAccount account = (BankAccount) bacc;
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "UPDATE bank_account SET balance = (?) WHERE account_number = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, account.getBalance());
			ps.setInt(2, account.getAccountNum());
			rowsAffected = ps.executeUpdate();
			System.out.println("One munite please, Transaction is not being processed...");
			System.out.println("                                                        ");
			System.out.println("pretty sure i said to give me a minute, cshh..");
			System.out.println("                                                    ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public void deleteAccount(String username, int usersId) {
		// TODO Auto-generated method stub
		
	}

}