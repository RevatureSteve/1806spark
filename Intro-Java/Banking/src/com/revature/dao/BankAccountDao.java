package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.exceptions.OverdraftPreventionException;
import com.revature.pojos.BankAccount;
import com.revature.pojos.Transaction;
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

	public BankAccount getBankAccountByUserId(int user_id) {
		BankAccount bankAccount = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "SELECT * FROM bank_account WHERE users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bankAccount = new BankAccount(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bankAccount;
	}
	
	public BankAccount getBankAccountByBankId(int account_number) {
		BankAccount bankAccount = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "SELECT * FROM bank_account WHERE account_number = ?";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(1, account_number);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bankAccount = new BankAccount(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bankAccount;
	} 
	
	public ArrayList<Transaction> getTransactionsByUser(int account_number){
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "SELECT bank_tx.tx_id, bank_tx.tx_timestamp, bank_tx.tx_amt, bank_tx_type.tx_type, bank_tx.account_number " + 
					"FROM bank_tx FULL OUTER JOIN bank_tx_type " + 
					"ON bank_tx.tx_type_id = bank_tx_type.tx_type_id " + 
					"WHERE account_number = ?";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(1, account_number);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				transactions.add(new Transaction(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return transactions;
	}
	
	public void deposit(double money, int bankAccountId) {
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call deposit_money(?,?)}"; 
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, bankAccountId);
			cs.setDouble(2, money);
			cs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void withdraw(double moneyAmount, int bankAccountId) throws OverdraftPreventionException{
		if(getBankAccountByBankId(bankAccountId).getBalance() < moneyAmount) {
			throw new OverdraftPreventionException();
		}
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call withdraw_money(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, bankAccountId);
			cs.setDouble(2, moneyAmount);
			cs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
