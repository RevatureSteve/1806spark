package com.revature.dao;

import java.util.List;

import com.revature.domain.Task;
import com.revature.domain.User;

public interface UserDao {
<<<<<<< HEAD
	// Remember that DAO: Data Access Object (only CRUD Methods!)
	
	// CREATE 
	
	// READ
		public User getUserByUsername(String username);
		public List<Task> getAllTasks();
		public List<Task> getTasksByUserId(int id);
	
	// UPDATE
	
	// DELETE
=======

	// Remember that DAO: Data Access Object (only CRUD Methods!)
	
	// CREATE

	// READ
	public User getUserByUsername(String username);
	public List<Task> getAllTasks();
	public List<Task> getTasksByUserId(int id);
	
 	// UPDATE
	
	// DELETE 
	
	
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
}
