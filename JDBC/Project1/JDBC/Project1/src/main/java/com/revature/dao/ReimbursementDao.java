package com.revature.dao;

import java.util.List;

import com.revature.domain.Reimbursement;

public interface ReimbursementDao {

	//CRUD Methods
	//Create
	public int newReimbursement(Reimbursement reimb);
	
	//Read
	public List<Reimbursement> getReimbursements();
	public List<Reimbursement> getPendingReimbursements();
	public List<Reimbursement> getApprovedReimbursements();
	
	//Update
	
	//Delete
}
