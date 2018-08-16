package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Task;
import com.revature.domain.User;
/**
 * Used for business logic
 * @author chin2
 *
 */
public class AppService {
	
	private UserDao userDao = new UserDaoImpl();
	
	
	public User login ( User userInput) {
		
		userDao.getUserByUsername(userInput.getUsername());
		return null;
	}
	
	public List<Task> getAllTasks(){
		System.out.println("[LOG]----retreiving---All tasks");
		//any validation before asking the db?
		
		return userDao.getAllTasks();
	}

	public List<Task> getTasksByUserId(int userId){
		return userDao.getTasksByUserId(userId);
	}
}
