package com.revature.buisnesslogic;

import java.util.List;

import com.revature.dao.BankAccountDao;
import com.revature.dao.TransactionDao;
import com.revature.dao.UserDao;
import com.revature.exceptions.NotEnoughMoneyException;
import com.revature.exceptions.NoNegativeNumber;
import com.revature.pojo.BankAccount;
import com.revature.pojo.BankTransaction;
import com.revature.pojo.Users;

public class BuisnessLogic {

	/**
	 * Checks to make sure user exists and password correct
	 * 
	 * @param username
	 * @param password
	 * @return true if user exists, false otherwise
	 */
	public static boolean userExists(String username, String password) {
		UserDao users = new UserDao();
		List<Object> userList = users.read();
		for (Object obj : userList) {
			Users user = (Users) obj;
			if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
				Users.setCurrentUser(user);
				return true;
			}
		}
		return false;
	}

	/**
	 * Finds the current users bank account
	 * 
	 * @param userId
	 */
	public static void findAndSetUserAccount(int userId) {
		BankAccountDao accountDao = new BankAccountDao();
		BankAccount userAccount = accountDao.getById(userId);
		BankAccount.setCurrentAccount(userAccount);
	}

	/**
	 * Make a withdraw from account Checks to see balance after withdraw is not < 0
	 * 
	 * @param amount
	 * @throws NotEnoughMoneyException
	 * @throws NoNegativeNumber
	 */
	public static void makeWithdrawl(Double amount) throws NotEnoughMoneyException, NoNegativeNumber {
		if (amount > 0) {
			BankAccount account = BankAccount.getCurrentAccount();
			Double balance = account.getBalance();
			if (balance - amount > 0) {
				account.setBalance(balance - amount);
				new BankAccountDao().update(account);
				BankTransaction trans = new BankTransaction(amount, "Withdrawal", account.getAccountNumber());
				System.out.println("Withdrawal successful");
				new TransactionDao().create(trans);
			} else {
				throw new NotEnoughMoneyException();
			}
		} else {
			throw new NoNegativeNumber();
		}

	}

	/**
	 * make a deposit to an account
	 * 
	 * @param amount
	 * @throws NoNegativeNumber
	 */
	public static void makeDeposit(Double amount) throws NoNegativeNumber {
		if (amount > 0) {
			BankAccount account = BankAccount.getCurrentAccount();
			Double balance = account.getBalance();
			account.setBalance(balance + amount);
			new BankAccountDao().update(account);
			BankTransaction trans = new BankTransaction(amount, "Deposit", account.getAccountNumber());
			new TransactionDao().create(trans);
		} else
			throw new NoNegativeNumber();

	}

	/**
	 * Checks to make sure the passwords match
	 * 
	 * @param password
	 * @param confPass
	 * @return true if they match
	 */
	public static Boolean passwordCheck(String password, String confPass) {
		if (password.equals(confPass)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if username is available
	 * 
	 * @param Username
	 * @return true if username is available
	 */
	public static boolean checkUsername(String username) {
		Users user = new UserDao().getUserByUserName(username);
		if (user == null) {
			return true;
		}
		return false;
	}

}
