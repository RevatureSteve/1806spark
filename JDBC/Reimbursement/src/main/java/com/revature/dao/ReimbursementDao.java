package com.revature.dao;

import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public interface ReimbursementDao {

	//Create
	public int createUser(User person);
	public int createReimbursementRequest(Reimbursement request);
		
	//Read
	public List<User> getAllUser();
	public User getUsersById(int userId);
	public User getUserByEmail(String email);
	public List<Reimbursement> getAllReimbursement();
	public Reimbursement getStatusById(int statusId);
		
	//Update
	public int password(String password, User person);
	public int updateName(String fName, User person, String lName);
	public int updateStatus(Reimbursement request);
	public int updateUser(User user);
		
	//Delete
}
