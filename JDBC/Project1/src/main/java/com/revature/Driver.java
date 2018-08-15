package com.revature;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.domain.Users;

public class Driver {

	public static void main(String[] args) {
		System.out.println("testing...");
		
		/*
		 * Here are the values used to provide to my dao to access the db to login
		 * 		and I am certain this is the same one I will use to login for managers as well
		 * 		since they must provide their own email and pw.
		 */
		/*String emailInput = "dan@yahoo.com";
		String pwInput = "dan123";
		String fnameInput = "";
		String lnameInput = "";
		
		Users validUser = new BusinessLogic().login(new Users(0, emailInput, pwInput, fnameInput, lnameInput, 0));
		System.out.println("The user based upon the email and password provided is: \n\t\t" + validUser);*/
		
		/*
		 * Here is the List of Users
		 * 		Note: I may have to use Business Logic to pull only employees as a manager
		 */
		/*List<Users> allUsers = new UserDao().getAllUsers();
		System.out.println("Here is the List of all our Users\n" + allUsers);*/
		
	}

}
