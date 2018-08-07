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
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return account;//we return the "account" variable 
		}
		
		@Override
		public Users getUserByUserName(String userName) {
			// TODO Auto-generated method stub
			return null;
		}

		//UPDATE
		@Override
		public void depositIntoBank(double txAmount, int userId) {
			try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
				String sql = "{call get_tx(?, ?)}";
				String name = null;
				CallableStatement cs = conn.prepareCall(sql);
				cs.setInt(1, userId);
				cs.setDouble(2, txAmount);
				cs.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
