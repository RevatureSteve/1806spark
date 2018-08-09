package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class RegisterDaoImpl implements BankDao {
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com:1521:ORCL";

	@Override
	public void createUser(String username, String password, String fname, String lname) {
		
		//Users temp = Users.potentialUser();
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call new_user(?, ?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1 , username);
			cs.setString(2 , password);
			cs.setString(3 , fname);
			cs.setString(4 , lname);
			
			//int rowsAffected = 
			cs.executeUpdate();
			//System.out.println(rowsAffected);
			
//			temp.setUsername(username);
//			temp.setPassword(password);
//			temp.setFirstName(fname);
//			temp.setLastName(lname);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	
//	public void createNewUser(String username, String password, String fname, String lname) {
//		Users temp = Users.getUser();
//		try(Connection conn = DriverManager.getConnection(URL,USERNAME, PASSWORD);) {
//			String sql = "{call create_user_and_bank_account(?,?,?,?)}";
//			CallableStatement cs = conn.prepareCall(sql);
//			cs.setString(1, username);
//			cs.setString(2, password);
//			cs.setString(3, fname);
//			cs.setString(4, lname);
//			cs.executeQuery();
//			temp.setUsername(username);
//			temp.setPassword(password);
//			temp.setFname(fname);
//			temp.setLname(lname);			
//		} catch (SQLException e) {
//			e.printStackTrace();
	
	
	
	
	
	
	
	
	
	
	
		
		
//		public void enterWithdrawal(double amt, int accNum) {
//			
//			try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
//				String sql = "{call withdrawal(?, ?)}";
//				CallableStatement cs = conn.prepareCall(sql);
//				
//				cs.setDouble(1 , amt);
//				cs.setInt(2, accNum);
//				
//				
//				int rowsAffected = cs.executeUpdate();
//				System.out.println(rowsAffected);
//			
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//			
//		}

		
		
		
		
	

	
	
	

	
	
	
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
	public void enterDeposit(double amt, int accNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterWithdrawal(double amt, int accNum) {
		// TODO Auto-generated method stub
		
	}

}
