package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.pojos.User;

public class BankDao {
	// DB Information.
	 static final String URL ="jdbc:oracle:thin:@revaturedatabase.c4iijzopvhom.us-east-2.rds.amazonaws.com:1521:ORCL";
	 static final String D_USERNAME = "bank_DB";
	 static final String D_PASSWORD = "p4ssw0rd";
	 
	 //Gets all the users in DB.
	 public void getAllUsers() {
		 try(Connection conn = DriverManager.getConnection(URL, D_USERNAME, D_PASSWORD)) {
			 conn.setAutoCommit(false);
			 String sql = "SELECT * FROM users";
			 PreparedStatement pstatement = conn.prepareStatement(sql);
			 pstatement.executeQuery();
			 ResultSet rs = pstatement.getResultSet();
			 while (rs.next()) {
				 System.out.println(rs.getString(2) );
			 }
		 } catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	
	//Login for users.
	public String getUserLogin (String username, String password) {
		
		try(Connection conn = DriverManager.getConnection(URL, D_USERNAME, D_PASSWORD)) {
		String sql = "SELECT f_name, l_name FROM users WHERE username = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
		String first = rs.getString(1);
		String last = rs.getString(2);
		
		System.out.println("Welcome back " + first + " " +  last);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//Show balance.
	public void getBalance() {
		try (Connection conn = DriverManager.getConnection(URL, D_USERNAME, D_PASSWORD)){
			String sql = "select bank_account.balance from bank_account inner join users on bank_account.users_id = users.users_id Where bank_account. users_id = 2";
			PreparedStatement pstatement = conn.prepareStatement(sql);
			pstatement.executeQuery();
			ResultSet rs = pstatement.getResultSet();
			while (rs.next()) {
				int balance = rs.getInt(1);
				System.out.println("Your current balance is " + balance + " bingos");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//Make a deposit.
	public void makeDeposit(int deposit) {
		try (Connection conn = DriverManager.getConnection(URL, D_USERNAME, D_PASSWORD)) {
			String sql = "SELECT balance FROM bank_account WHERE users_id = 2";
			String p_sql = "{call make_deposit(?)}";
			PreparedStatement pstatement = conn.prepareStatement(sql);
			pstatement.executeQuery();
			ResultSet rs = pstatement.getResultSet();
			while (rs.next()) {
				int balance = rs.getInt(1);
				balance += deposit;
				System.out.println("Your new balane plus your deposit of " + deposit + " bingos is " + balance + " bingos.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Make a withdrawl.
		public void makeWithdrawl(int sub) {
			try (Connection conn = DriverManager.getConnection(URL, D_USERNAME, D_PASSWORD)) {
				String sql = "SELECT balance FROM bank_account WHERE users_id = 2";
				PreparedStatement pstatement = conn.prepareStatement(sql);
				pstatement.executeQuery();
				ResultSet rs = pstatement.getResultSet();
				while (rs.next()) {
					int balance = rs.getInt(1);
					balance -= sub;
					System.out.println("Your new balance minus your witdrawl of " + sub + " bingos is " + balance + " bingos.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	//Create an account.
	public void createAccount() {
		try (Connection conn = DriverManager.getConnection(URL, D_USERNAME, D_PASSWORD))  {
			String sql = "";
			CallableStatement cstatement = conn.prepareCall(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
	
	

	
}