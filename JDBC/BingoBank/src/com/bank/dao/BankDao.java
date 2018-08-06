package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class BankDao {
	// DB Information.
	final String URL ="jdbc:oracle:thin:@revaturedatabase.c4iijzopvhom.us-east-2.rds.amazonaws.com:1521:ORCL";
	final String D_USERNAME = "bank_DB";
	final String D_PASSWORD = "p4ssw0rd";
	
	//
	public void getAllUsers() {
	try (Connection conn = DriverManager.getConnection(URL, D_USERNAME, D_PASSWORD)) {
		String sql = "SELECT * FROM users";
	PreparedStatement statement = conn.prepareStatement(sql);
	statement.executeQuery(sql);
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	System.out.println("Connection");
	
	}
}