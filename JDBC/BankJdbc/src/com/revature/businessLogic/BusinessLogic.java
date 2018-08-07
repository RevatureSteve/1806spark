package com.revature.businessLogic;

import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.pojo.Users;

public class BusinessLogic {

	/**
	 * This is the last step of the JDBC where we take the result set which was the "UserDaoImpl" and our pojo "users" 
	 * 		and create a business application and in this case we want to login 
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean userExsists(String userName, String password) {//the method created when we have identified the username and to test if the username matches the one in our database
		//pay no attention to these bottom three lines
		//UserDaoImpl users = new UserDaoImpl();
		//List<Object> userList = users.read();
		//Users user = new Users();
		
		UserDaoImpl x = new UserDaoImpl();//here we declare a variable for our  dao implementation
		Users y = x.getUserByUserName(userName);//here we declare a variable for
		String x1 = y.getPassword();//here we declare a variable to retrive our password from the databse
		if (x1.equals(password)) {//we then compare the password in the sql vs the one we type into the console
			return true;//returns true and we can access the LoginScreen 
		}
		return false;//returns false and the LoginScreen takes care of the problem by providing a sysout
	}
}
