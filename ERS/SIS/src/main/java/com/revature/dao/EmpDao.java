package com.revature.dao;

import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;

public interface EmpDao {
	//CREATE
	int createNewReimbursement(double amount, String rDescription, int uId, String type );
	//READ
	Users login(String email, String password);
	List<Reimbursement> getEmpReimb(int empId);
	
	//UPDATE
	
	//DELETE

}
