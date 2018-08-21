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

import oracle.sql.TIMESTAMP;

public class ReimbursementDaoImpl implements ReimbursementDao{

	/*
	 * Here I am creating a new reimbursement
	 */
	public Reimbursement newReimbursement(int reimbId, int empUserId, double amount, String description, int requestTypeId) {
		System.err.println("[LOG]---Starting ReimbursementDao---NewReimbursements()");
		
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			System.err.println("[LOG]---ReimbursementDao try/catch---newReimbursements() connection successful");
			
			String sql = "INSERT INTO reimbursement (R_Id, Emp_U_Id, Amt, Descripton, Rq_Type_Id)\r\n" + 
					"VALUES(?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbId);
			ps.setInt(2, empUserId);
			ps.setDouble(3, amount);
			ps.setString(4, description);
			ps.setInt(5, requestTypeId);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	/*
	 * Here I will show all Reimbursements
	 */
	@Override
	public List<Reimbursement> getReimbursements() {
		System.err.println("[LOG]---Starting ReimbursementDao---getReimbursements()");
		
		List<Reimbursement> reimbs = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()) {
			System.err.println("[LOG]---ReimbursementDao try/catch---getReimbursements() connection successful");
			
			String sql = "SELECT * FROM Reimbursement\r\n" + 
					"INNER JOIN Rq_Status \r\n" + 
					"    ON Rq_Status.Rq_Status_Id = Reimbursement.Rq_Status_Id\r\n" + 
					"INNER JOIN Rq_Type\r\n" + 
					"    ON Rq_Type.Rq_Type_Id = Reimbursement.Rq_Status_Id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			System.err.println("[LOG]---ReimbursementDao ResultSet---getReimbursements()");
			while (rs.next()) {
				System.err.println("[LOG]---ReimbursementDao if---getReimbursements()");
				Reimbursement reimb = new Reimbursement(rs.getInt("R_Id"), rs.getInt("Emp_U_Id"), rs.getInt("Mgr_U_Id"), 
						rs.getDouble("Amt"), rs.getString("Description"), null, null, rs.getInt("Rq_Type_Id"), 
						rs.getString("Rq_Type"),rs.getInt("Rq_Status_Id"), rs.getString("Rq_Status"));
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
	 * Here I show all Pending Reimbursements
	 */
	@Override
	public List<Reimbursement> getPendingReimbursements() {
		System.err.println("[LOG]---Starting ReimbursementDao---getPendingReimbursements()");
		
		List<Reimbursement> pendingReimbs = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			System.err.println("[LOG]---ReimbursementDao try/catch---getPendingReimbursements() connection successful");
					
			String sql = "SELECT * FROM Reimbursement\r\n" + 
					"INNER JOIN Rq_Status \r\n" + 
					"    ON Rq_Status.Rq_Status_Id = Reimbursement.Rq_Status_Id\r\n" + 
					"INNER JOIN Rq_Type\r\n" + 
					"    ON Rq_Type.Rq_Type_Id = Reimbursement.Rq_Status_Id\r\n" + 
					"WHERE Reimbursement.Rq_Status_Id = 1";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			System.err.println("[LOG]---ReimbursementDao ResultSet---getPendingReimbursements()");
			while (rs.next()) {
				System.err.println("[LOG]---ReimbursementDao if---getPendingReimbursements()");
				Reimbursement pendingReimb = new Reimbursement(rs.getInt("R_Id"), rs.getInt("Emp_U_Id"), rs.getInt("Mgr_U_Id"), 
						rs.getDouble("Amt"), rs.getString("Description"), null, null, rs.getInt("Rq_Type_Id"), 
						rs.getString("Rq_Type"),rs.getInt("Rq_Status_Id"), rs.getString("Rq_Status"));
				pendingReimbs.add(pendingReimb);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.err.println("[LOG]---ReimbursementDao ResultSet if---getPendingReimbursements() returning the list of Pending Reimbursements");
		return pendingReimbs;
	}

	/*
	 * Here I show all Approved Reimbursements
	 */
	@Override
	public List<Reimbursement> getApprovedReimbursements() {
		System.err.println("[LOG]---Starting ReimbursementDao---getApprovedReimbursements()");
		
		List<Reimbursement> approvedReimbs = new ArrayList<>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection()){
			System.err.println("[LOG]---ReimbursementDao try/catch---getApprovedReimbursements() connection successful");
			String sql = "SELECT * FROM Reimbursement\r\n" + 
					"INNER JOIN Rq_Status \r\n" + 
					"    ON Rq_Status.Rq_Status_Id = Reimbursement.Rq_Status_Id\r\n" + 
					"INNER JOIN Rq_Type\r\n" + 
					"    ON Rq_Type.Rq_Type_Id = Reimbursement.Rq_Status_Id\r\n" + 
					"WHERE Reimbursement.Rq_Status_Id = 2";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.err.println("[LOG]---ReimbursementDao ResultSet---getApprovedReimbursements()");
			
			while (rs.next()) {
				System.err.println("[LOG]---ReimbursementDao if---getApprovedReimbursements()");
				Reimbursement approvedReimb = new Reimbursement(rs.getInt("R_Id"), rs.getInt("Emp_U_Id"), rs.getInt("Mgr_U_Id"), 
						rs.getDouble("Amt"), rs.getString("Description"), null, null, rs.getInt("Rq_Type_Id"), 
						rs.getString("Rq_Type"),rs.getInt("Rq_Status_Id"), rs.getString("Rq_Status"));
				approvedReimbs.add(approvedReimb);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.err.println("[LOG]---ReimbursementDao if---getApprovedReimbursements() returning the list of Approved Reimbursements");
		return approvedReimbs;
	}
	
}
