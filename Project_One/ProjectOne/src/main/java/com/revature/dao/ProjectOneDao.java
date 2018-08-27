package com.revature.dao;

import java.util.List;

import com.revature.pogo.Reimbursement;
import com.revature.pogo.Users;

public interface ProjectOneDao {
	
	// Create
	public int createReimbursement(int amt, int emp_U_Id, int rq_Type_Id, String description);
	
	// Read
	public Users getUserByEmail(String email);
	
	public List<Reimbursement> getAllPendingReimb();
	
	public List<Reimbursement> getAllApprovedReimb();
	
	public List<Reimbursement> getAllDeniedReimb();
	
	public List<Reimbursement> getAllReimbursements();
	// Update
	public int updateUser(String email, String password, String fname, String lname, int u_Id);
	// Delete

}
