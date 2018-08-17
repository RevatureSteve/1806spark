package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.pojo.User;

public class ManagerService {

	private UserDao userDao = new UserDaoImpl();
	
	
	public User getManagerByEmail(String email) {
		
		User user = userDao.getUserByEmail(email);
		
//		if(user != null) {
//		}
		
		return user; 
	}
}
