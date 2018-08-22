package com.revature.service;

<<<<<<< HEAD:JDBC/TodoList/src/main/java/com/revature/service/AppService.java
<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> f963ce3a5c8899ea111b471162fbbacadb3bb589:project examples/todo_projects/TodoList-Restful-API/src/main/java/com/revature/service/AppService.java
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Task;
import com.revature.domain.User;

public class AppService {

	/*
	 *  business logic like login validation
	 *  	validate models before persisting
	 *  	manipulate models before persisting
	 *  	validate user before pulling sensitive data
	 *  	etc...
	 */
	
	// instance scope so each non-static method in this class can use the same object
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * login() returns a valid user object or returns null if the user/pw combo is invalid;
=======
import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Task;
import com.revature.domain.User;

public class AppService {
	
	/*
	 * 	business logic like login validation
	 * 		validates models before persisting
	 * 		manipulate models before persisting
	 * 		validate user before pulling sensitive data
	 * 		etc...
	 */

	//instance scope so each non-static method in this class can use the same object
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * login() returns a valid user object or returns null if the user/pw combo is invalid
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	 * @param userInput
	 * @return
	 */
	public User login(User userInput) {
<<<<<<< HEAD
		System.out.println("[LOG]----Starting---Service login() argument: " + userInput);
		// First pass the userInput's username to the dao to see if there is a 
		//		is a record found in the database with that username
		//		Yes - assign the user record to a User java object
		//		No - then it is null
		System.out.println("[LOG]----calling dao---Service login()");
		User dbUser =userDao.getUserByUsername(userInput.getUsername());
		System.out.println("[LOG]----dao returned---Service login() returned: " + dbUser);
		
		// since the username might not be found I could get null back...check for that!
		if(dbUser != null) {
			System.out.println("[LOG]----dbUser null check---Service login() status: successful");
			// now let's compare the userInput's password to the dbUser's password
			if(dbUser.getPassword().equals(userInput.getPassword())) {
				System.out.println("[LOG]----compare pw---Service login() pw: success");
				return dbUser; // not userInput since it doesn't have the userId
			}
		}
		System.out.println("[LOG]----ending---Service login() pw: fail");
		return null;
	}
	
<<<<<<< HEAD:JDBC/TodoList/src/main/java/com/revature/service/AppService.java
=======
		System.out.println("[LOG]---Starting----Service login() argument: " + userInput);
		//	1st pass the userInput's username to the dao to see if there is a record found in the database with that username
		//	if yes, assign the user record to a User java object
		//	if no, then it is null
		System.out.println("[LOG]---Calling DAO----Service login()");
		User dbUser = userDao.getUserByUsername(userInput.getUsername());
		System.out.println("[LOG]---DAO returned----Service login() returned: " + dbUser);
		//	since the username might not be found I could get null back...check for that
		if(dbUser != null) {
			System.out.println("[LOG]---dbUser null check----Service login() status: success");
			//	now let's compare the userInput's password to the dbUser's password
			if(dbUser.getPassword().equals(userInput.getPassword())) {
				System.out.println("[LOG]---Compare pw----Service login() pw: success");
				return dbUser;
			}
		}
		System.out.println("[LOG]---Ending----Service login() pw: fail");
		return null;
	}
	
	public List<Task> getAllTasks(){
		System.out.println("[LOG]----retrieving---All tasks");
		//any validation before asking the db? maybe in future but not at the moment
		//so let's call the dao to get Takss from the db
=======
	public List<Task> getAllTasks(){
		System.out.println("[LOG]----retrieving---All tasks");
		// any validation before asking the db? maybe in future but not at moment
		// so let's call the dao to get Tasks from the DB
>>>>>>> f963ce3a5c8899ea111b471162fbbacadb3bb589:project examples/todo_projects/TodoList-Restful-API/src/main/java/com/revature/service/AppService.java
		
		return userDao.getAllTasks();
	}
	
<<<<<<< HEAD:JDBC/TodoList/src/main/java/com/revature/service/AppService.java
	public User getUser(int id) {
//		return userDao.getUserByUsername(username);
		return null;
	}
	
	public int createUser(User user) {
		return 0;
	}
	
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
=======
	public List<Task> getTasksByUserId(int id){
		System.out.println("[LOG]---retrieving----User Tasks");
		
		return userDao.getTasksByUserId(id);
		
	}
	
	public User getUser(int id) {
//		userDao.getUserByUsername(username);
		return null;
	}
	
	
	public int createUser(User user) {
//		userDao.getUserByUsername(username)
		return 0;
	}
>>>>>>> f963ce3a5c8899ea111b471162fbbacadb3bb589:project examples/todo_projects/TodoList-Restful-API/src/main/java/com/revature/service/AppService.java
}
