package com.revature.dao;

import java.util.List;

import com.revature.pogo.Reimbursement;
import com.revature.pogo.Users;

public interface ProjectOneDao {
	
	// Create
	
	// Read
	public Users getUserByEmail(String email);
	
	public List<Reimbursement> getAllReimbursements();
	// Update
	
	// Delete

}
