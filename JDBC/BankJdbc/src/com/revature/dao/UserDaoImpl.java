package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class UserDaoImpl implements MainDao {

	//Here we are using our oracle SQL username, password and URL to access the SQL schema to use for our DAO implementation
	private final static String USERNAME = "bank_db";//name of our data base
	private final static String PASSWORD = "p4ssw0rd";//password to access out database
	private final static String URL = "jdbc:oracle:thin:@octocat.cxwq5mzpnovv.us-east-2.rds.amazonaws.com:1521:ORCL";//endpoint of our database
	
	//CREATE
	public int create(Object obj) {
		Users user = (Users) obj;
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "INSERT INTO users (username, password, fname, lname) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getfName());
			ps.setString(4, user.getlName());
			rowsAffected = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	//READ
	public List<Object> read() {
		
		List<Object> users = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Users user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	/*
	 * THIS IS MY LOGIN USERCASE!!
	 * This is where I can access the username and password in my database to compare it to what I types into the console
	 */
	//READ
	public Users getUserByUserName(String userName) {//using both my pojo and a new method ("getUserByUserName") to get the userName in SQL
		Users user = null;//must make this variable local so it can be used
				
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {//establish connection to the database
			String sql = "SELECT * FROM users WHERE username = (?)";//declare the statement we want to use to call the userName in SQL, note: you must supply a value in place of the "?" otherwise it will not intiate
			PreparedStatement ps = conn.prepareStatement(sql);//prepare a statement to be used in SQL which we did above
			ps.setString(1, userName);//this tells me where to place the values in the "?" and it is placed within position "1" with a value of "userName"
			ResultSet rs = ps.executeQuery();//this is and object where it stores the database result set of whatever we executed in the "String sql" statement above 
			while (rs.next()) {//here we use a pointer "rs.next" alon with a while loop through our result set of usernames
				user = new Users(rs.getInt("users_id"), rs.getString("username"), rs.getString("password"), rs.getString("fname"), rs.getString("lname"));
			}//the above line we are pulling the user and the result set of the sql table "users"
		} catch (SQLException e) {//here to catch any sort of error with the try/catch block
			e.printStackTrace();//prints out the error
		}
		return user;//we return the "user" variable 
	}

	//UPDATE
	//note: it is not being used atm
	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

/*	@Override
	public BankAccount getUserByUserId(int userId) {
		Users user = null;
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM users WHERE username = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}*/
}
