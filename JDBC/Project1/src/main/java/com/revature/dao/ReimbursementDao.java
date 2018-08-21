package com.revature.dao;

import java.util.List;

import com.revature.domain.Reimbursement;

public interface ReimbursementDao {

	//CRUD Methods
	//Create
	public Reimbursement newReimbursement(int reimbId, int empUserId, double amount, String description, String TimeSubmit, int requestTypeId, int requestStatusId);
	
	//Read
	public List<Reimbursement> getReimbursements();
	public List<Reimbursement> getPendingReimbursements();
	public List<Reimbursement> getApprovedReimbursements();
	
	//Update
	
	//Delete
}
