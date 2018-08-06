package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.BankAccount;
import com.revature.pojo.BankTransaction;
import com.revature.pojo.Users;

import com.revature.pojo.Users;

public class BankDaoImpl implements BankDao {

	private final static String USERNAME = "Bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@octodog.cgxuhcbbspdy.us-east-2.rds.amazonaws.com:1521:ORCL";

	/**
	 * READ methods will be used to read and get info from db to the console
	 */

	// This method will be used for instantiating the BankAccount pojo
	@Override
	public BankAccount getBankAccountInfo(int id) {
		BankAccount ba = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM bank_account WHERE users_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ba = new BankAccount(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ba;
	}

	// Method for getting user for login
	@Override
	public Users getUsersByUsername(String username) {
		Users us = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM users WHERE username = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				us = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				Users temp = Users.getUser();
				temp.setId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFname(rs.getString(4));
				temp.setLname(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return us;
	}

	@Override
	public List<BankTransaction> getBankTransactions(int accNum) {
		List<BankTransaction> usersBankTransactions = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT tx.tx_timestamp, tx.tx_amt, t.tx_type, tx.account_number\r\n" + 
					"    FROM bank_tx tx\r\n" + 
					"    INNER JOIN bank_tx_type t ON tx.tx_type_id = t.tx_type_id\r\n" + 
					"    WHERE tx.account_number = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			//String sql = "{call get_transaction_history_proc(?)}";
			//CallableStatement cs = conn.prepareCall(sql);
			//cs.setInt(1, accNum);
			//cs.setString(2, "SYS_REFCURSOR");
			ps.setInt(1, accNum);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BankTransaction btx = new BankTransaction(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getInt(4));
				usersBankTransactions.add(btx);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersBankTransactions;
	}

	/**
	 * UPDATE Methods These are all update BankAccount and insert BankTransation
	 * methods that are called to the db
	 * 
	 * @author Rhys
	 */

	@Override
	public void depositToBankAccount(double amt, int accNum) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call deposit_into_account(?,?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, amt);
			cs.setInt(2, accNum);
			int rowsAffected = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void withdrawFromBankAccount(double amt, int accNum) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call withdraw_from_account(?,?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, amt);
			cs.setInt(2, accNum);
			int rowsAffected = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
