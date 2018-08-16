package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Task;
import com.revature.domain.User;

public interface UserDao {

	User getUserByUsername(String username);
	
	public List<Task> getAllTasks();

	ArrayList<Task> getTasksById(int id);

}
