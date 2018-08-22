package com.revature.dao;

import java.util.List;

import com.revature.domain.Task;
import com.revature.domain.User;

public interface UserDao {
	
	
	//Remember that DAO: Data Access Object (Only CRUD Methods)
	
	//Create
	
	//Read
	public User getUserByUsername(String username);
	public List<Task> getAllTasks();
	public List<Task> getTasksByUserId(int Id);
	//Update
	
	//Delete
	
	
	
	
	
	

}
