package com.revature.dao;

import java.util.List;

import com.revature.domain.Reimbursement;

public interface ReimbursementDao {
	public List<Reimbursement> getAllReimbursements();
	
	public List<Reimbursement> getAllPendingReimbursements();
	
	public List<Reimbursement> getReimbusementsByUser(int uid);
	
	public int addNewReimbursement(Reimbursement reim);

	public List<Reimbursement> getPendingReimbusementsByUser(int id);

	public List<Reimbursement> getResolvedReimbusementsByUser(int id);
	
	public int submitReimbursement(int id, double amount, String description, byte[] imgStr, int rqTypeId);

	public int updateReimbursements(int rId, int rqStatus, int mgrId);
}