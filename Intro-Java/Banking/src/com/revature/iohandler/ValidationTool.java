package com.revature.iohandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.singletons.LoggedUser;

public class ValidationTool {
	private static final String URL = "jdbc:oracle:thin:@marcin-salamon-oracle.ch2v7k2we1qt.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static final String USERNAME = "bank_db";
	private static final String PASSWORD = "p4ssw0rd";
	public boolean validateUser(String username, String password) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME,
				PASSWORD);) {
			String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LoggedUser.getUser().setUserId(rs.getInt(1));
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
