package com.revature.dao;

import java.util.List;

import com.revature.domain.Task;
import com.revature.domain.User;

public interface UserDao {

	// Remember that DAO: DATA Access Object (only CRUD Methods!)
	
	//CREATE
	
	//READ
	public User getUserByUsername(String username);
	public List<Task> getAllTasks();
	public List<Task> getTasksByUserId(int id);

	
	//UpDATE
	
	//DELETE
}
