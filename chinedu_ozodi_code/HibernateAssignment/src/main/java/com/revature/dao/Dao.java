package com.revature.dao;

import com.revature.domain.Task;
import com.revature.domain.User;

public interface Dao {

	//Create
	public void createTask (Task t); 
	public void createUser (User user); 
	
	//Read
	public Task getTaskById (int id);
	
	//Update
	
	//Delete

}
