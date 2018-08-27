package com.revature.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.TranstarReims;
import com.revature.pojo.TranstarUsers;
import com.revature.util.ConnectionsPropertiesUtil;

public class TranstarReimDaoImpl implements TranstarReimDao{
	
	//CREATE
	@Override
	public int submitReimbursment(int emp_id, int amount, String desc, int rq_type) {
		int rowsAffected = 0;
		try (Connection con = ConnectionsPropertiesUtil.newConnection()){
			String sql = "{call new_reimbursement(?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, emp_id);
			cs.setInt(2, amount);
			cs.setString(3, desc);
			cs.setInt(4, rq_type);
			rowsAffected = cs.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL fail");
			e.printStackTrace();
		}
		return rowsAffected;
	}
	public int updateReimbursment(int reqNum, int reqStatus, int mgrId) {
		int rowsAffected = 0;
		try (Connection con = ConnectionsPropertiesUtil.newConnection()){
			String sql = "{call resolved(?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, reqNum);
			cs.setInt(2, reqStatus);
			cs.setInt(3, mgrId);
			rowsAffected = cs.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL fail");
			e.printStackTrace();
		}
		return rowsAffected;
	}

	//READ
	/**
	 * Pull all requests from a specific user.  
	 * @param userId
	 * @return req
	 */
	public TranstarReims getUserRequests(int userId) {
		TranstarReims req = null;
		try (Connection con = ConnectionsPropertiesUtil.newConnection()){
			String sql = "SELECT * FROM reimbursement INNER JOIN rb_type " + 
					"ON reimbursement.rb_type_id = rb_type.rb_type_id INNER JOIN rq_status " + 
					"ON reimbursement.rq_status_id = rq_status.rq_status_id " + 
					"WHERE emp_u_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				req = new TranstarReims(rs.getInt(1), rs.getInt(2), rs.getInt(3)
						, rs.getInt(4), rs.getString("description"), rs.getBlob("img")
						,rs.getString("time_submission"), rs.getString("rb_type")
						, rs.getString("rq_status"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL fail");
			e.printStackTrace();
		}
		return req;
	}
	/**
	 * Retrieves all pending requests from the database.
	 * @return req
	 */
	public List<TranstarReims> getAllPendingRequests() {
		
		List<TranstarReims> reqs = new ArrayList<>();
		try (Connection con = ConnectionsPropertiesUtil.newConnection()){
			String sql = "SELECT * FROM reimbursement INNER JOIN rb_type " + 
					"ON reimbursement.rb_type_id = rb_type.rb_type_id " + 
					"INNER JOIN rq_status " + 
					"ON reimbursement.rq_status_id = rq_status.rq_status_id WHERE rq_status.rq_status_id = 1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TranstarReims req = new TranstarReims(rs.getInt(1), rs.getInt(2), rs.getInt(3)
						, rs.getInt(4), rs.getString("description"), rs.getBlob("img")
						,rs.getString("time_submission"), rs.getString("rb_type")
						, rs.getString("rq_status"));
				reqs.add(req);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL fail");
			e.printStackTrace();
		}
		return reqs;
		
	}
	public List<TranstarReims> getResolvedRequests(int userId) {
		
		List<TranstarReims> reqs = new ArrayList<>();
		try (Connection con = ConnectionsPropertiesUtil.newConnection()){
			String sql = "SELECT * FROM reimbursement INNER JOIN rb_type " + 
					"ON reimbursement.rb_type_id = rb_type.rb_type_id " + 
					"INNER JOIN rq_status " + 
					"ON reimbursement.rq_status_id = rq_status.rq_status_id WHERE reimbursement.emp_u_id = ? AND rq_status.rq_status_id = 2 OR reimbursement.emp_u_id = ? AND rq_status.rq_status_id = 3";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TranstarReims req = new TranstarReims(rs.getInt(1), rs.getInt(2), rs.getInt(3)
						, rs.getInt(4), rs.getString("description"), rs.getBlob("img")
						,rs.getString("time_submission"), rs.getString("rb_type")
						, rs.getString("rq_status"));
				reqs.add(req);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL fail");
			e.printStackTrace();
		}
		return reqs;
		
	}
	/**
	 * Retrieves all pending requests from the database specific to a userId .
	 * @param reqId
	 * @param userId
	 * @return req
	 */
	public List<TranstarReims> getRequests(int reqId, int userId) {
		
		List<TranstarReims> reqs = new ArrayList<>();
		try (Connection con = ConnectionsPropertiesUtil.newConnection()){
			String sql = "SELECT * FROM reimbursement " + 
					"INNER JOIN rb_type " + 
					"ON reimbursement.rb_type_id = rb_type.rb_type_id " + 
					"INNER JOIN rq_status " + 
					"ON reimbursement.rq_status_id = rq_status.rq_status_id " + 
					"WHERE rq_status.rq_status_id = ? AND reimbursement.emp_u_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, reqId);
			ps.setInt(2, userId);
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				TranstarReims req = new TranstarReims(rs.getInt(1), rs.getInt(2), rs.getInt(3)
						, rs.getInt(4), rs.getString("description"), rs.getBlob("img")
						,rs.getString("time_submission"), rs.getString("rb_type")
						, rs.getString("rq_status"));
				reqs.add(req);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL fail");
			e.printStackTrace();
		}
		return reqs;
		
	}
	

public List<TranstarReims> getAllRequests() {
		
		List<TranstarReims> reqs = new ArrayList<>();
		try (Connection con = ConnectionsPropertiesUtil.newConnection()){
			String sql = "	SELECT * FROM reimbursement " + 
					"INNER JOIN rb_type " + 
					"ON reimbursement.rb_type_id = rb_type.rb_type_id " + 
					"INNER JOIN rq_status " + 
					"ON reimbursement.rq_status_id = rq_status.rq_status_id " + 
					"WHERE reimbursement.rq_status_id = 2 OR reimbursement.rq_status_id = 3";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TranstarReims req = new TranstarReims(rs.getInt(1), rs.getInt(2), rs.getInt(3)
						, rs.getInt(4), rs.getString("description"), rs.getBlob("img")
						,rs.getString("time_submission"), rs.getString("rb_type")
						, rs.getString("rq_status"));
				reqs.add(req);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL fail");
			e.printStackTrace();
		}
		return reqs;
		
	}
	
	
}
