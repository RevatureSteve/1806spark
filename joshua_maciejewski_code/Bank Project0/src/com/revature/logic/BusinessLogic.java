package com.revature.logic;

import com.revature.dao.BankDao;
import com.revature.dao.LoginDaoImpl;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;


public class BusinessLogic {
	
	public static Users userValidation(String username, String password) {
		
		BankDao dao = new LoginDaoImpl();
		Users user = Users.potentialUser();
		if (dao.getUsername(username) != null) {
			if (user.getPassword().equals(password)) {
				System.out.println("Welcome");
				
				return user;
			}
		}
		
		return null;
		
	}
	
	
	public static boolean noNegativeBalance(double currentBalance, double withdrawAmt) {
		
		if(currentBalance - withdrawAmt >= 0) {
			return true;
		}
		
		
		return false;
	}
	
	
	


	
	
	
	
	public static boolean noNegativeValue(double depositAmt)  {
	
	
		if(depositAmt > 0) {
			return true;
	}
		
		return false;
	}
	
	
	
}



