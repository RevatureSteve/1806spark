package com.revature.dao;

<<<<<<< HEAD
import com.revature.domain.User;

public interface UserDao {

	// Remember that DAO: Data Access Object (only CRUD Methods!)
	
	// CREATE

	// READ
	public User getUserByUsername(String username);
	// UPDATE
	
	// DELETE 
	
	
=======
import java.util.List;

import com.revature.domain.Task;
import com.revature.domain.User;

public interface UserDao {
	
	//	Remember that DAO: Data Access Object (only CRUD Methods)
	
	//	CREATE
	
	//	READ
	public User getUserByUsername(String username);
	public List<Task> getAllTasks();
	//	UPDATE
	
	//	DELETE

>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
}
