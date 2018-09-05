package com.drake.service;

import java.util.List;

import com.drake.dao.UserDao;
import com.drake.domain.User;

public class UserService {

	private UserDao userDao = new UserDao();
	
	/**
	 * Checks to see if user exists and if passwords match
	 * @param email
	 * @param password
	 * @return user if user exists, null otherwise
	 */
	public User login(String email, String password) {
		User user = userDao.getUserByEmail(email);
		if (user != null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;	
	}
	
	
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
	
	
	/**
	 * gets all the users from the Dao
	 * @return
	 */
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	/**
	 * update user and return updated user
	 * @param user
	 * @return
	 */
	public User updateUser(User user) {
		
		System.out.println("update user logic");
		
		userDao.updateUsers(user);
		
		System.out.println("After update dao");
		
		User updatedUser = userDao.getUserByEmail(user.getEmail());
		
		System.out.println("After retrieve updated info");
		
		return updatedUser;
	}
	
	/**
	 * create a new user
	 * @param user
	 */
	public void createNewUser(User user) {
		userDao.createUser(user);
	}

}