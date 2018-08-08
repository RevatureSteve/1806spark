package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDaoImpl implements UserDao {
	private final static String USERNAME = "";
	private final static String PASSWORD = "";
	private final static String URL = "";
	public User getUserByUsername(String username) {
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			System.err.println("[LOG]---inside try/catch----getUsterByUser() connection to db successful");
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			System.err.println("[LOG]---resultsetcompleted----getUsterByUser() connection to db successful");
			while(rs.next()) {
				return new User(rs.getInt(1),rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//JDBC code
		return null;
	}
}
