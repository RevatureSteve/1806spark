package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.util.SetConnectionPropertiesUtil;

public class ReimbursementDaoImpl implements ReimbursementDao{

	@Override
	public List<Reimbursement> getAllReimbursements() {
		
		List<Reimbursement> list = new ArrayList<>();
		
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "SELECT u.fname AS sub_name, uu.fname AS res_name, r.amount, r.description, r.time_submission, rq.rq_type, s.rq_status from reimbursement r\r\n" + 
					"INNER JOIN rq_type rq ON rq.rq_type_id = r.rq_type_id\r\n" + 
					"INNER JOIN users u ON u.u_id = r.r_submission_id\r\n" + 
					"INNER JOIN users uu ON uu.u_id = r.r_resolved_id\r\n" + 
					"INNER JOIN rq_status s ON r.rq_status_id = s.rq_status_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Reimbursement(rs.getInt("amount"), rs.getString("description"), 
						rs.getString("time_submission"), rs.getString("res_name"), rs.getString("sub_name"),
						rs.getString("rq_type"), rs.getString("rq_status")));
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
