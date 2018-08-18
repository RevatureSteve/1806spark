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

import com.revature.domain.Reimbursement;
import com.revature.util.SetConnectionPropertiesUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {
	

	
	
	@Override
	public Reimbursement getReimbursementById(int r_id) {
		
		Reimbursement reimbursement = null;
		
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM reimbursement WHERE r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r_id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				reimbursement = new Reimbursement(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),resultSet.getInt(8), 
						resultSet.getInt(9), resultSet.getDouble(4), resultSet.getString(5), resultSet.getString(7), resultSet.getString(6));
			}
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursement;
		
	}



	@Override
	public List<Reimbursement> getAllReimbursements() {
		
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try(Connection conn = SetConnectionPropertiesUtil.getConnection();){
			String sql = "SELECT * FROM reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("R_ID"), rs.getInt("EMP_U_ID"), rs.getInt("MGR_U_ID"), rs.getInt("RQ_TYPE_ID"),
						rs.getInt("RQ_STATUS_ID"), rs.getInt("AMT"), rs.getString("DESCRIPTION"), rs.getString("TIMESUBMISSION"),rs.getString("IMG")));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimbursements;
	}

}



