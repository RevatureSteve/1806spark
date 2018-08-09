package com.revature.business;

import java.util.List;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.TransactionDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.OverdraftDetectedException;
import com.revature.exceptions.OverdraftDetectedException;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Transaction;
import com.revature.pojo.User;

public class Service {
	
	//	check that user exists
	//	boolean - true if user exists - if not, false 

	public static boolean validUser(String username, String password) {
		UserDaoImpl users = new UserDaoImpl();
		List<User> userList = users.readUser();
		for (User u : userList) {
			User user = (User) u;
			//checks whether the new user object matches the one in the db
			if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
				User.setCurrentUser(user);//verifies that the user info is valid
				return true;
			}
		}
		return false;
	}
	

	//	retrieves user's bank account for DML operations
	
	public static void findUserAccount(int userId) {
		BankAccountDaoImpl accountDao = new BankAccountDaoImpl();
		BankAccount userAccount = accountDao.getAccountById(userId);
		BankAccount.setCurrentAccount(userAccount);
	}
	

	//	Withdraw seals
	public static void withdrawSeals(Double amount) throws OverdraftDetectedException {
		BankAccount account = BankAccount.getCurrentAccount();
		Double balance = account.getBalance();
		if (balance - amount > 0) {//only updates if no overdraft occurs
			account.setBalance(balance - amount);
			new BankAccountDaoImpl().updateAccount(account);
			Transaction tx = new Transaction(amount, "Withdrawal", account.getacctNum());
			new TransactionDaoImpl().createTx(tx);
		}
		if (balance - amount < 0) {//if overdraft occurs, throws exception to withdrawseals class
			throw new OverdraftDetectedException();
		}
	}
//	Deposit seals
	
	public static void depositSeals(Double amount) {
		BankAccount account = BankAccount.getCurrentAccount();
		Double balance = account.getBalance();//first balance is retrieved
		account.setBalance(balance + amount);//adds new deposit to balance 
		new BankAccountDaoImpl().updateAccount(account); //updates balance
		Transaction tx = new Transaction(amount, "Deposit", account.getacctNum());
		new TransactionDaoImpl().createTx(tx);
	}
	
}
