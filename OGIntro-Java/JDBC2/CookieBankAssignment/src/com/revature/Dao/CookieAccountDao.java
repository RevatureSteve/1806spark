package com.revature.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.interfaces.DataAccess;
import com.revature.pojos.CookieAccount;

public class CookieAccountDao implements DataAccess {
	
	private final static String USERNAME = "bank_db"; //Username from database
	private final static String PASSWORD = "p4ssw0rd"; // password from database
	private final static String URL = "jdbc:oracle:thin:@octocat.ckichuqa168o.us-east-2.rds.amazonaws.com:1521:ORCL";
	// jdbc:oracle:thin@octocat + hostname
	@Override
	public int create(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	@Override
	public List<Object> read() {//reads all bank accounts
		List<Object> cookieAccounts = new ArrayList<>(); // makes an empty list
		try(Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){//
			String sql = "SELECT * FROM bank_account";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet results = statement.executeQuery();//represents database result set
			while (results.next()) {
				CookieAccount account = new CookieAccount(results.getInt(1),results.getInt(2), results.getInt(3));//create account object with data from database
				cookieAccounts.add(account);//adds accounts to list 
			}
		}catch(SQLException e) {
			e.printStackTrace();
	
		}
		return cookieAccounts;
	}
	
	
	public CookieAccount getbyId(int useId) { //gets user id
		CookieAccount account = null; //sets it to null
		
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){ //connects to the database
			String sql = "SELECT * FROM bank_account WHERE users_id = ?"; //Selects all users from bank-account where the users id equals whatever the login accounts is 
			PreparedStatement statement = con.prepareStatement(sql); 
			statement.setInt(1, useId);  // the created prepared statement sets the useid to 1
			ResultSet results = statement.executeQuery();
			
			while(results.next()) {
				account = new CookieAccount(results.getInt(1), results.getInt(2), results.getInt(3));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	@Override
	public int update(Object obj) {
		CookieAccount account = (CookieAccount) obj;
		int rowsAltered = 0;
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "UPDATE bank_account SET balance = (?) WHERE account_number = (?)"; //sets account balance based on the current users account number
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, account.getBal()); // sets the balance to the current users balance
			ps.setInt(2, account.getActnmbr());//sets the account number to the current users account number
			rowsAltered = ps.executeUpdate();// actually makes the update happen
			System.out.println("ENJOY YOUR COOKIES!!");
		} catch (SQLException e) {
			e.printStackTrace();
	}
		return rowsAltered;
	}
	
	

}
