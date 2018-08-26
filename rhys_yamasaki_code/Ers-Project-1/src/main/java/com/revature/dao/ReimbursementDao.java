package com.revature.dao;

import java.util.List;

import com.revature.pojo.Reimbursement;

public interface ReimbursementDao {
	
	// CREATE
	public void createNewReimbursement(int uId, double amt, String desc, byte[] img, int typeId);
	
	// READ
	public List<Reimbursement> getAllReimbursements();
	public List<Reimbursement> getReimbursementById(int id);
	public List<Reimbursement> getResolvedReimbursements();
	// UPDATE
	public void resolveReimbursement(int userId, int rId, int statusId);
	
	// DELETE
}
