package com.revature.dao;

import java.util.List;

import com.revature.pojo.User;

public interface UserDao {

	// CREATE
	
	
	// READ
	
	public User getUserByEmail(String email);
	public List<User> getAllEmployees();
	
	// UPDATE
	
	public void updateEmployee(int uId, String pw, String fname, String lname);
	
	
	// DELETE
}
