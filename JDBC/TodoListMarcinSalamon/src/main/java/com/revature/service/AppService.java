package com.revature.service;

import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class AppService {
/*
 * business logic like login validation
 * validate models before persisting
 * manipulate models before persisting
 * validate user before pulling sensitive data
 * etc...
 */
	
	public User login(User userInput) {
		User user = new UserDaoImpl().getUserByUsername(userInput.getUsername());
		return user;
	}
}
