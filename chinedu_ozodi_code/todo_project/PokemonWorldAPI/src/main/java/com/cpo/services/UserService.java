package com.cpo.services;

import com.cpo.doa.UserDaoDatabase;
import com.cpo.model.User;

public class UserService {
	
	private static UserService instance;

	private UserService() {
		super();
	}

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	public void CreateUser(User user) {
		UserDaoDatabase.getInstance().createUser(user);
	}
	
	

}
