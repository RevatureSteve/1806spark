package com.revature.dao;

import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;

public interface MangDao {

	//CREATE
	
	//READ
	Users getMangInfo(String email, String password);
	List<Users> getEmployees();
	List<Reimbursement> getAllEmpReimb();
	
	//UPDATE
	void newEmployee(Users usr);
	
	//DELETE
}
