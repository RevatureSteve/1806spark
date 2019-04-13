package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.Util.DbConnection;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public class DaoImpl implements ReimbursementDao {
	
	/*final static String username = "reimburse_db";
	final static String password = "p4ssw0rd";
	final static String URL = "jdbc:oracle:thin:@octocat.cc0hd2rbzuaq.us-east-2.rds.amazonaws.com:1521:ORCL";*/

	
	public int createUser(User person) {
		return 0;
	}

	public List<User> getAllUser() {
		List<User> allUsers = new ArrayList();
		try (Connection conn = DbConnection.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM USERS";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				User u = new User(rs.getInt("U_ID"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("FNAME"),
						rs.getString("LNAME"), rs.getInt("POS_ID"));
				allUsers.add(u); //Each time there's a new user added to the list 

			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		return allUsers;
	}

	public User getUsersById(int userId) {
		User id = null;
		try (Connection conn = DbConnection.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM USERS WHERE U_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				id = new User(rs.getInt("U_ID"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("FNAME"),
						rs.getString("LNAME"), rs.getInt("POS_ID"));

			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		return id;
	}

	public User getUserByEmail(String email) {
		User user = null;
		try (Connection conn = DbConnection.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM USERS WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				user = new User(rs.getInt("U_ID"), rs.getString("EMAIL"), rs.getString("PASSWORD"),
						rs.getString("FNAME"), rs.getString("LNAME"), rs.getInt("POS_ID"));

			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return user;
	}

	public List<Reimbursement> getAllReimbursement() {
		List<Reimbursement> reims = new ArrayList();
		try (Connection conn = DbConnection.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM REIMBURSEMENT";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

			Reimbursement reim = new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MGR_U_ID"),
						rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getBlob("IMG"), rs.getTimestamp("TIMESUBMISSION"),
						rs.getInt("RQ_TYPE_ID"), rs.getInt("RQ_STATUS_ID"));
				reims.add(reim);

			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return reims;
	}

	@Override
	public Reimbursement getStatusById(int statusId) {
		Reimbursement status = null;
		try (Connection conn = DbConnection.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM REIMBURSEMENT WHERE RQ_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				status = new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MAN_U_ID"),
						rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getBlob("IMG"), rs.getTimestamp("TIMESTAMP"),
						rs.getInt("RQ_TYPE_ID"), rs.getInt("RS_STATUS_ID"));

			}
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return status;

	}

	@Override
	public int updateStatus(Reimbursement request) {
		int rowsAffected = 0;
		try (Connection conn = DbConnection.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE REIMBURSEMENT SET RQ_STATUS_ID = ?, MGR_U_ID = ? WHERE R_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, request.getRequestStatusId());
			ps.setInt(2, request.getManagerId());
			ps.setInt(3, request.getRequestId());
			int rs = ps.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		return rowsAffected;
	}

	@Override
	public int createReimbursementRequest(Reimbursement request) {
		int rowsAffected = 0;
		try (Connection conn = DbConnection.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO REIMBURSEMENT (amt, description, img, timesubmission, rq_type_id, emp_u_id, rq_status_id) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, request.getAmount());
			ps.setString(2, request.getDescription());
			ps.setBlob(3, request.getImg());
			ps.setTimestamp(4, request.getTimeSubmission());
			ps.setInt(5, request.getRequestTypeId());
			ps.setInt(6, request.getEmployeeId());
			ps.setInt(7, 1);
			int rs = ps.executeUpdate();
			conn.commit();
			System.out.println("works yay");

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		return rowsAffected;
	}

	@Override
	public int password(String password, User person) {
		int rowsAffected = 0;
		try (Connection conn = DbConnection.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE USERS SET PASSWORD = ? WHERE U_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, person.getUserID());
			int rs = ps.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		return rowsAffected;
	}


	@Override
	public int updateName(String fName, User person, String lName) {
		int rowsAffected = 0;
		try (Connection conn = DbConnection.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE USERS SET FNAME = ?, LNAME = ? WHERE U_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fName);
			ps.setString(2, lName);
			ps.setInt(2, person.getUserID());
			int rs = ps.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		return rowsAffected;
	}

	@Override
	public int updateUser(User user) {
		int rowsAffected = 0;
		try (Connection conn = DbConnection.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE USERS SET FNAME = ?, LNAME = ?, PASSWORD = ? WHERE U_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getUserID());
			int rs = ps.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		return rowsAffected;
	}

}
