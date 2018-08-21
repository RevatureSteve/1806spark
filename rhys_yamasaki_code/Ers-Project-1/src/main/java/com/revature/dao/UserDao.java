package com.revature.dao;

import com.revature.pojo.User;

public interface UserDao {

	// CREATE
	
	
	// READ
	
	public User getUserByEmail(String email);
	
	// UPDATE
	
	public void updateEmployee(int uId, String pw, String fname, String lname);
	
	
	// DELETE
}
