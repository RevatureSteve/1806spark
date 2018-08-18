package com.revature.dao;

import java.util.List;

import com.revature.domain.Reimbursement;

public interface ReimbursementDao {
	
	//CREATE 
	
	
	//READ
	

	public Reimbursement getReimbursementById(int r_id);

	
	//UPDATE
	public List<Reimbursement> getAllReimbursements();
	
	
	//DELETE

}
