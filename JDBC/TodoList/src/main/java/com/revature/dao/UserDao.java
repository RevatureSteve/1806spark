package com.revature.dao;

import java.util.List;

import com.revature.domain.Task;
import com.revature.domain.User;

public interface UserDao {
	
	//remember that DAO: DATA ACCESS OBJECT (only CRUD methods)
	
	//CREATE
	
	//READ
	public User getUserByUsername(String username);
	public List<Task> getAllTasks();
	public List<Task> getTasksByUserId(int id);
	//UPDATE
	
	//DELETE
}
