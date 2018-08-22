package com.revature.Dao;

import java.util.List;

import com.revature.Pojo.Reimbursement;
import com.revature.Pojo.Users;

public interface RickAndMortyDao {

	
	//Remember that DAO: Data Access Object (Only CRUD Methods)
	
	//Create
	
	
	
	
	//READ
	
	public Users getUserByEmail(String email);
	public Users getAllUsers();
	List <Reimbursement> getAllReimbursements();
	List <Reimbursement> getAllReimbursementsByStatus();
	List <Reimbursement> getAllReimbursementsByStatusAndId(int rq_status_id, int emp_u_id);
	
	//UPDATE
	
	
	
	
	//DELETE
}
