package com.revature.dao;

import com.revature.pojo.Task;

public interface TodoDao {
	
	// CREATE
	/*
	 * here we create a new task
	 */
	public void createTask(Task task);
	
	// READ
	/*
	 * here we are getting a task by the Id
	 */
	public Task getTaskById(int id);
	
}
