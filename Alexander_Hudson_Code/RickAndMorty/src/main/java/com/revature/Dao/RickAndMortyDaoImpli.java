package com.revature.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ConnectionUtil.SetConnectionUtil;
import com.revature.Pojo.Reimbursement;
import com.revature.Pojo.Users;

public class RickAndMortyDaoImpli {
	
	
	private final static String USERNAME = "";
	private final static String PASSWORD = "";
	private final static String URL = "";
	
	
	
	//-----------------------------------------------------------------------------------------
	//READ
	
	public Users getUserByEmail(String email) {
		Users us = null;
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
			System.out.println("Connected");
			
			String sql = "SELECT FROM users WHERE email = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			System.out.println(us);
			
			while (rs.next()) {
				us = new Users (rs.getInt("U_ID"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getInt("POS_ID"));
				
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return us;
	}
	
	
	public Users getAllUsers() {
		Users us = null;
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
			System.out.println("Connected");
			
			String sql = "SELECT * FROM users";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(us);
			
			while (rs.next()) {
				us = new Users (rs.getInt("U_ID"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getInt("POS_ID"));
				
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return us;
	}
	
	
	List <Reimbursement> getAllReimbursements(){
		List <Reimbursement> re = new ArrayList<>();
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
		
		String sql = "SELECT * FROM Reimbursement";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			re.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MGR_U_ID"), rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getTimestamp("TIME_SUBMISSION"), rs.getInt("RQ_TYPE"), rs.getInt("RQ_STATUS_ID")));
		}
		
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return re;
		
	}
	
	List <Reimbursement> getAllReimbursementsByStatus(int rq_status_id){
		List <Reimbursement> re = new ArrayList<>();
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
		
		String sql = "SELECT * FROM Reimbursement WHERE rq_status_id =?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, rq_status_id);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			re.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MGR_U_ID"), rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getTimestamp("TIME_SUBMISSION"), rs.getInt("RQ_TYPE"), rs.getInt("RQ_STATUS_ID")));
		}
		
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return re;
		
	}
	
	
	List <Reimbursement> getAllReimbursementsByStatusAndId(int rq_status_id, int emp_u_id){
		List <Reimbursement> re = new ArrayList<>();
		
		try (Connection conn = SetConnectionUtil.getConnection()) {
		
		String sql = "SELECT * FROM Reimbursement WHERE rq_status_id =? AND emp_u_id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, rq_status_id);
		ps.setInt(2, emp_u_id);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			re.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MGR_U_ID"), rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getTimestamp("TIME_SUBMISSION"), rs.getInt("RQ_TYPE"), rs.getInt("RQ_STATUS_ID")));
		}
		
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return re;
		
	}
}


