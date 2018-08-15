package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;

public interface EmpDao {
	//CREATE
	
	//READ
	Users getEmpInfo(String email, String password);
	ArrayList<Reimbursement> getAllReimb(int emp_id);
	
	//UPDATE
	
	//DELETE

}
