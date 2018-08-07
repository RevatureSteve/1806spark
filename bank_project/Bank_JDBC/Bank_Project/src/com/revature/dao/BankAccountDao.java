package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.interfaces.Dao;
import com.revature.pojo.BankAccount;
import com.revature.present.MainMenuScreen;

public class BankAccountDao implements Dao {

	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@mydbinstance.cu3okwucelpd.us-east-2.rds.amazonaws.com:1521:ORCL";

	@Override
	public int create(Object obj) {
		BankAccount account = (BankAccount) obj;

		int rowsAffected = 0;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "INSERT INTO bank_account (balance, users_id) VALUES (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, account.getBalance());
			ps.setInt(2, account.getUserId());
			rowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsAffected;
	}

	@Override
	public List<Object> read() {
		List<Object> bankAccounts = new ArrayList<>();
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

	public BankAccount getById(int userId) {
		BankAccount account = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
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
	public int update(Object obj) {
		BankAccount account = (BankAccount) obj;
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "UPDATE bank_account SET balance = (?) WHERE account_number = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, account.getBalance());
			ps.setInt(2, account.getAccountNumber());
			rowsAffected = ps.executeUpdate();
		} catch (SQLDataException e) {
			System.out.println("You cannot move that much money");
			new MainMenuScreen().start();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}

}
