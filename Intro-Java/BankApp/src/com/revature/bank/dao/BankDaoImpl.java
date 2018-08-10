package com.revature.bank.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bank.pojo.User;
import com.revature.bank.util.setConnectionProperties;

public class BankDaoImpl implements BankDao{
	
	//CREATE
	@Override
	public int createUser(User u) {
		int rowsAffected = -1;
		try (Connection conn = setConnectionProperties.getConnection()){
			String sql = "INSERT INTO USERS(USERNAME, PASSWORD, FNAME, LNAME) VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			rowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return rowsAffected;
	}
	
	@Override
	public int createTransaction(double amount, int id) {
	int rowsAffected = -1;
	try (Connection conn = setConnectionProperties.getConnection()){
		String sql = "{call new_tx(?,?)}";
		CallableStatement cs = conn.prepareCall(sql);
		cs.setDouble(1, amount);
		cs.setDouble(2, getAccount(id));
		rowsAffected = cs.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	return rowsAffected;
	}

	@Override
	public void createTransactionType(int typ) {
		try (Connection conn = setConnectionProperties.getConnection()) {
			String sql = "{call new_tx_type(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, typ);
			
			int rowsAffected = cs.executeUpdate();
			System.out.println("rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	//READ
	@Override
	public User getUser(String uname) throws NullPointerException{
		User u = null;
		try (Connection conn = setConnectionProperties.getConnection()){
			String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u = new User(rs.getInt("USERS_ID"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("USERNAME"), rs.getString("PASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return u;
	}
	
	@Override
	public User getAccountBalance(User u) {
		try (Connection conn = setConnectionProperties.getConnection()){
			String sql = "SELECT BALANCE FROM BANK_ACCOUNT WHERE USERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getU_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u.setBalance(rs.getDouble("BALANCE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return u;
	}
	
	@Override
	public int getAccount(int id) {
		int bal = 0;
		try (Connection conn = setConnectionProperties.getConnection()){
			String sql = "SELECT ACCOUNT_NUMBER FROM BANK_ACCOUNT WHERE USERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bal = (rs.getInt("ACCOUNT_NUMBER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return bal;
	}
	
	//Update
	@Override
	public int UpdateBalance(User u, double balance) {
		u.setBalance(balance);
		int rowsAffected = -1;
		try (Connection conn = setConnectionProperties.getConnection()) {
			String sql = "{call new_balance(?, ?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, balance);
			cs.setInt(2, u.getU_id());
			
			rowsAffected = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return rowsAffected;
	}
}
