package com.revature.service;

import java.util.ArrayList;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Task;
import com.revature.domain.User;

public class AppService {
/*
 * business logic like login validation
 * validate models before persisting
 * manipulate models before persisting
 * validate user before pulling sensitive data
 * etc...
 */
	private UserDao userDao = new UserDaoImpl();
	public User login(User userInput) {
		User user = userDao.getUserByUsername(userInput.getUsername());
		return user;
	}
	
	public ArrayList<Task> getAllTasks(){
		System.out.println("[LOG]----retrieving----All tasks");
		
		return (ArrayList<Task>) userDao.getAllTasks();
	}

	public ArrayList<Task> getTasksByUserId(int id) {
		System.out.println("[LOG]----retrieving---- tasks by user id");
		
		
		return userDao.getTasksById(id);
	}
}
