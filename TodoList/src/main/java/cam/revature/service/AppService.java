package cam.revature.service;

import java.util.List;

import cam.revature.dao.UserDao;
import cam.revature.dao.UserDaoImpl;
import cam.revature.domain.Task;
import cam.revature.domain.User;

/**
 * The logic file
 * Validate models before persisting
 * manipulate models before persisting
 * validate user before pulling sensitive data
 * ect...
 * @author becklarson-Work
 *
 */

public class AppService {
	
	private UserDao userDao = new UserDaoImpl();
	
	public User login(User userInput) {
		User dbUser = userDao.getUserrByUsername(userInput.getUsername());
		if (dbUser != null) {
			if(dbUser.getPassword().equals(userInput.getPassword())) {
				return dbUser;
			}
		}
		
		
		return null;
	}
	
	public List<Task> getAllTasks(){
		System.out.println("[LOG]-----retreving----All tasks");
		//any validation before asking the db? maybe in future but not at the moment
		//so lets call the dao to get Tasks from the DB
		return userDao.getAllTasks();
	}
	
	public List<Task> getTasksByUserId(int id){
		System.out.println("[LOG] ----retreaving---- User Tasks");
		return null;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
