package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class AppService {
	
	private UserDao userDao = new UserDaoImpl();
	
	
	public User login ( User userInput) {
		
		userDao.getUserByUsername(userInput.getUsername());
		return null;
	}

}
