package com.revature.businessLogic;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.pojo.BankAccount;
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
		
		UserDaoImpl userDao = new UserDaoImpl();//here we declare a variable for our  dao implementation
		Users username = userDao.getUserByUserName(userName);//here we declare a variable for
		String pw = username.getPassword();//here we declare a variable to retrive our password from the databse
		if (pw.equals(password)) {//we then compare the password in the sql vs the one we type into the console
			return true;//returns true and we can access the LoginScreen 
		}
		return false;//returns false and the LoginScreen takes care of the problem by providing a sysout
	}
	
	/**
	 * This displays the current users bank account
	 * @param userId
	 */
	public static void getUserAccount(int userId) {
		BankAccountDaoImpl accountDao = new BankAccountDaoImpl();
		BankAccount userAccount = accountDao.getBankAccountByUserId(userId);
		BankAccount.setCurrentAccount(userAccount);
	}
}
