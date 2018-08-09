package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.revature.pojo.BankAccount;
import com.revature.pojo.User;

public class BankingAppDaoImpl implements BankingAppDao {
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@octocat.cc0hd2rbzuaq.us-east-2.rds.amazonaws.com:1521:ORCL";
	

	@Override
	public int createUser(User person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUsersById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM USERS WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			
				user = new User(rs.getInt("USERS_ID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("FNAME"), rs.getString("LNAME"));
				
				}
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int deposit(int amount, User a) {
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
			conn.setAutoCommit(false);
			String sql = "{CALL deposit(?,?) ";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, a.getUserID());
			cs.setInt(2, amount);
			rowsAffected = cs.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public int withdraw(int amount2, User a) {
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
			conn.setAutoCommit(false);
			String sql = "{CALL withdraw(?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(3, Types.INTEGER); //return data from store procedure
			cs.setInt(1, a.getUserID());
			cs.setInt(2, amount2);
			cs.setInt(3, 0);
			cs.executeUpdate();
			rowsAffected = cs.getInt(3);
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public int balance(User a) {
		BankAccount b = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM bank_account WHERE users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getUserID());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			
				b = new BankAccount(rs.getInt("Account_Number"), rs.getInt("balance"), rs.getInt("Users_id"));
				
				}
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b.getbalance();
	}

}
