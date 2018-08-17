package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.pojo.User;

public class ManagerService {

	private UserDao userDao = new UserDaoImpl();
	
	
	public User validateManagerLogin(String email, String password) {
		
		User user = userDao.getUserByEmail(email);
		if(userDao.getUserByEmail(email) != null) {
			if (user.getPassword().equals(password)) {
				return user; 
			}
		} 
		return null;
	}
}
