package com.project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Dao;
import com.project.pojo.BankTrans;

public class TransactionDaoImpl implements Dao {
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
		return null;

	}
	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static int newTransaction(int uId, int newBal, int deposit) {
		int rowsAffected = 0;
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "UPDATE bank_account SET balance = (?) WHERE users_id = (?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newBal);
			ps.setInt(2, uId);
			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "{call new_transaction(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, uId);
			cs.setInt(2, deposit);
			rowsAffected = cs.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
	@Override
	public List<BankTrans> getTransactions(int user_id) {
		List<BankTrans> usersBankTransactions = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM bank_tx WHERE account_number = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BankTrans btx = new BankTrans(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(5));
				usersBankTransactions.add(btx);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersBankTransactions;
	}
	
	
	
}
