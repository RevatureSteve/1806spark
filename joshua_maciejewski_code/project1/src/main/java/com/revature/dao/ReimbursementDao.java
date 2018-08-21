package com.revature.dao;

import java.util.List;

import com.revature.domain.Reimbursement;

public interface ReimbursementDao {
	
	//CREATE
	
	public void newReimbursement(Reimbursement reim);
	
	
	//READ
	
	public List<Reimbursement> viewAllPending();
	
	public List<Reimbursement> getReimbursementForSingle(int id);
	
	public List<Reimbursement> getResolvedRequests();
			
	public List<Reimbursement> getEmployeeViewPending(int id);
	
	public List<Reimbursement> getEmployeeViewResolved(int id);
	
	//UPDATE
	
	public void updateReimStatus (int rID, int mID, int status );
			
    //DELETE

}
