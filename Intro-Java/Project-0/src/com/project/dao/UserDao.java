package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Dao;
import com.project.pojo.BankBal;
import com.project.pojo.BankUsers;

public class UserDao implements Dao {
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@gooddata.chd4toccqgaj.us-east-2.rds.amazonaws.com:1521:ORCL";


	@Override
	public int create(Object obj) {
	
		return 0;
	}

	@Override
	public List<Object> read() {
		List<Object> users = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BankUsers user = new BankUsers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)); 
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
