package com.revature.dao;

import java.util.List;

import com.revature.domain.Task;
import com.revature.domain.User;

public interface UserDao {
	
	// READ
	List<Task> getTasksByUserId(int userId);
	User getUserByUsername(String username);
	List<Task> getAllTasks();

}
