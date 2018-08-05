package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.Pojos.User;

public class CookieBankDao { // in reference to my database
	private final static String USERNAME = "bank_db"; //Username from database
	private final static String PASSWORD = "p4ssw0rd"; // password from database
	private final static String URL = "jdbc:oracle:thin:@octocat.ckichuqa168o.us-east-2.rds.amazonaws.com:1521:ORCL";
	// jdbc:oracle:thin@octocat + hostname
	
	//READ
	public User thatUser(String usename) { // 
		User you = null;
		//SETS UP THE CONNECTION
		
		//CONNECTS TO THE DATA BASE
		try { 
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);//Connects using the url, username pw
			String sql = "SELECT * FROM USERS"; // Passes this string to sql, sql runs this command
			PreparedStatement statement = con.prepareStatement(sql); //sets up
			ResultSet rs = statement.executeQuery(sql);// what actually connects to the database and runs the command
			
			if(rs.next()) { 
				you = new User(rs.getInt("USERS_ID"), rs.getString("USERNAME"), rs.getString("PASSWORD")); // when i get here this returns the user and I receive an error
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return you;
		
	}
}
