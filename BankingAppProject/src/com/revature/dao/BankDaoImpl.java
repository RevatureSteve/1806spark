package com.revature.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

import com.revature.pojo.Users;

public class BankDaoImpl implements BankDao{
	
	private final static String USERNAME = "Bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@octodog.cgxuhcbbspdy.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	
	/**
	 * 	READ methods will be used to read and get info from db to the console
	 */
	
	// This method will be used for instantiating the BankAccount pojo
	@Override
	public BankAccount getBankAccountInfo(int id) {
		BankAccount ba = null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM bank_account WHERE users_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				// Boilerplate code
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
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM users WHERE username = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				// Boilerplate code
				us = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				Users temp = Users.prelimUser();
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


	
	
	
}
