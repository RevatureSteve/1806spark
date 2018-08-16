package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.domain.Users;
import com.revature.util.SetConnectionPropertiesUtil;

public class ReimbursementDao implements Dao{

	/*
	 * Here I will show all Reimbursements
	 */
	@Override
	public List<Reimbursement> getReimbursements() {
		System.err.println("[LOG]---Starting ReimbursementDao---getReimbursements()");
		
		List<Reimbursement> reimbs = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			System.err.println("[LOG]---ReimbursementDao try/catch---getReimbursements() connection successful");
			
			String sql = "SELECT * FROM reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			System.err.println("[LOG]---ReimbursementDao---getReimbursements()");
			if (rs.next()) {
				Reimbursement reimb = new Reimbursement(rs.getInt("R_Id"), rs.getInt("Emp_U_Id"), rs.getInt("Mgr_U_Id")
						, rs.getDouble("Amt"), rs.getString("Description"), null, null, rs.getInt("Rq_Type_Id"), rs.getInt("Rq_Status_Id"));
				reimbs.add(reimb);
			}	
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.err.println("[LOG]---ReimbursementDao ResultSet if---getReimbursements() returning the list of Reimbursements");
		return reimbs;
	}
	
	/*
	 * Unimplemented Methods so ignore
	 */
	@Override
	public Users getUserByEmail(String email) {
		return null;
	}

	@Override
	public List<Users> getAllUsers() {
		return null;
	}


	
}
