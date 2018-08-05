package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.revature.pojos.BankAccount;
import com.revature.singletons.LoggedUser;

public class BankAccountDao {
	private static final String URL = "jdbc:oracle:thin:@marcin-salamon-oracle.ch2v7k2we1qt.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static final String USERNAME = "bank_db";
	private static final String PASSWORD = "p4ssw0rd";
	public ArrayList<BankAccount> getBankAccounts() {
		ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "SELECT * FROM bank_account";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bankAccounts.add(new BankAccount(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bankAccounts;
	}

	public BankAccount getBankAccountByUserId(int id) {
		BankAccount bankAccount = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "SELECT * FROM bank_account WHERE users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bankAccount = new BankAccount(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bankAccount;
	}
	
	public void deposit(int moneyAmmount, int bankAccountId) {
		
	}
	
	
}
