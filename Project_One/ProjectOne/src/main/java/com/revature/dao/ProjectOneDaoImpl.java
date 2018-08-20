package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.Driver;
import com.revature.pogo.Reimbursement;
import com.revature.pogo.Users;
import com.revature.util.SetConnectionPropertiesUtil;

public class ProjectOneDaoImpl implements ProjectOneDao {

//	private final static String url = "jdbc:oracle:thin:@pvtmad.cz07tejakuok.us-east-2.rds.amazonaws.com:1521";
//	private final static String username = "reimbursement_db";
//	private final static String password = "p4ssw0rd";

	// CREATE

	// READ
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
		return reimb;
	}

	@Override
	public List<Reimbursement> getAllDeniedReimb() {
		List<Reimbursement> reimb = new ArrayList<>();
		System.err.println("[LOG---Starting---getAllDeniedReimb() argument: ]");

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

	// DELETE

}
