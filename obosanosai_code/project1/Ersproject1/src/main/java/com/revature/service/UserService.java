package com.revature.service;


import java.util.List;
import com.revature.dao.UsersDao;
import com.revature.domain.Users;

public class UserService {
	
	private UsersDao usersDao = new UsersDao();
	
	/**
	 * validates users password, it checks if user exists in DB and if their passwords match
	 * 
	 */
	public Users login(String email, String password) {
		Users user = usersDao.getUserByEmail(email);
		if (user != null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;	
	}
	
	
	public Users getUserByEmail(String email) {
		return usersDao.getUserByEmail(email);
	}
	
	
	/**
	 * gets all the users from the Dao
	 */
	public List<Users> getAllUsers(){
		return usersDao.getAllUsers();
	}
	
	/**
	 * updates user and return updated user
	 * 
	 */
	public Users updateUser(Users user) {
		
		usersDao.updateUsers(user);
		
		Users updatedUser = usersDao.getUserByEmail(user.getEmail());
		
		return updatedUser;
	}

}
