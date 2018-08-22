package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.TranstarReims;
import com.revature.pojo.TranstarUsers;
import com.revature.util.ConnectionsPropertiesUtil;

public class TranstarDaoImpl implements TranstarReimDao{

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
					"ON reimbursement.rq_status_id = rq_status.rq_status_id";
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