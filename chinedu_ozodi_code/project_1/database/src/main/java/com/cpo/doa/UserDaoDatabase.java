package com.cpo.doa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<User> getAllUsers() {
		// Going to contain code for JDBC
				List<User> users = new ArrayList<User>();
				try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

					String sql = "SELECT * FROM users u INNER JOIN position p ON u.pos_id = p.pos_id";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						users.add(new User(rs.getInt(1), rs.getString("email"), rs.getString("password"), rs.getString("fname"),
								rs.getString("lname"), rs.getInt("pos_id"), rs.getString("pos_type")));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return users;
	}
	
	@Override
	public User getUserById(int id) {
		// Going to contain code for JDBC
		User user = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT * FROM users u RIGHT OUTER JOIN position p ON u.pos_id = p.pos_id WHERE u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
	
	@Override
	public User getUserByEmail(String email) {
		// Going to contain code for JDBC
		User user = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT * FROM users u RIGHT OUTER JOIN position p ON u.pos_id = p.pos_id WHERE email = ?";
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
	
	public int updateUser(User user) {
		int ra = 0;
		// Going to contain code for JDBC
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			
			if (user.getPassword() != null) {
				String sql = "UPDATE users SET email = ?,password = ?,fname = ?,lname = ?,pos_id = ? WHERE u_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getEmail());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getFname());
				ps.setString(4, user.getLname());
				ps.setInt(5, user.getPosId());
				ps.setInt(6, user.getuId());
				ra = ps.executeUpdate();
			}
			else {
				String sql = "UPDATE users SET email = ?, fname = ?,lname = ?,pos_id = ? WHERE u_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getEmail());
				ps.setString(2, user.getFname());
				ps.setString(3, user.getLname());
				ps.setInt(4, user.getPosId());
				ps.setInt(5, user.getuId());
				ra = ps.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ra;
	}

}
