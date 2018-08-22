package com.revature.dao;

<<<<<<< HEAD:JDBC/TodoList/src/main/java/com/revature/dao/UserDao.java
<<<<<<< HEAD
=======
import java.util.List;

import com.revature.domain.Task;
>>>>>>> f963ce3a5c8899ea111b471162fbbacadb3bb589:project examples/todo_projects/TodoList-Restful-API/src/main/java/com/revature/dao/UserDao.java
import com.revature.domain.User;

public interface UserDao {

	// Remember that DAO: Data Access Object (only CRUD Methods!)
	
	// CREATE

	// READ
	public User getUserByUsername(String username);
	public List<Task> getAllTasks();
	public List<Task> getTasksByUserId(int id);
	
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
