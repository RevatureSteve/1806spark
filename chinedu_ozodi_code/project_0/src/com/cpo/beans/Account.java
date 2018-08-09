package com.cpo.beans;

import java.io.Serializable;

public class Account implements Serializable{
	
	/**
	 * Class version
	 */
	private static final long serialVersionUID = 1L;
	
	private int accountNumber;
	private long balance;
	private int userId;

	public Account() {
	}

	public Account(long balance, int userId) {
		super();
		this.balance = balance;
		this.userId = userId;
	}

	public Account(int accountNumber, long balance, int userId) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.userId = userId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
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
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", userId=" + userId + "]";
	}
	
	

}
