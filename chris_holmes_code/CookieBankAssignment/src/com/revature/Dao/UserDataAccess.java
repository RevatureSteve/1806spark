package com.revature.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.interfaces.DataAccess;
import com.revature.pojos.Cookieuser;

public class UserDataAccess implements DataAccess { // in reference to my database
		private final static String USERNAME = "bank_db"; //Username from database
		private final static String PASSWORD = "p4ssw0rd"; // password from database
		private final static String URL = "jdbc:oracle:thin:@octocat.ckichuqa168o.us-east-2.rds.amazonaws.com:1521:ORCL";
		// jdbc:oracle:thin@octocat + hostname
		
		@Override
		public int create(Object obj) {
			return 0;
		}
		
		@Override
		public List<Object> read() {
			List<Object> cookieuser = new ArrayList<>(); // makes empty array list
			
			try(Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){ // connects to the database using these fields
				String sql = "SELECT* FROM users"; //Selects from users in SQL
				PreparedStatement statement = con.prepareStatement(sql);// Creating a prepared statement takes sql argument
				ResultSet results = statement.executeQuery();// results from that search 
				while (results.next()) {
					Cookieuser cUser = new Cookieuser(results.getInt(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5));
					cookieuser.add(cUser);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return cookieuser;	
		}
		@Override
		public int update(Object obj) {
			// TODO Auto-generated method stub
			return 0;
		}
		
}
		
		
		
