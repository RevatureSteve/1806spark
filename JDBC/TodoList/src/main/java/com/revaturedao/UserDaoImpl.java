package com.revaturedao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDaoImpl implements UserDao{
	
	//What do I need for a JDBC Connection
	//and the last thing? Driver which is the Jar for that specific database

	@Override
	public User getUserByUsername(String username) {
		System.err.println("[LOG]---Starting---getUserByUsername() arguement: " + username);//makes font color red
		//what is this method code going to contain? JDBC Code
		User user = null;
		
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);//precompiling the SQL statement without the parameter values
			ps.setString(1, username);
			ResultSet resultSet = ps.executeQuery();
			//dont need a loop...username is unique in the db and should only return 1 record or none
			if(resultSet.next()) {
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return user;
	}

}
