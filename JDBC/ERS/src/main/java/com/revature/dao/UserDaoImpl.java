package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.POJO.Reimbursement;
import com.revature.POJO.User;
import com.revature.util.setConnectionProperties;

public class UserDaoImpl implements UserDao {

//CREATE
	@Override
	public void makeReimbursement(int u_id, double amt, String desc, int type) {
		int rowsAffected = -1;
		try (Connection conn = setConnectionProperties.getConnection()) {
			String sql = "INSERT INTO REIMBURSEMENT VALUES(RE_SEQ.nextval, ?, 0, ?, ?, NULL, CURRENT_TIMESTAMP, ?, 1)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u_id);
			ps.setDouble(2, amt);
			ps.setString(3, desc);
			ps.setInt(4, type);
			rowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

//READ
	@Override
	public User getUserByUsername(String email) {
		User db_u = null;
		try (Connection conn = setConnectionProperties.getConnection()) {
			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				db_u = new User(resultSet.getInt("U_ID"), resultSet.getString("EMAIL"), resultSet.getString("PASSWORD"),
						resultSet.getString("FNAME"), resultSet.getString("LNAME"), resultSet.getInt("POS_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (db_u != null) {
			System.out.println("user obtained");
			return db_u;
		} else {
			System.out.println("no user found");
			return null;
		}
	}

	@Override
	public List<User> getManagers(boolean all, int id) {
		List<User> managers = new ArrayList<>();
		ResultSet resultSet;
		try (Connection conn = setConnectionProperties.getConnection()) {
			if (all) {
				String sql = "SELECT * FROM USERS WHERE POS_ID = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, 1);
				resultSet = ps.executeQuery();
			} else {
				String sql = "SELECT * FROM USERS WHERE U_ID = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				resultSet = ps.executeQuery();
			}
			while (resultSet.next()) {
				User u = new User(resultSet.getInt("U_ID"), resultSet.getString("EMAIL"),
						resultSet.getString("PASSWORD"), resultSet.getString("FNAME"), resultSet.getString("LNAME"),
						resultSet.getInt("POS_ID"));
				managers.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return managers;
	}

	@Override
	public List<User> getUsers(boolean all, int id) {
		List<User> users = new ArrayList<>();
		ResultSet resultSet;
		try (Connection conn = setConnectionProperties.getConnection()) {
			if (all) {
				String sql = "SELECT * FROM USERS WHERE POS_ID != 1";
				PreparedStatement ps = conn.prepareStatement(sql);
				resultSet = ps.executeQuery();
			} else {
				String sql = "SELECT * FROM USERS WHERE U_ID = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				resultSet = ps.executeQuery();
			}
			while (resultSet.next()) {
				User u = new User(resultSet.getInt("U_ID"), resultSet.getString("EMAIL"),
						resultSet.getString("PASSWORD"), resultSet.getString("FNAME"), resultSet.getString("LNAME"),
						resultSet.getInt("POS_ID"));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return users;
	}

	@Override
	public List<Reimbursement> getReById(int id, boolean all) {
		String sql = null;
		PreparedStatement ps = null;
		List<Reimbursement> re = new ArrayList<>();
		try (Connection conn = setConnectionProperties.getConnection()) {
			if (all) {
				sql = "SELECT * FROM REIMBURSEMENT";
				ps = conn.prepareStatement(sql);
			} else {
				sql = "SELECT * FROM REIMBURSEMENT WHERE EMP_U_ID = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
			}
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Reimbursement r = new Reimbursement(resultSet.getInt("R_ID"), empName(resultSet),
						resultSet.getInt("EMP_U_ID"), manName(resultSet), resultSet.getDouble("AMT"),
						resultSet.getString("DESCRIPTION"), resultSet.getString("TIMESUBMISSION"),
						Type(resultSet.getInt("RQ_TYPE_ID")), statusState(resultSet));
				re.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return re;
	}

	public String manName(ResultSet resultSet) {
		User man = null;
		try {
			man = getManagers(false, resultSet.getInt("MGR_U_ID")).get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return man.getFname() + " " + man.getLname();
	}

	public String empName(ResultSet resultSet) {
		User man = null;
		try {
			man = getUsers(false, resultSet.getInt("EMP_U_ID")).get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return man.getFname() + " " + man.getLname();
	}

	public String Type(int id) {
		String type = null;
		try (Connection conn = setConnectionProperties.getConnection()) {
			String sql = "SELECT RQ_TYPE FROM RQ_TYPE WHERE RQ_TYPE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				type = resultSet.getString("RQ_TYPE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return type;
	}

	public String statusState(ResultSet resultSet) {
		try {
			if (resultSet.getInt("RQ_STATUS_ID") == 1) {
				return "Pending";
			} else if (resultSet.getInt("RQ_STATUS_ID") == 2) {
				return "Accepted";
			} else {
				return "Denied";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//UPDATE
	@Override
	public void updateUser(String email, String fname, String lname, int id) {
		int rowsAffected = -1;
		try (Connection conn = setConnectionProperties.getConnection()) {
			String sql = "{call CHANGE_USER(?, ?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setString(1, email);
			cs.setString(2, fname);
			cs.setString(3, lname);
			cs.setInt(4, id);

			rowsAffected = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void updateReStatus(int mid, int sid, int rid) {
		int rowsAffected = 0;
		try (Connection conn = setConnectionProperties.getConnection()) {
			String sql = "{call CHANGE_RE_STATUS(?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setInt(1, mid);
			cs.setInt(2, sid);
			cs.setInt(3, rid);

			rowsAffected = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
