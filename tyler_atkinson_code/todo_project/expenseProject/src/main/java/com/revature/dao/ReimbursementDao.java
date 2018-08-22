package com.revature.dao;

import java.util.List;

import com.revature.domain.Reimbursement;

public interface ReimbursementDao {
	
	//CREATE 
	
	
	//READ
	

	public List<Reimbursement> getReimbursementById(int r_id);
	public List<Reimbursement> getAllReimbursements();
	
	//UPDATE
	public boolean addReimbursement(int emp_u_id, int mgr_u_id,
			double amt, String description, int rq_type_id, int rq_status_id );     //add input data types
	
	
	//DELETE

}
