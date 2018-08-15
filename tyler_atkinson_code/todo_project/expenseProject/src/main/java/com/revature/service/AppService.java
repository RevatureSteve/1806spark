package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class AppService {
	
	private UserDao userDao = new UserDaoImpl();
	
	//login method return valid user object or return a null
	
	public User login(User userInput) {
		
		User dbUser = userDao.getUserByUsername(userInput.getUsername());
		
		if(dbUser != null) {
			if(dbUser.getPassword().equals(userInput.getPassword()));{
				return dbUser;
			}
		}
	
		return null;
		
	}
	

}
