package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.domain.Users;

import oracle.jdbc.OracleTypes;





public class ReimbursementDaoImpl implements ReimbursementDao {
	
	private final static String USERNAME = "project1_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com:1521:ORCL";

	
	//all pending requests
	@Override
	public List<Reimbursement> viewAllPending() {
		List<Reimbursement> reims = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call view_all_pending(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1,  OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()) {
				Reimbursement reim = new Reimbursement(rs.getInt(1), rs.getDouble(4), rs.getString(5), rs.getBlob(6), rs.getDate(7));
		reims.add(reim);
				
			}

		} catch(SQLException e) {
				e.printStackTrace();
		}
		System.out.println(reims);
		return reims;
		
	}

	
//resolved requests
	
	public List<Reimbursement> getResolvedRequests() {
		List<Reimbursement> reims = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
		String sql = "SELECT * FROM reimbursement r, rq_type t, rq_status s, users u\r\n" + 
				"    Where r.rq_type_id = t.rq_type_id AND\r\n" + 
				"        r.rq_status_id = s.rq_status_id AND \r\n" + 
				"        r.emp_u_id = u.u_id AND\r\n" + 
				"        r.rq_status_id != 1";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Reimbursement reim = new Reimbursement(rs.getInt(1), rs.getDouble(4), rs.getString(5), rs.getBlob(6), rs.getDate(7));
			reims.add(reim);
		}
	
	} catch(SQLException e) {
			e.printStackTrace();
	}
	System.out.println(reims);
		
		return reims;
		
	}
	
//single employee requests

	public List<Reimbursement> getReimbursementForSingle(int id) {
		List<Reimbursement> reims = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
		String sql = "SELECT * FROM reimbursement r, rq_type t, rq_status s, users u\r\n" + 
				"    Where r.rq_type_id = t.rq_type_id AND\r\n" + 
				"        r.rq_status_id = s.rq_status_id AND \r\n" + 
				"        r.emp_u_id = u.u_id AND\r\n" + 
				"        r.emp_u_id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Reimbursement reim = new Reimbursement(rs.getInt(1), rs.getDouble(4), rs.getString(5), rs.getBlob(6), rs.getDate(7));
			reims.add(reim);
		}
	
	} catch(SQLException e) {
			e.printStackTrace();
	}
	System.out.println(reims);
		
		return reims;
		
	}
	
	//employee view pending requests
	

	public List<Reimbursement> getEmployeeViewPending(int id) {
		List<Reimbursement> reims = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
		String sql = "SELECT * FROM reimbursement r, rq_type t, rq_status s, users u\r\n" + 
				"    Where r.rq_type_id = t.rq_type_id AND\r\n" + 
				"        r.rq_status_id = s.rq_status_id AND \r\n" + 
				"        r.emp_u_id = u.u_id AND\r\n" + 
				"        r.emp_u_id = ? AND r.rq_status_id =1";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Reimbursement reim = new Reimbursement(rs.getInt(1), rs.getDouble(4), rs.getString(5), rs.getBlob(6), rs.getDate(7));
			reims.add(reim);
		}
	
	} catch(SQLException e) {
			e.printStackTrace();
	}
	System.out.println(reims);
		
		return reims;
		
	}
	
	
	//employee view resolved reimbursment requests
	
	public List<Reimbursement> getEmployeeViewResolved(int id) {
		List<Reimbursement> reims = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
		String sql = "SELECT * FROM reimbursement r, rq_type t, rq_status s, users u\r\n" + 
				"    Where r.rq_type_id = t.rq_type_id AND\r\n" + 
				"        r.rq_status_id = s.rq_status_id AND \r\n" + 
				"        r.emp_u_id = u.u_id AND\r\n" + 
				"        r.rq_status_id != 1 AND r.emp_u_id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
			
		while(rs.next()) {
			Reimbursement reim = new Reimbursement(rs.getInt(1), rs.getDouble(4), rs.getString(5), rs.getBlob(6), rs.getDate(7));
			reims.add(reim);
		}
	
	} catch(SQLException e) {
			e.printStackTrace();
	}
	System.out.println(reims);
		
		return reims;
		
	}
	
	
	//approve/deny requests
	public void updateReimStatus (int rID, int mID, int status ) {
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql ="UPDATE reimbursement SET mgr_u_id = ? AND rq_status = ? WHERE r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  mID);
			ps.setInt(2, status);
			ps.setInt(3, rID);
			ps.executeQuery();
			
		} catch(SQLException e) {
				e.printStackTrace();
		}
		
		
	}
	
	
	public void newReimbursement(Reimbursement reim) {
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql ="{Call new_reim(?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, reim.getEmpUId());
			cs.setDouble(2, reim.getAmt());
			cs.setString(3, reim.getDescription());
			cs.setBlob(4, reim.getImg() );
			cs.setInt(5, reim.getRqTypeId());
			cs.executeQuery();
			
		} catch(SQLException e) {
				e.printStackTrace();
		}
	}
	
}







