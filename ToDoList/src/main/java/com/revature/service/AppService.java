package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Task;
import com.revature.domain.User;

public class AppService {

	/*   Inside here would be business logic, like login validation
			*validate models before  persisting
			*manipulate models before persisting
			*validate user before persisting
				etc..
	*/
	
	private UserDao userDao = new UserDaoImpl();
	
	public User login(User userInput) {
		
		//return a valid user object 
		User dbUser = userDao.getUserByUsername(userInput.getUsername());
		
		if (dbUser != null) {
			if(dbUser.getPassword().equals(userInput.getPassword())) {
				return dbUser;
			}
		}
		
		return null;
	}
	
	
	
	public List<Task> getAllTasks(){
		//Any validation before asking the db? maybe in the future but not at momment
		// so let's call dao to get Tasks from the DB
		
		
		return userDao.getAllTasks();
	}
	
	
	
	public List<Task> getTasksByUserId(int id){
		return userDao.getTasksByUserId(id);
	}
	
	
	
	
	
}
