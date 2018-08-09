package com.cpo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cpo.beans.Account;

public class AccountDatabaseDao implements AccountDao, DatabaseDao {
	
	private static AccountDatabaseDao instance; 

	private AccountDatabaseDao() {
	}
	
	public static AccountDatabaseDao getInstance() {
		if (instance == null) {
			instance = new AccountDatabaseDao();
		}
		return instance;
	}

	@Override
	public int createAccount(Account account) {
		int rowsAffected = 0;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "CALL insert_account_procedure(?,?,?)";
			
			CallableStatement cs = conn.prepareCall(sql); //Will first take in your sql code without variable (variable place holder
			//Now need to register parameters of the SQL statement
			cs.setLong(1, account.getBalance());
			cs.setInt(2, account.getUserId());
			cs.setString(3,"");
			rowsAffected = cs.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
	}

	@Override
	public List<Account> getAccounts(int userId) {
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);) {
			String sql = "SELECT * FROM bank_account WHERE users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Account account = new Account(rs.getInt(1),rs.getLong("balance"), rs.getInt("users_id"));
				accounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public int updateAccount(Account account) {
		int rowsAffected = 0;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "CALL update_account_procedure(?,?)";
			
			CallableStatement cs = conn.prepareCall(sql); //Will first take in your sql code without variable (variable place holder
			//Now need to register parameters of the SQL statement
			cs.setLong(1, account.getBalance());
			cs.setInt(2, account.getAccountNumber());
			rowsAffected = cs.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
	}

}
