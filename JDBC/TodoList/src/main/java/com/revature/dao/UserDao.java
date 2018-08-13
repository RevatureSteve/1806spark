package com.revature.dao;

import com.revature.domain.User;

public interface UserDao {
	// Remember that DAO: Data Access Object (only CRUD Methods!)
	
	// CREATE 
	
	// READ
		public User getUserByUsername(String username);
	
	// UPDATE
	
	// DELETE
}
