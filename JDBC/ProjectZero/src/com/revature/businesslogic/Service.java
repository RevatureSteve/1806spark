package com.revature.businesslogic;

import java.util.List;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.TransactionDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.Negative;
import com.revature.exceptions.Overdraft;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Transaction;
import com.revature.pojo.User;

public class Service {
	
	
	//	Validate user info
	//	Return true if user info is correct, false otherwise
	public static boolean validateUser(String username, String password) {
		List<User> userList = new UserDaoImpl().readUser();
		//get a list of users from SQL users table
		for (User u : userList) {
			//iterate through list using for loop
			User user = (User) u;
			//for each object in the list,
			if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
				//check if user input matches object value
				User.setCurrentUser(user);
				//if yes, set it as current user
				return true;
			}
		}
		return false;
	}
	

	//	Finds the current user's bank account
	public static void applyUserAccount(int userId) {
		BankAccount.setCurrentAccount(new BankAccountDaoImpl().getAccountById(userId));
		//receive account info from BankAccountDaoImpl().getAccountById(userId) and set it as current account
	}
	
	//	Deposit to account
	public static void deposit(int amount) throws Negative {
		if (amount > 0) {
			BankAccount account = BankAccount.getCurrentAccount();
			//get account info of current account
			int b = account.getBalance();
			//set b to current account's balance
			account.setBalance(b + amount);
			//set current account's balance to original balance + amount
			new BankAccountDaoImpl().updateAccount(account);
			//update db with new balance
			new TransactionDaoImpl().createTx(new Transaction(amount, "Deposit", account.getAcNum())); //use lazy loading
			//create new transaction log of deposit with user input amount for the current user
		} else if (amount < 0) {
			throw new Negative();
		}
	}

	//	Withdraw from account
	public static void withdrawal(int amount) throws Overdraft, Negative {
		if (amount > 0) {
			BankAccount account = BankAccount.getCurrentAccount();
			//get account info of current account
			int b = account.getBalance();
			//set b to current account's balance
			if (b - amount > 0) {
				account.setBalance(b - amount);
				//set current account's balance to original balance - amount
				new BankAccountDaoImpl().updateAccount(account);
				//update db with new balance
				new TransactionDaoImpl().createTx(new Transaction(amount, "Withdrawal", account.getAcNum())); //use lazy loading
				//create new transaction log of withdrawal with user input amount for the current user
			}else if (b - amount < 0) {
				throw new Overdraft();
			}
		} else if (amount < 0) {
			throw new Negative();
		}
	}
	
}
