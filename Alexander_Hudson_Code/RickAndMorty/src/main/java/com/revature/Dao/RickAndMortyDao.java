package com.revature.Dao;

import java.sql.Timestamp;
import java.util.List;

import com.revature.Pojo.Reimbursement;
import com.revature.Pojo.Users;

public interface RickAndMortyDao {

	
	//Remember that DAO: Data Access Object (Only CRUD Methods)
	
	//Create-----------------------------------------------------------------------------------------------------
	
	public Reimbursement createReimbursement(int amt, String description, Timestamp time_Submission, int rq_Type);
	
	
	//READ-------------------------------------------------------------------------------------------------------
	
	public Users getUserByEmail(String email);
	public Users getAllUsers();
	List <Reimbursement> getAllReimbursements();
	List <Reimbursement> getAllReimbursementsByStatus();
	List <Reimbursement> getAllReimbursementsByStatusAndId(int rq_status_id, int emp_u_id);
	
	//UPDATE------------------------------------------------------------------------------------------------------
	
	public Users updateUserPassWord(String passWord);
	public Users updateUserFName(String fName);
	public Users updateUserLName(String lName);
	
	
	//DELETE------------------------------------------------------------------------------------------------------
}
