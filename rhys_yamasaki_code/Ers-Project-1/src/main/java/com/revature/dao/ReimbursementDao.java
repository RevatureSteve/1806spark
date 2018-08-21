package com.revature.dao;

import java.util.List;

import com.revature.pojo.Reimbursement;

public interface ReimbursementDao {
	
	// CREATE
	public void createNewReimbursement(int uId, double amt, String desc, byte[] img, int typeId);
	
	// READ
	public List<Reimbursement> getAllReimbursements();
	
	// UPDATE
	
	
	// DELETE
}
