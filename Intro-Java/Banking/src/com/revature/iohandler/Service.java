package com.revature.iohandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.revature.pojos.User;
import com.revature.singletons.LoggedUser;

public class Service {
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
	
	public boolean containsNewUser(User user, List<User> listOfUsers) {
		for(User u : listOfUsers) {
			if(user.getUsername().equals(u.getUsername())) {
				return true;
			}
		}
		return false;
		
	}
	
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
