package com.revature.dao;

import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;

public interface MangDao {

	//CREATE
	void newEmployee(Users usr);
	//READ
	Users getMangInfo(String email, String password);
	List<Users> getEmployees();
	List<Reimbursement> getAllReimb();
	
	//UPDATE
	int updateReimbursements(int rId, int rStatusId);
	
	//DELETE
}
