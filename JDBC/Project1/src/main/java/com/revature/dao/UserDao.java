package com.revature.dao;

import java.util.List;


import com.revature.domain.Users;

public interface UserDao {
	
	//CRUD Methods
	//Create
	
	//Read
	public Users getUserByEmail(String email);
	public List<Users> getAllUsers();
	public List<Users> getAllEmployees();
	
	//Update
	
	//Delete

}
