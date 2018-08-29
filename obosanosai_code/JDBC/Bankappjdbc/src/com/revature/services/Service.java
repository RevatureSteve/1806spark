package com.revature.services;

import java.util.List;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.TransactionDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.OverdraftDiscoveredException;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Transaction;
import com.revature.pojo.User;

public class Service {
	
	
//This is to Validate if the users information inputed is right,It'll return true if user does exist and false if not

	public static boolean userExists(String username, String password) {
		UserDaoImpl users = new UserDaoImpl();
		List<User> userList = users.readUser();
		for (User u : userList) {
			User user = (User) u;
			if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
				User.setPresentUser(user);
				return true;
			}
		}
		return false;
	}
	

	//	This finds the bank account of the present user
	
	public static void applyUserAccount(int userId) {
		BankAccountDaoImpl accountDao = new BankAccountDaoImpl();
		BankAccount userAccount = accountDao.getAccountById(userId);
		BankAccount.setCurrentAccount(userAccount);
	}
	

	//	this is to withdraw money from the account
	public static void withdrawl(Double amount) throws OverdraftDiscoveredException {
		BankAccount account = BankAccount.getPresentAccount();
		Double balance = account.getBalance();
		if (balance - amount > 0) {
			account.setBalance(balance - amount);
			new BankAccountDaoImpl().updateAccount(account);
			Transaction tx = new Transaction(amount, "Withdrawal", account.getAccountNum());
			new TransactionDaoImpl().createTx(tx);
		}
		if (balance - amount < 0) {
			throw new OverdraftDiscoveredException();
		}
	}
//	This is to deposit money into the account
	
	public static void deposit(Double amount) {
		BankAccount account = BankAccount.getPresentAccount();
		Double balance = account.getBalance();
		account.setBalance(balance + amount);
		new BankAccountDaoImpl().updateAccount(account);
		Transaction tx = new Transaction(amount, "Deposit", account.getAccountNum());
		new TransactionDaoImpl().createTx(tx);
	}
	
}