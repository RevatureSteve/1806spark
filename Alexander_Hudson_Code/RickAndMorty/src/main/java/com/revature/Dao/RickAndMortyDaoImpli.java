package com.revature.Dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ConnectionUtil.SetConnectionUtil;
import com.revature.Pojo.Reimbursement;
import com.revature.Pojo.Users;

public class RickAndMortyDaoImpli implements RickAndMortyDao {
	
	
//	private final static String USERNAME = "";
//	private final static String PASSWORD = "";
//	private final static String URL = "";
	
	
	
	//----------------------------------------------------------------------------------------------------------
	//CREATE
	
	@Override
	public int createReimbursement(int emp_U_Id, int amt, String description, int rq_Type) {
		int rowsAffected = 0;
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
			System.out.println("Connected");
		
			conn.setAutoCommit(false);
		String sql = "INSERT INTO reimbursement (emp_U_Id, amt, description, rq_Type) VALUES (?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, emp_U_Id);
		ps.setInt(2, amt);
		ps.setString(3, description);
		ps.setInt(4, rq_Type);
		
		rowsAffected = ps.executeUpdate();
		System.out.println("executing update");
		
		
		} catch (IOException | SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsAffected;
		
	}
		
	
	
	
	//-----------------------------------------------------------------------------------------
	//READ
	@Override
	public Users getUserByEmail(String email, String password) {
		Users us = null;
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
			System.out.println("Connected");
			
			String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			System.out.println("Retrieving Information");
			
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				us = new Users (rs.getInt("U_ID"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getInt("POS_ID"));
				
			}
			} catch (IOException | SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(us);
			return us;
	}
	
	@Override
	public List<Users> getAllUsers() {
		List <Users> us = new ArrayList<>();
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
			System.out.println("Connected");
			
			String sql = "SELECT * FROM users WHERE pos_id = 2";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("Retrieving Information");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				us.add (new Users (rs.getInt("U_ID"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getInt("POS_ID")));
				
			}
			} catch (IOException | SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(us);
			return us;
	}
	
	public List<Users> getAllInfo(int u_Id) {
		List <Users> us = new ArrayList<>();
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
			System.out.println("Connected");
			
			String sql = "SELECT * FROM users WHERE u_Id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u_Id);
			System.out.println("Retrieving Information");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				us.add (new Users (rs.getInt("U_ID"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getInt("POS_ID")));
				
			}
			} catch (IOException | SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(us);
			return us;
	}
	
	public int updateReim(int r_Id, int rq_Status_Id, int mgr_U_Id) {
		int rowsAffected = 0;
	try (Connection conn = SetConnectionUtil.getConnection()){
		String sql = "{call resolved (?,?,?)}";
		CallableStatement cs = conn.prepareCall(sql);
		cs.setInt(1, r_Id);
		cs.setInt(2, rq_Status_Id);
		cs.setInt(3, mgr_U_Id);
		rowsAffected = cs.executeUpdate();
	} catch (IOException | SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rowsAffected;
	
}
	
	@Override
	public List <Reimbursement> getAllReimbursements(){
		List <Reimbursement> re = new ArrayList<>();
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
			System.out.println("Connected");
		
		String sql = "SELECT * FROM reimbursement";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			re.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MGR_U_ID"), rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getTimestamp("TIME_SUBMISSION"), rs.getInt("RQ_TYPE"), rs.getInt("RQ_STATUS_ID")));
		}
		
		} catch (IOException | SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(re);
		return re;
		
	}
	
	
	public List <Reimbursement> getAllReimbursementsByApproved(int rq_Status_Id){
		List <Reimbursement> re = new ArrayList<>();
		System.out.println("Connected");
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
			
		
		String sql = "SELECT * FROM reimbursement WHERE rq_Status_Id = 1";
		
		
		PreparedStatement ps = conn.prepareStatement(sql);

		
		System.out.println("Retrieving Information");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			re.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MGR_U_ID"), rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getTimestamp("TIME_SUBMISSION"), rs.getInt("RQ_TYPE"), rs.getInt("RQ_STATUS_ID")));
		}
		
		} catch (IOException | SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(re);
		return re;
		
	}
	
	
	public List <Reimbursement> getAllReimbursementsByPending(int rq_status_id){
		List <Reimbursement> re = new ArrayList<>();
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
		
			String sql = "SELECT * FROM reimbursement WHERE rq_Status_Id = 2";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			re.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MGR_U_ID"), rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getTimestamp("TIME_SUBMISSION"), rs.getInt("RQ_TYPE"), rs.getInt("RQ_STATUS_ID")));
		}
		
		} catch (IOException | SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(re);
		return re;
		
	}
	
	
	public List <Reimbursement> getAllReimbursementsByDenied(int rq_status_id){
		List <Reimbursement> re = new ArrayList<>();
		System.out.println("Connected");
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
		
			String sql = "SELECT * FROM reimbursement WHERE rq_Status_Id = 3";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		System.out.println("Retrieving Information");
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			re.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MGR_U_ID"), rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getTimestamp("TIME_SUBMISSION"), rs.getInt("RQ_TYPE"), rs.getInt("RQ_STATUS_ID")));
		}
		
		} catch (IOException | SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(re);
		return re;
		
	 }
	
	
	
	
	public List <Reimbursement> getAllReimbursementsByStatusAndId(int emp_U_Id){
		List <Reimbursement> re = new ArrayList<>();
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
			System.out.println("Connected");
		
		String sql = "SELECT * FROM reimbursement WHERE emp_U_Id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, emp_U_Id);
		System.out.println("Retrieving Information");
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			re.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MGR_U_ID"), rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getTimestamp("TIME_SUBMISSION"), rs.getInt("RQ_TYPE"), rs.getInt("RQ_STATUS_ID")));
		}
		
		} catch (IOException | SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(re);
		return re;
		
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------
	//UPDATE
	
	public int updateUserInfo(String email, String fName, String lName, int u_Id ) {
		int rowsAffected = 0;
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
			System.out.println("Connected");
		
	
		String sql = "{call update_profile(?,?,?,?)}";
		
		CallableStatement cs = conn.prepareCall(sql);
		System.out.println(email+  fName+ lName+ u_Id);
		cs.setString(1, email);
		cs.setString(2, fName);
		cs.setString(3, lName);
		cs.setInt(4, u_Id);
		
		rowsAffected = cs.executeUpdate();
		System.out.println("executing update");
		System.out.println(email+  fName+ lName+ u_Id);
		
		} catch (IOException | SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Account updated");
		System.out.println(rowsAffected);
		return rowsAffected;
		
	}
	
	



}


