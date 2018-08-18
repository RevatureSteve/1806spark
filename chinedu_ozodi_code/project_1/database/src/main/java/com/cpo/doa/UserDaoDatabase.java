package com.cpo.doa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cpo.model.User;
import com.cpo.util.SetConnectionPropertiesUtil;

public class UserDaoDatabase implements UserDao {
	
	private static UserDaoDatabase instance;
	

	private UserDaoDatabase() {
	}

	// ---------------CREATE----------------

	@Override
	public int createUser(User user) {
		int ra = 0;
		// Going to contain code for JDBC
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "INSERT INTO users (email,password,fname,lname,pos_id) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFname());
			ps.setString(4, user.getLname());
			ps.setInt(5, user.getPosId());
			ra = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ra;
	}

	public static UserDaoDatabase getInstance() {
		if (instance == null)
			instance = new UserDaoDatabase();
		return instance;
	}
	// ---------------READ-----------------

	public User getUserByEmail(String email) {
		// Going to contain code for JDBC
		User user = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString("email"), rs.getString("password"), rs.getString("fname"),
						rs.getString("lname"), rs.getInt("pos_id"), rs.getString("pos_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return user;
	}

}
