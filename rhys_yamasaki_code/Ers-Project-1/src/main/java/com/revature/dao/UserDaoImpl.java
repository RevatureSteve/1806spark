package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojo.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public User getUserByEmail(String email) {
		
		User user = null;
		
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User(rs.getInt("u_id"),rs.getString("email"), rs.getString("password"), rs.getString("fname"), rs.getString("lname"), rs.getInt("pos_id"));
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	
	
}
