package com.revature.dao;

import java.sql.Timestamp;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;

public interface EmpDao {
	//CREATE
	int createNewReimbursement(double amount, String rDescription, int uId, int type, int status );
	//READ
	Users login(String email, String password);
	List<Reimbursement> getEmpReimb(int empId);
	
	//UPDATE
	int updateFirstname(int uId, String firstname);
	int updateLastName(int uId ,String lasname);
	int updatePassword(int uId, String email);
	//DELETE

}
