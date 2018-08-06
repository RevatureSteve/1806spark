package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import com.revature.pogo.Account;
import com.revature.pogo.Users;

public class BankAccount implements BankDao {

	private static final String USERNAME = "bank_db";
	private static final String PASSWORD = "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@octowolf.crtsillkaxup.us-east-2.rds.amazonaws.com:1521:ORCL";

	// CEATE

	// READ
	@Override
	public Users confirmUser(String userName, String passWord) {
		
		Users user = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5));
			}
			System.out.println("Welcome back, " + user.getFirstname() + " " + user.getLastname() + "\n");
		} catch (SQLException e) {
			System.out.println("Sorry but that account is not found in our records.\n");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Username or Password is incorrect.\n");	
		}
		return user;
	}
	
	@Override
	public void getBalance(int usersId) {

		DecimalFormat df = new DecimalFormat("#,###.00");
		Account account = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM bank_account WHERE users_id = " + usersId;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				account = new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
			}
			System.out.println("Available balance is $" + df.format(account.getBalance()) + "\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// UPDATE
	@Override
	public void setDepositAmount(int usersId, double depositAmount) {

		DecimalFormat df = new DecimalFormat("#,###.00");
		int rowAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{CALL deposit_trans(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, usersId);
			cs.setDouble(2, depositAmount);
			rowAffected = cs.executeUpdate();
			if (rowAffected == 1) {
				System.out.println("$" + df.format(depositAmount) + " has been deposited to your account.\n");
			} else {
				System.out.println("The transaction could not be completed at this time\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setWithdrawAmount(int usersId, double withdrawAmount) {

		DecimalFormat df = new DecimalFormat("#,###.00");
		int rowAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{CALL withdraw_trans(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, usersId);
			cs.setDouble(2, withdrawAmount);
			rowAffected = cs.executeUpdate();
			if (rowAffected == 1) {
				System.out.println("$" + df.format(withdrawAmount) + " has been withdrawn from your account.\n");
			} else {
				System.out.println("The transaction could not be completed at this time\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// DELETE

}
