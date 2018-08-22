package com.revature.dao;

import java.util.List;

import com.revature.domain.User;

public interface UserDao {

	//DAO's only use CRUD methods
	
	//Create
	int create(Object obj);
	//Read
	public User getUserbyEmail(String email, String password);
	
	List<Object> read();
	//Update

	int update(Object obj);



	
	
	//Delete
	
}
