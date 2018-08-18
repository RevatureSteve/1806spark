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
			String sql = "SELECT * FROM reimbursement";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
