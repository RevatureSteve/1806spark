package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Users;

public interface Dao {
	
	//CRUD Methods
	//Create
	
	//Read
	public Users getUserByEmail(String email);
	public List<Users> getAllUsers();
	
	//Update
	
	//Delete

}
