package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.User;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public User getUserByEmail(String email) {
		
		User user = null;
		
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "\r\n" + 
					"SELECT u.u_id, u.email, u.password, u.fname, u.lname, u.pos_id, p.pos_type\r\n" + 
					"FROM users u\r\n" + 
					"INNER JOIN position p ON u.pos_id = p.pos_id\r\n" + 
					"WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User(rs.getInt("u_id"),rs.getString("email"), rs.getString("password"), rs.getString("fname"), 
						rs.getString("lname"), rs.getInt("pos_id"), rs.getString("pos_type"));
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updateEmployee(int uId, String pw, String fname, String lname) {
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "{ call update_employee_info(?,?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, uId);
			cs.setString(2, pw);
			cs.setString(3, fname);
			cs.setString(4, lname);
			cs.executeUpdate();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllEmployees() {
		List<User> user = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			
			String sql = "SELECT u.u_id, u.email, u.password, u.fname, u.lname, u.pos_id, p.pos_type\r\n" + 
					"FROM users u\r\n" + 
					"INNER JOIN position p ON u.pos_id = p.pos_id\r\n" +
					"WHERE u.pos_id = 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.add(new User(rs.getInt("u_id"),rs.getString("email"), rs.getString("password"), rs.getString("fname"), 
						rs.getString("lname"), rs.getInt("pos_id"), rs.getString("pos_type")));
			}
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	
}
