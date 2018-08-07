package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Dao;

public class TransDao implements Dao {
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
	public static int newTransaction(int uId, int newBal) {
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "UPDATE bank_account SET balance = (?) WHERE users_id = (?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newBal);
			ps.setInt(2, uId);
			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
