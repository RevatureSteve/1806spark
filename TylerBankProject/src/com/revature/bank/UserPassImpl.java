package com.revature.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.bank.Dao.UserPassDao;
import com.revature.bank.pojo.Bank_AccountPojo;
import com.revature.bank.pojo.UsersPojo;

public class UserPassImpl implements UserPassDao {

	private static final String USERNAME= "bank_db";
	private static final String PASSWORD= "p4ssw0rd";
	private static final String URL= "jdbc:oracle:thin:@tylertraining.cnmoc1mujdcw.us-east-2.rds.amazonaws.com:1521:ORCL";

	
//Verify Username and password	
	@Override
	public boolean verifyUsernameAndPassword(UsersPojo user) {
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			
			Scanner scan = new Scanner(System.in);
			
			
			String sql = "SELECT * FROM users WHERE USERNAME = '" + user.getUsername() + "' AND PASSWORD = '" + user.getPassword() + "'";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (!rs.isBeforeFirst() && rs.getRow() == 0) {
				return false;
			}
			
			while (rs.next()) {
				user.setUsers_id(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFname(rs.getString(4));
				user.setLname(rs.getString(5));
			
			}
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	
//Bank Deposit 
	public int bankDeposit(int id, double amount) {
	
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			
			String sql ="{CALL UPDATE_ACCOUNT (?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.setDouble(2, amount);
			int rowsAffected = cs.executeUpdate();
			System.out.println("rows affected: " + rowsAffected);
			

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

//Bank Withdraw
	public int bankWithdraw(int wNum, double wAmount) {

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			
			String sql ="{CALL UPDATE_ACCOUNT_WITHDRAW (?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, wNum);
			cs.setDouble(2, wAmount);
			int rowsAffected = cs.executeUpdate();
			System.out.println("rows affected: " + rowsAffected);
			

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}


//VIEW BALANCE
//	public Bank_AccountPojo viewBalance(int uid) {
//		
//		Bank_AccountPojo bal = null;
//		
//		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
//			
//			String sql = "SELECT balance FROM bank_account WHERE users_id = " + uid;
//			Statement statement = conn.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			
//			if(rs.next()) {
//				bal = new Bank_AccountPojo(rs.getInt(1), rs.getDouble(2), rs.getString(3));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return bal;
//	}


	public Bank_AccountPojo viewBalance(int uid) {
		
		Bank_AccountPojo bal = null;
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			
			String sql = "SELECT * FROM bank_account WHERE users_id = " + uid;
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs.next()) {
				bal = new Bank_AccountPojo(rs.getInt(1), rs.getDouble(2), rs.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bal;
	}



	
	
}
