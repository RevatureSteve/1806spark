package com.bank.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bank.pojos.BankAccount;
import com.bank.pojos.User;
import com.bank.presentation.Menus;
import com.bank.service.InputException;

public class BankDaoImpl implements BankDao {
	// DB Information.
		private static final String URL ="jdbc:oracle:thin:@revaturedatabase.c4iijzopvhom.us-east-2.rds.amazonaws.com:1521:ORCL";
		 private static final String D_USERNAME = "bank_DB";
		 private static final String D_PASSWORD = "p4ssw0rd";
		 
		 Menus m = new Menus();
	@Override
	// A user can login.
	public User getUserLogin() {
		User user = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		
		try(Connection conn = DriverManager.getConnection(URL, D_USERNAME, D_PASSWORD)) {
		String sql = "SELECT users_id, f_name, l_name FROM users WHERE username = ? AND password = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
		String first = rs.getString(2);
		String last = rs.getString(3);
		user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
		System.out.println("Welcome back " + first + " " +  last);
		m.mainMenu();
		}
		throw new InputException("Invalid input");
		
		} catch (InputException e){
			System.out.println("Please enter a valid username and passwod");
			getUserLogin();
			
		} catch (SQLException e) {
			System.out.println("Oops, looks like you entered some incorrect information. .");
		}
		finally {
			scan.close();
		}
		return user;
		
	}

	@Override
	// A user can view a balance.
	public BankAccount getBalance(int usersId) {
		BankAccount ba = null;
		try (Connection conn = DriverManager.getConnection(URL, D_USERNAME, D_PASSWORD)){
			String sql = "SELECT * FROM bank_account WHERE users_id = ?";
			PreparedStatement pstatement = conn.prepareStatement(sql);
			pstatement.setInt(1, usersId);
			pstatement.executeQuery();
			ResultSet rs = pstatement.getResultSet();
			while (rs.next()) {
				ba = new BankAccount(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				System.out.println("Your current balance is " + rs.getInt(2) + " bingos");
			}
		} catch (SQLException e) {
			System.out.println("Oops, looks like something went wrong.");
		}
		return ba;
	}

	@Override
	// A user can make a deposit.
	public void makeDeposit(int deposit) {
		try(Connection conn = DriverManager.getConnection(URL, D_USERNAME, D_PASSWORD)) {
			String sql = "{ call make_deposit(?) }";
			CallableStatement cstatement = conn.prepareCall(sql);
			cstatement.setInt(1, deposit);
			int ra = cstatement.executeUpdate();
			System.out.println(ra);
			System.out.println("Your deposit has been accepted.");
		} catch (SQLException e) {
			System.out.println("We could not accept your deposit at this time");
		}
		
	}

	@Override
	// A user can make a witdrawl.
	public void makeWitdrawl(int witdrawl) {
		try(Connection conn = DriverManager.getConnection(URL, D_USERNAME, D_PASSWORD)) {
			String sql = "{ call make_witdrawl(?) }";
			CallableStatement cstatement = conn.prepareCall(sql);
			cstatement.setInt(1, witdrawl);
			int ra = cstatement.executeUpdate();
			System.out.println(ra);
			System.out.println("Your withdrawl has been accepted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

//	@Override
//	// A user can create multiple accounts.
//	public BankAccount createAccount(String username, String password) {
//		BankAccount ba = null;
//		try (Connection conn = DriverManager.getConnection(URL, D_USERNAME, D_PASSWORD))  {
//			String sql = "";
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ba;
//	}
	
	//A user can log out.
		public void logout() {
			System.out.println("Your login session has successfuly ended. Thank you");
			System.exit(0);
		}
	
}
