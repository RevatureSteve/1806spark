package com.revature.dao;

import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;

public interface EmpDao {
	//CREATE
	
	//READ
	Users getEmpInfo(String email, String password);
	List<Reimbursement> getAllReimb(int empId);
	
	//UPDATE
	
	//DELETE

}
