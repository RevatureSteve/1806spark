package com.revature.pojo;

import java.io.Serializable;

/*
 * when user check balance they will be asked with two options
 * select one(1) to add more money/deposit or 
 * select two(2) to withdraw money from the account
 * after user choose to add or withdraw money show them balance again
 * ** show user balance again with updated information
 * select one(1) to add more money/deposit or 
 * select two(2) to withdraw money from the account
 * select three(3) to close the program 
 * then show user the options to add money or no money and the option to exit the program
 * 
 */
/*
 * used this interface to extend to the other pojo
 */

public class Account implements Serializable {
	
	private int accountNumber;

	private double balance;

	private int usersId;
	
	private static Account accountSingleton;
	
	private Account() {
		//no-args
	}
	
	public static Account accountSingleton() {
		if(accountSingleton == null) {
			accountSingleton = new Account();
		}
		return accountSingleton;
		
		// to call Account accountSingleton = Account.accountSingleton();
		
	}
	
	/**
	 * @param accountNumber
	 * @param balance
	 * @param usersId
	 */
	public Account(int accountNumber, double balance, int usersId) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.usersId = usersId;
	}
	

	/**
	 * @return the usersId
	 */
	public int getUsersId() {
		return usersId;
	}

	/**
	 * @param usersId the usersId to set
	 */
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", usersId=" + usersId + "]";
	}

	

	
	
	
	

	

}
