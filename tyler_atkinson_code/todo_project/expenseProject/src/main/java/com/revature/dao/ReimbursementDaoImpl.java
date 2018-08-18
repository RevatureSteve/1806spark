package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.Reimbursement;

public class ReimbursementDaoImpl implements ReimbursementDao {
	
	private final static String  USERNAME = "tyler_ers";
	private final static String  PASSWORD = "p4ssw0rd";
	private final static String  URL = "jdbc:oracle:thin:@tylertraining.cnmoc1mujdcw.us-east-2.rds.amazonaws.com:1521:ORCL"; 
			
	
	
	@Override
	public Reimbursement getReimbursementById(int r_id) {
		
		Reimbursement reimbursement = null;
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
			String sql = "SELECT * FROM reimbursement WHERE r_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r_id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				reimbursement = new Reimbursement(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),resultSet.getInt(8), 
						resultSet.getInt(9), resultSet.getDouble(4), resultSet.getString(5), resultSet.getString(7), resultSet.getString(6));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursement;
		
	}

}



