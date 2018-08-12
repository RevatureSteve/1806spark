package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.util.SetConnectionPropertiesUtil;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

public class ReimbursementDao {
	
	//Create
	
	
	
	//Read
	public List<Reimbursement> getReimbursementByEmployeeId(int id){
		List<Reimbursement> reimbursements = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();){
			
			
			String sql = "{call get_reimbursements_by_emp_id(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement(rs.getInt(1), rs.getInt("emp_u_id"), rs.getInt("mgr_u_id"),
						rs.getDouble("amt"), rs.getString("description"), rs.getBlob("img"),
						rs.getDate("time_submission"), rs.getString("rb_type"), rs.getString("rb_status"));
				reimbursements.add(reimbursement);
			}
			
			
			
			
			
			
//			String sql = "SELECT * FROM reimbursement WHERE emp_u_id = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				Reimbursement reimbursement = new Reimbursement(rs.getInt(1), rs.getInt("emp_u_id"), rs.getInt("mgr_u_id"),
//						rs.getDouble("amt"), rs.getString("description"), rs.getBlob("img"),
//						rs.getDate("time_submission"), rs.getString("rb_type_id"), rs.getString("rb_status_id"));
//				reimbursements.add(reimbursement);
//			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	
	//Update
	
	
	
	//Delete

}
