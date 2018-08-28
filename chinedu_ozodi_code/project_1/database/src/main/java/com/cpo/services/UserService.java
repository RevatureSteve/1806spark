package com.cpo.services;

import java.util.List;

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
	
	public void createUser(User user) {
		UserDaoDatabase.getInstance().createUser(user);
	}
	
	public List<User> getAllUsers() {
		return UserDaoDatabase.getInstance().getAllUsers();
	}
	
	public User getUserId(int id) {
		return UserDaoDatabase.getInstance().getUserById(id);
	}
	
	public User getUserByEmail(String email) {
		return UserDaoDatabase.getInstance().getUserByEmail(email);
	}
	
	public int updateUser(User user) {
		return UserDaoDatabase.getInstance().updateUser(user);
	}
	

}
