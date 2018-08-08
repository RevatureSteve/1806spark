package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.exceptions.userNotFound;
import com.revature.pojo.Bank_Account;
import com.revature.pojo.Users;

public class BankDaoImpl implements BankDao {

	private final static String USERNAME = "Alex_Moraga";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@pvtmad.cz07tejakuok.us-east-2.rds.amazonaws.com:1521:ORCL";

	// CREATE
	@Override
	public int createUser(Users ui) {
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Users(username, password, fname, lname) VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, ui.getUserId());
			ps.setString(1, ui.getUsername());
			ps.setString(2, ui.getPassword());
			ps.setString(3, ui.getFirstname());
			ps.setString(4, ui.getLastname());
			rowsAffected = ps.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(rowsAffected + " rows affected");
		return rowsAffected;

	}

	// READ

	
	@Override
	public Users getUserByUsername(String username) throws userNotFound {
		Users un = null; // null because it's inside the local scope, there is no default value within
		// the local scope
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) { // Close with resource
			String sql = "SELECT * FROM users WHERE username = '" + username + "'";
			Statement statement = conn.createStatement(); // Allows me to send SQL statements into the database
			ResultSet rs = statement.executeQuery(sql); // This executes the SQL statement
			
			if (rs.next()) { // rs.next goes to the next row on the table
				un = new Users(rs.getInt("Users_id"),rs.getString("username"), rs.getString("password"), rs.getString("fname"),
						rs.getString("lname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
			if(un == null) {
				throw new userNotFound();
			}
		return un;
	}


	@Override
	public Bank_Account getBalance(Users ui) {
		Bank_Account ba = null; 
//		System.out.println("[LOG]----callling dao---getBalance() " + ui );
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) { // Close with resource
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM bank_account WHERE users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ui.getUserId());
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) { // rs.next goes to the next row on the table
//				System.out.println("Entered the rs.next");
				ba = new Bank_Account(rs.getInt("account_number"), rs.getInt("balance"), rs.getInt("users_id"));
			}
			conn.commit();
//			System.out.println("it commits");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ba;
	}


	// UPDATE
	@Override
	public int depositing(Users ui, int amount) {
		int rowsAffected = 0;
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			conn.setAutoCommit(false);
			String sql ="{Call accountDeposit (?,?)}"; // calls the store procedure 
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, ui.getUserId()); // inputs the user's id inside the store procedure
			cs.setDouble(2, amount); // inputs the amount the user inputed in the depositing screen
			rowsAffected = cs.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(rowsAffected + " deposit transaction has been completed!");
		return rowsAffected;
	}
	
	@Override
	public int withdrawing(Users ui, int amount) {
		int rowsAffected = 0;
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			conn.setAutoCommit(false);
			String sql = "{Call accountWithdraw (?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, ui.getUserId());
			cs.setDouble(2, amount);
			rowsAffected = cs.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(rowsAffected + " withdraw transaction has been complete ");
		return rowsAffected;
	}

	// DELETE

}
