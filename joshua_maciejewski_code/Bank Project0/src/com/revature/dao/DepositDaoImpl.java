package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class DepositDaoImpl implements BankDao {
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	
	@Override
	public  void enterDeposit(double amt, int accNum) {
		
//		double amt= 100;
//		int accNum = 1111;
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call deposit(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setDouble(1 , amt);
			cs.setInt(2, accNum);
			
			
			int rowsAffected = cs.executeUpdate();
			System.out.println(rowsAffected);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
//	public void createFlashCardProc(FlashCard fc) {
//		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
//			String sql = "{call insert_fc_procedure(?, ?, ?)}"; //surround in curly braces 
//			String msg = "";
//			CallableStatement cs = conn.prepareCall(sql);
//			
//			cs.setString(1,  fc.getFcQuestion());
//			cs.setString(2,  fc.getFcAnswer());
//			cs.setString(3,  msg);
//			
//			int rowsAffected = cs.executeUpdate();
//			System.out.println("rows affected: " + rowsAffected);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
//	Users user = null;
//	try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
//		String sql = "SELECT * FROM users WHERE username = ?";
//		
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, username);
//		ResultSet rs = ps.executeQuery();
//		
//		if(rs.next()) {
//			
//			user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//			Users temp = Users.potentialUser();
//			temp.setUserId(rs.getInt(1));
//			temp.setUsername(rs.getString(2));
//			temp.setPassword(rs.getString(3));
//			temp.setFirstName(rs.getString(4));
//			temp.setLastName(rs.getString(5));
//		}
//	} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return user;
	
	
	
	@Override
	public Users getUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccount getAccountInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void enterWithdrawal(double amt, int accNum) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createUser(String username, String password, String fname, String lname) {
		// TODO Auto-generated method stub
		
	}






}
