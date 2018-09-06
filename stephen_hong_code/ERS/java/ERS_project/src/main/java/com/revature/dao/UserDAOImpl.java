package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;
import com.revature.util.SetConnectionPropertiesUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public User createUser(User user) {
		try(Connection conn = SetConnectionPropertiesUtil.getConnection()){
			String sql = "INSERT INTO ers_users(ers_username, ers_password_hash, ers_password_salt, user_first_name, user_last_name, user_email, user_role_id) VALUES (?,?,?,?,?,?,?)";

			String[] keys = {"ers_users_id"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPwHash());
			ps.setString(3, user.getPwSalt());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setString(6, user.getEmail());
			ps.setInt(7, user.getRole());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();

			if(rs.next()) {
				user.setId(rs.getInt(1));
			} else {
				user.setId(-1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		try(Connection conn = SetConnectionPropertiesUtil.getConnection()){
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			//pre-compiling SQL statement
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			//Use ResultSet and executeQuery for SELECT
			if(rs.next()) {
				user = new User(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ers_users WHERE user_email = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				user = new User(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User getUserById(int id) {
		User user = null;

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ers_users WHERE ers_users_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				user = new User(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		try(Connection conn = SetConnectionPropertiesUtil.getConnection()){
			String sql = "SELECT * FROM ers_users";
			PreparedStatement ps = conn.prepareStatement(sql);
			//pre-compiling SQL statement without the parameter values
			ResultSet rs = ps.executeQuery(sql);
			//Use ResultSet and executeQuery for SELECT
			while(rs.next()) {
				User temp = new User(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8));
				users.add(temp);
			}//loop through and select users from the table and add them to the list
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}