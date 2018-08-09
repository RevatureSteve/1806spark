package com.registrar.service;

import com.registrar.dao.TuitionDao;
import com.registrar.dao.TuitionDaoImpl;
import com.registrar.pojo.User;

public class LoginService {
	
	private TuitionDao tuitionDao = new TuitionDaoImpl();
		
	public User login(User userInput) {
		User dbUser = tuitionDao.getUserByUsername(userInput.getUsername());
		
		if (dbUser != null) {
			if ( dbUser.getPassword().equals(userInput.getPassword()) ) {
				return dbUser;
			}
		}
		return null;
	}

}
