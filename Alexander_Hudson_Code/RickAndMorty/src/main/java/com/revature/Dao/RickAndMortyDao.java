package com.revature.Dao;

import java.util.List;

import com.revature.Pojo.Reimbursement;
import com.revature.Pojo.Users;

public interface RickAndMortyDao {

	
	//Remember that DAO: Data Access Object (Only CRUD Methods)
	
	//Create
	
	
	
	
	//READ
	
	public Users getUserByEmail(String email);
	List <Reimbursement> getAllReimbursements();
	List <Reimbursement> getAllReimbursementsByStatus();
	
	//UPDATE
	
	
	
	
	//DELETE
}
