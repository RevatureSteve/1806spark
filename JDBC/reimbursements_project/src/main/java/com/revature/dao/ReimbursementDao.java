package com.revature.dao;

import java.util.List;

import com.revature.domain.Reimbursement;

public interface ReimbursementDao {
	public List<Reimbursement> getAllReimbursements();
	
	public List<Reimbursement> getAllPendingReimbursements();
	
	public List<Reimbursement> getReimbusementsByUser(int uid);
	
	public int addNewReimbursement(Reimbursement reim);
}