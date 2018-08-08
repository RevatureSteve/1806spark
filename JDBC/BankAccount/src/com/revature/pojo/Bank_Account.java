package com.revature.pojo;

/**
 * Bank_Account Class will be modeled after a table in the database. Each state
 * will be represent a field in the database (pretty much a variable will be a
 * column in the database)
 * 
 * 
 * @author Alex Moraga
 *
 */

public class Bank_Account {

	private int accountNumber; // PRIMARY KEY
	private int balance;
	private int userId; // foreign key: wouldn't this share with the USER's class, meaning that we will have to
						// extend from users?

	// no-args constructor
	public Bank_Account() {
		super();
	}

	// constructor with parameters
	public Bank_Account(int accountNumber, int balance, int userId) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.userId = userId;
	}

	// setters & getters
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Bank_Account [accountNumber=" + accountNumber + ", balance=" + balance + ", userId=" + userId + "]";
	}

}
