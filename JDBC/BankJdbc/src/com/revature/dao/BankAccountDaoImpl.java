package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class BankAccountDaoImpl implements MainDao{

	//Here we are using our oracle SQL username, password and URL to access the SQL schema to use for our DAO implementation
		private final static String USERNAME = "bank_db";//name of our data base
		private final static String PASSWORD = "p4ssw0rd";//password to access out database
		private final static String URL = "jdbc:oracle:thin:@octocat.cxwq5mzpnovv.us-east-2.rds.amazonaws.com:1521:ORCL";//endpoint of our database
		
		
		//CREATE
		@Override
		public int create(Object obj) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
		/*
		 * THIS IS MY VIEW BANK ACCOUNT USERCASE!!
		 * This is where I can access my bank account in my database 
		 */
		//READ
		public BankAccount getBankAccountByUserId(int userId) {//using both my pojo and a new method ("BankAccount") to get the users_id in SQL
			BankAccount account = null;//must make this variable local so it can be used
					
			try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {//establish connection to the database
				String sql = "SELECT * FROM bank_account WHERE users_id = (?)";//declare the statement we want to use to call the userName in SQL, note: you must supply a value in place of the "?" otherwise it will not initiate
				PreparedStatement ps = conn.prepareStatement(sql);//prepare a statement to be used in SQL which we did above
				ps.setInt(1, userId);//this tells me where to place the values in the "?" and it is placed within position "1" with a value of "userName"
				ResultSet rs = ps.executeQuery();//this is and object where it stores the database result set of whatever we executed in the "String sql" statement above 
				
				if (rs.next()) {
					account = new BankAccount(rs.getInt("account_number"), rs.getDouble("Balance"), rs.getInt("users_id"));
					BankAccount.getBankAccount(rs.getInt("account_number"), rs.getDouble("Balance"), rs.getInt("users_id"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return account;//we return the "account" variable 
		}
		
		public Users getUserByUserName(String userName) {//using both my pojo and a new method ("getUserByUserName") to get the userName in SQL
			Users user = null;//must make this variable local so it can be used
			try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {//establish connection to the database
				String sql = "SELECT * FROM users WHERE username = (?)";//declare the statement we want to use to call the userName in SQL, note: you must supply a value in place of the "?" otherwise it will not intiate
				PreparedStatement ps = conn.prepareStatement(sql);//prepare a statement to be used in SQL which we did above
				ps.setString(1, userName);//this tells me where to place the values in the "?" and it is placed within position "1" with a value of "userName"
				ResultSet rs = ps.executeQuery();//this is and object where it stores the database result set of whatever we executed in the "String sql" statement above 
				while (rs.next()) {//here we use a pointer "rs.next" alon with a while loop through our result set of usernames
					user = new Users(rs.getInt("users_id"), rs.getString("username"), rs.getString("password"), rs.getString("fname"), rs.getString("lname"));
					Users.getUsers(rs.getInt("users_id"), rs.getString("username"), rs.getString("password"), rs.getString("fname"), rs.getString("lname"));

					
				}//the above line we are pulling the user and the result set of the sql table "users"
			} catch (SQLException e) {//here to catch any sort of error with the try/catch block
				e.printStackTrace();//prints out the error
			}
			return user;//we return the "user" variable 
		}	

		
		//UPDATE
		public void depositIntoBank(double txAmount, int userId) {
			
			try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
				String sql = "{call deposit (?, ?)}";
				CallableStatement cs = conn.prepareCall(sql);
				cs.setDouble(1, txAmount);
				cs.setInt(2, userId);
				int rowsAffected = cs.executeUpdate();
				System.out.println("rows affected" + rowsAffected);
				BankAccount.deposit(txAmount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void withdrawFromBank(double txAmount, int userId) {
			
			try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
				String sql = "{call withdrawl (?, ?)}";
				CallableStatement cs = conn.prepareCall(sql);
				cs.setDouble(1, txAmount);
				cs.setInt(2, userId);
				int rowsAffected = cs.executeUpdate();
				System.out.println("rows affected" + rowsAffected);
				BankAccount.withdraw(txAmount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
