package com.revature.dao;

import com.revature.domain.User;

public interface UserDao {
	
	//remember that DAO: DATA ACCESS OBJECT (only CRUD methods)
	
	//CREATE
	
	//READ
	public User getUserByUsername(String username);
	
	//UPDATE
	
	//DELETE
}
