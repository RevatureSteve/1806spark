package cam.revature.service;

import cam.revature.dao.UserDao;
import cam.revature.dao.UserDaoImpl;
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

}
