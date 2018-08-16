package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Task;
import com.revature.domain.User;

public class AppService {
	
	// instance scope so each non-static method in this class can use the same object
	private UserDao userDao = new UserDaoImpl();
	/*
	 *  business logic like login validation
	 *  	validate models before persisting
	 *  	manipulate models before persisting
	 *  	validate user before pulling sensitive data
	 *  	etc...
	 */
	
	public User login(User userInput) {

		/**
		 * login() returns a valid user object or returns null if the user/pw combo is invalid;
		 * 
		 */
		
		User dbUser = userDao.getUserByUsername(userInput.getUsername());
		
		
		if (dbUser != null) {
			if (userInput.getPassword().equals(dbUser.getPassword())) {
				return dbUser;
			}
		}
		
		return dbUser;
		
	}
	
	
	public List<Task> getTasksByUserId(int id) {
		System.out.println("[LOG]----retrieving--- All tasks");
		return userDao.getTasksByUserId(id);
	}
	
	
	
	public List<Task> getAllTasks() {
		System.out.println("[LOG]----retrieving---All tasks");
		// any validation before asking the db? maybe in future but not at the moment
		// so lets call the dao to get Tasks from the DB
		
		return userDao.getAllTasks();
	}
	
}
