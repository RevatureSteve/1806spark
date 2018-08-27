package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pogo.Reimbursement;
import com.revature.pogo.Users;
import com.revature.util.SetConnectionPropertiesUtil;

public class ProjectOneDaoImpl implements ProjectOneDao {

	// CREATE
	@Override
	public int createReimbursement(int amt, int emp_U_Id, int rq_Type_Id, String description) {
		System.out.println("[LOG]---Starting---createReimbursement(users-parameters)");
		int rowsAffected = 0;
		
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO reimbursement (amt, emp_U_Id, rq_Type_Id, description) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, amt);
			ps.setInt(2, emp_U_Id);
			ps.setInt(3, rq_Type_Id);
			ps.setString(4, description);
			rowsAffected = ps.executeUpdate();
			conn.commit();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(rowsAffected + " reimbursement request has been sent!");
		
		return rowsAffected;
	}

	// READ
	public List<Users> getAllUsers() {
		System.err.println("[LOG]---Starting---getAllUsers() argument: ");
		List<Users> users = new ArrayList<>();

		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				users.add(new Users(rs.getInt("U_ID"), rs.getString("EMAIL"), rs.getString("PASSWORD"),
						rs.getString("FNAME"), rs.getString("LNAME"), rs.getInt("POS_ID")));
			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(users);
		return users;
	}
	
 	public Users getUserByEmail(String email) {
		System.err.println("[LOG]---Starting---getUserByEmail() argument: " + email);
		Users users = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {

			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			// ps.executeQuery() and not executeUpdate b/c we are retrieving data and not
			// modifying data within the database
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				users = new Users(rs.getInt("U_ID"), rs.getString("EMAIL"), rs.getString("PASSWORD"),
						rs.getString("FNAME"), rs.getString("LNAME"), rs.getInt("POS_ID"));
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
		System.out.println(users);
		return users;
	}

	@Override
	public List<Reimbursement> getAllPendingReimb() {
		List<Reimbursement> reimb = new ArrayList<>();
		System.err.println("[LOG---Starting---getAllPendingReimb() argument: ]");

		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			String sql = "SELECT * FROM reimbursement WHERE rq_status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			// setting rq_status_id as 1
			ps.setString(1, "1");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimb.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("AMT"), rs.getInt("EMP_U_ID"),
						rs.getInt("MGR_U_ID"), rs.getInt("RQ_TYPE_ID"), rs.getInt("RQ_STATUS_ID"),
						rs.getString("DESCRIPTION"), rs.getString("TIMESUBMISSION")));
			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(reimb);
		return reimb;
	}

	@Override
	public List<Reimbursement> getAllApprovedReimb() {
		List<Reimbursement> reimb = new ArrayList<>();
		System.err.println("[LOG---Starting---getAllApprovedReimb() argument: ]");

		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			String sql = "SELECT * FROM reimbursement WHERE rq_status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			// setting rq_status_id as 2
			ps.setString(1, "2");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimb.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("AMT"), rs.getInt("EMP_U_ID"),
						rs.getInt("MGR_U_ID"), rs.getInt("RQ_TYPE_ID"), rs.getInt("RQ_STATUS_ID"),
						rs.getString("DESCRIPTION"), rs.getString("TIMESUBMISSION")));
			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(reimb);
		return reimb;
	}

	@Override
	public List<Reimbursement> getAllDeniedReimb() {
		List<Reimbursement> reimb = new ArrayList<>();
		System.err.println("[LOG---Starting---getAllDeniedReimb() argument: ]");

		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			String sql = "SELECT * FROM reimbursement WHERE rq_status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			// setting rq_status_id as 3
			ps.setString(1, "3");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimb.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("AMT"), rs.getInt("EMP_U_ID"),
						rs.getInt("MGR_U_ID"), rs.getInt("RQ_TYPE_ID"), rs.getInt("RQ_STATUS_ID"),
						rs.getString("DESCRIPTION"), rs.getString("TIMESUBMISSION")));
			}

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(reimb);
		return reimb;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> reimb = new ArrayList<>();
		System.err.println("[LOG---Starting---getAllReimbursement() argument: ]");

		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			String sql = "SELECT * FROM reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			// Again, ps.executeQuery b/c we are only retrieving data from our database
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimb.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("AMT"), rs.getInt("EMP_U_ID"),
						rs.getInt("MGR_U_ID"), rs.getInt("RQ_TYPE_ID"), rs.getInt("RQ_STATUS_ID"),
						rs.getString("DESCRIPTION"), rs.getString("TIMESUBMISSION")));
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

		System.out.println(reimb);
		return reimb;
	}

	// UPDATE
	@Override
	public int updateUser(String email, String password, String fname, String lname, int u_Id) {
		System.out.println("[LOG]---Starting---updateUsers(users-parameters)");
		int rowsAffected = 0;
		
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE users SET fname = ?" + ", lname = ?" + ", email = ?" + ", password = ?" + " WHERE u_Id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setInt(5, u_Id);
			rowsAffected = ps.executeUpdate();
			conn.commit();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(rowsAffected + " update has been sent!");
		
		return rowsAffected;
	}

	// DELETE

}
