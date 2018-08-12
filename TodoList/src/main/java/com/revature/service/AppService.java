package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class AppService {
	
	//Business Logic etc etc
	
	
	private UserDao userDao = new UserDaoImpl();
	
//	login () returns a valid user object or returns a null if the user/pw combo is invalid
	
	public User login(User userInput) {
//		First pass the userInput's username to the dao to see if there is a
//		record found in the db with that username
//		if yes, assigns the user record to a User java object
//		No- then it is null
		
		
		
		//return a valid user object or return null
		
		 User dbUser = userDao.getUserByUsername(userInput.getUsername());
		 
		 
		 // since the username might not be found I could get null back..check for that
		 
		 if(dbUser != null) {
			 //compare user Input's password to the dbUser's password
			 if(dbUser.getPassword().equals(userInput.getPassword()));{
				 return dbUser;
			 }
			 
		 }
		
		return null;
}
}