package com.cpo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cpo.beans.Account;
import com.cpo.beans.Transaction;

public class TransactionDatabaseDao implements TransactionDao, DatabaseDao {

	private static TransactionDatabaseDao instance;
	
	private TransactionDatabaseDao() {
	}
	
	public static TransactionDatabaseDao getInstance() {
		if (instance == null) {
			instance = new TransactionDatabaseDao();
		}
		return instance;
	}

	@Override
	public int createTransactions(Transaction tx) {
		int rowsAffected = 0;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "INSERT INTO bank_tx(tx_type_id, tx_timestamp, account_number, tx_amt) VALUES (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql); //Will first take in your sql code without variable (variable place holder
			//Now need to register parameters of the SQL statement
			ps.setInt(1,tx.getTxTypeId());
			ps.setTimestamp(2, tx.getTime());
			ps.setInt(3, tx.getAccountNumber());
			ps.setLong(4, tx.getTxAmt());
			rowsAffected = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
	}

	@Override
	public List<Transaction> getTransactions(int account_number) {
		List<Transaction> txs = new ArrayList<Transaction>();
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);) {
			String sql = "SELECT * FROM bank_tx WHERE account_number = ? ORDER BY tx_timestamp";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, account_number);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Transaction tx = new Transaction(rs.getInt(1), rs.getInt("tx_type_id"), rs.getTimestamp("tx_timestamp"), rs.getInt("account_number"), rs.getLong("tx_amt"));
				txs.add(tx);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return txs;
	}
	
	public List<Transaction> getTransactions(List<Integer> accountNumbers) {
		List<Transaction> txs = new ArrayList<Transaction>();
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);) {
			String sql = "SELECT * FROM bank_tx WHERE account_number = ?";
			
			for (int i = 1; i < accountNumbers.size(); i++){
				
				sql += " OR account_number = ?";
				
			}
			
			sql += " ORDER BY tx_timestamp";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			for (int i = 1; i < accountNumbers.size() + 1; i++){
				ps.setInt(i, accountNumbers.get(i - 1));
			}

			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Transaction tx = new Transaction(rs.getInt(1), rs.getInt("tx_type_id"), rs.getTimestamp("tx_timestamp"), rs.getInt("account_number"), rs.getLong("tx_amt"));
				txs.add(tx);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return txs;
	}

}
