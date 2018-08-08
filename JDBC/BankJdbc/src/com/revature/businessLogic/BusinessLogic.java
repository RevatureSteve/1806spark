package com.revature.businessLogic;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.MainDao;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class BusinessLogic {

	private static MainDao Dao = new BankAccountDaoImpl();
	/**
	 * This is the last step of the JDBC where we take the result set which was the "UserDaoImpl" and our pojo "users" 
	 * 		and create a business application and in this case we want to login 
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean userExsists(String userName, String password) {//the method created when we have identified the username and to test if the username matches the one in our database

		BankAccountDaoImpl userDao = new BankAccountDaoImpl();//here we declare a variable for our  dao implementation
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
	 * @return 
	 */
	public static boolean getUserAccount(int userId) {
		BankAccountDaoImpl accountDao = new BankAccountDaoImpl();
		BankAccount userAccount = accountDao.getBankAccountByUserId(userId);
		BankAccount.setCurrentAccount(userAccount);
		return true;
	}
	
	public static boolean validDeposit(double txAmount) {
		
		Users user = Users.getCurrentUser();
		
		if (txAmount < 0) {
			System.out.println("No negatives numbers");
			return false;
		} else {
			Dao.depositIntoBank(txAmount, user.getUserId() );
			System.out.println("DEPOSIT SUCCESSFUL");
			return true;
		}
	}	
	
	public static boolean validWithdraw(double txAmount) {
		
		Users user = Users.getCurrentUser();
		
		if (txAmount <= BankAccount.getCurrentAccount().getBalance()) {
			System.out.println("WITHDRAW SUCCESSFUL");
			Dao.withdrawFromBank(txAmount, user.getUserId());
			return false;
		} else {
			System.out.println("not enough funds");
			return true;
		}
	}	
}
