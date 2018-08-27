package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	public Reimbursement createReimbursement(Reimbursement r);
	
	public Reimbursement getReimbursementById(int id);

	public ArrayList<Reimbursement> getAllReimbursements();
	
	public ArrayList<Reimbursement> getReimbursementsForUserId(int userID);
	
	public Reimbursement updateReimbursement(Reimbursement r);
}
