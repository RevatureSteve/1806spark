package com.revature.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.pojo.User;

public class BankDao {
	private final static String USERNAME = "riskra";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@kukuy.cmgq1zpczcbi.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	//CREATE
	
	/*

	public int createFlashCard(FlashCard fc) {
		int rowsAffected = -1;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "INSERT INTO flash_cards(fc_question, fc_answer) VALUES(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fc.getFcQuestion());
			ps.setString(2, fc.getFcAnswer());
			rowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
	

	public void createFlashCardProc(FlashCard fc) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call insert_fc_procedure(?, ?, ?)}"; //surround in {}, it works without but nothing gets returned 
			String msg = "";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, fc.getFcQuestion());
			cs.setString(2, fc.getFcAnswer());
			cs.setString(3, msg);
			
			int rowsAffected = cs.executeUpdate();
			System.out.println("rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	*/
	//READ
	public User getFlashCardById(String uname) {
		User u = null;
		try {
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM USERS WHERE USERNAME = " + uname;
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs.next()) {
				u = new User(rs.getInt("USERS_ID"), rs.getString("USERNAME"), rs.getString("PASSWORD"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}
