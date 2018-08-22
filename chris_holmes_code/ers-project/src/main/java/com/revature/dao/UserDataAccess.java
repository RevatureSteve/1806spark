package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDataAccess implements UserDao {

		@Override
		public int create(Object obj) {
			return 0;
		}
		
		@Override
		public List<Object> read() {
			List<Object> user = new ArrayList<>(); // makes empty array list
			
			try(Connection con = SetConnectionPropertiesUtil.getConnection();){ // connects to the database using these fields
				String sql = "SELECT* FROM users"; //Selects from users in SQL
				PreparedStatement statement = con.prepareStatement(sql);// Creating a prepared statement takes sql argument
				ResultSet results = statement.executeQuery();// results from that search 
				while (results.next()) {
					User User = new User(results.getInt(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5), 0);
					user.add(User);
				}
			} catch(SQLException | IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return user;	
		}
		@Override
		public int update(Object obj) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public User getUserbyEmail(String email) {
			// TODO Auto-generated method stub
			return null;
		}
		
}	
	
	

