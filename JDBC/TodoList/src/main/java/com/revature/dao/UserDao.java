package com.revature.dao;

import com.revature.domain.User;

public interface UserDao {

	//Remeber that Dao: Data Access Object (Only CRUD Methods!)
	
	//Create
	
	//READ
	public User getUserByUsername(String username);
	//UPDATE
	
	//DELETE
}
