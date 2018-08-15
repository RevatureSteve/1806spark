package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;

public interface MangDao {

	//CREATE
	
	//READ
	Users getMangInfo(String email, String password);
	ArrayList<Users> getEmpInfo(Users usr);
	ArrayList<Reimbursement> getAllEmpReimb();
	
	//UPDATE
	void newEmployee(Users usr);
	
	//DELETE
}
