package com.dimma.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dimma.logic.Logic;
import com.dimma.user.Account;
import com.dimma.user.Transactions;
import com.dimma.user.User;
import com.revature.pojo.FlashCard;

public class Dao implements DaoInterface{
	private final static	String USERNAME = "bank_db"; //uppercase is when final static.
	private final static	String PASSWORD = "p4ssw0rd";
	private final static	String URL = "jdbc:oracle:thin:@gentilly.c30ufqzawaay.us-east-2.rds.amazonaws.com:1521:ORCL";


	@Override
	public User loginUser(String username, String password) {
		User use = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("|-----------------------------------|");
				System.out.println("|              [SUCCESS]            |");
				System.out.println("|         "+username +" found!      |");
				System.out.println("|                                   |");
				System.out.println("|          PRESS ( > ) RUN          |");
				System.out.println("|                                   |");
				System.out.println("|-----------------------------------|");
				use  = new User(rs.getInt(1), rs.getString("username"),
						rs.getString("password"),rs.getString("fname"),
						rs.getString("lname"));
				User.getUser(rs.getInt(1), rs.getString("username"),
						rs.getString("password"),rs.getString("fname"),
						rs.getString("lname")); 
						}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return use;
	}

	public Account loginAcc(int users_id) {
		Account acc = null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
		String sql = "SELECT * FROM bank_account WHERE users_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, users_id);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
		acc = Account.getAccount(rs.getInt(1),rs.getInt(2),rs.getInt(3));
		Account.acc = acc;
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("|----------------------------|");
		System.out.println("|CURRENT BALANCE IS:"+" $"+acc.getBalance());
		System.out.println("|----------------------------|");
		return acc;
		
	}
	
	public int depositFunk(int amt, int users_id) {
		int rowsAffected = 0;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call deposit(?,?)}"; //surround with {} it works without but nothing gets returned.
			String msg = "";
			CallableStatement cs =  conn.prepareCall(sql);
			cs.setInt(1,amt);
			cs.setInt(2,users_id);
			rowsAffected = cs.executeUpdate();
			Account.depositAcc(amt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
		
	}
	public int withdrawFunk(int amt, int users_id) {
		int rowsAffected = 0;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call withdraw(?,?)}"; //surround with {} it works without but nothing gets returned.
			String msg = "";
			CallableStatement cs =  conn.prepareCall(sql);
			cs.setInt(1,amt);
			cs.setInt(2,users_id);
			rowsAffected = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
		
	}
	
	public List<Transactions> transFunk(int account_number, int type) {
		List<Transactions>txList = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = " SELECT btx.tx_id,btx.account_number,btxty.tx_type, btx.tx_amt, btx.tx_timestamp\n" + 
						"FROM bank_tx btx\n" + 
						"inner join bank_tx_type btxty ON btx.tx_type_id = btxty.tx_type_id\n" + 
						"WHERE account_number = ? AND btx.tx_type_id = ?"; //surround with {} it works without but nothing gets returned.
			String msg = "";
			CallableStatement cs =  conn.prepareCall(sql);
			cs.setInt(1,account_number);
			cs.setInt(2,type);
			ResultSet rs = cs.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				Transactions tx = new Transactions(rs.getString(5),rs.getInt(1),rs.getInt(4),rs.getString(3),rs.getInt(2));
				txList.add(tx);
				
				
			}System.out.println(txList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return txList;
		
	}
	
}