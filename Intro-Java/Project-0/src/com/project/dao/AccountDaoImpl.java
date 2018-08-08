package com.project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.Dao;
import com.project.pojo.BankBal;
import com.project.pojo.BankTrans;

public class AccountDaoImpl implements Dao{
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@gooddata.chd4toccqgaj.us-east-2.rds.amazonaws.com:1521:ORCL";
	@Override
	public int create(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Object> read() {
		List<Object> bankAccounts = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM bank_account";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BankBal account = new BankBal(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				bankAccounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankAccounts;
	}
	
	public static int getBal(int uId) {
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM bank_account WHERE users_id =  (?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	
	}
	
	public static int newAcc(String newuser,String newpassword, String fname, String lname) {
		int rowsAffected = 0;
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "{call newlogin(?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, newuser);
			cs.setString(2, newpassword);
			cs.setString(3, fname);
			cs.setString(4, lname);
			rowsAffected = cs.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<BankTrans> getTransactions(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
