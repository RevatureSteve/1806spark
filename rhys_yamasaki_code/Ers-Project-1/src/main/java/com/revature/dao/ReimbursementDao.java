package com.revature.dao;

import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.Type;

public interface ReimbursementDao {
	
	// CREATE
	public void createNewReimbursement(int uId, double amt, String desc, byte[] img, int typeId);
	
	// READ
	public List<Reimbursement> getAllReimbursements();
	public List<Reimbursement> getReimbursementById(int id);
	public List<Reimbursement> getResolvedReimbursements();
	public List<Reimbursement> getPendingReimbursements(int id);
	public List<Reimbursement> getEmployeeResolvedReimbursements(int id);
	public List<Type> getStatus();
	// UPDATE
	public void resolveReimbursement(int userId, int rId, int statusId);
	
	// DELETE
}
