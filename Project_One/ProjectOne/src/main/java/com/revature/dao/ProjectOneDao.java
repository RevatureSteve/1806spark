package com.revature.dao;

import java.util.List;

import com.revature.pogo.Reimbursement;
import com.revature.pogo.Users;

public interface ProjectOneDao {
	
	// Create
	public List<Reimbursement> createReimbursementbyEmail();
	
	// Read
	public Users getUserByEmail(String email);
	
	public List<Reimbursement> getAllPendingReimb();
	
	public List<Reimbursement> getAllApprovedReimb();
	
	public List<Reimbursement> getAllDeniedReimb();
	
	public List<Reimbursement> getAllReimbursements();
	// Update
	
	// Delete

}
