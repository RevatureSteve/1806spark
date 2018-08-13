package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class AppService {
	
	
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
}
