package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.interfaces.Dao;
import com.revature.pojo.BankTransaction;

public class TransactionDao implements Dao{
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@mydbinstance.cu3okwucelpd.us-east-2.rds.amazonaws.com:1521:ORCL";
	

	@Override
	public int create(Object obj) {
		BankTransaction trans = (BankTransaction) obj;
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call insert_bank_tx(?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, trans.getTransactionAmt());
			cs.setString(2, trans.getTransactionType());
			cs.setInt(3, trans.getAccountNumber());
			System.out.println("TRANS SUCCESS");
			rowsAffected = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public List<Object> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
