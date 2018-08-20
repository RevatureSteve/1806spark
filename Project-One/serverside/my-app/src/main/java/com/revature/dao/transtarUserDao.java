package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.TranstarUsers;
import com.revature.util.ConnectionsPropertiesUtil;

public class transtarUserDao {
	
	public List<TranstarUsers> readUsers() {
		List<TranstarUsers> users = new ArrayList<>();
		try (Connection con = ConnectionsPropertiesUtil.newConnection();){
			String sql = "SELECT * FROM users a INNER JOIN position b ON a.pos_id = b.pos_id";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TranstarUsers user = new TranstarUsers(rs.getInt(1), rs.getString("email"), rs.getString("password"), rs.getString("fname"), rs.getString("lname"), rs.getInt("pos_id"),rs.getString("pos_type"));
				users.add(user);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}
