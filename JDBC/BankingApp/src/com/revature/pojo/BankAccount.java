package com.revature.pojo;

public class BankAccount {
	
	private int accountNumber;
	private int balance;
	private int userId;
	
	public BankAccount () {}

	public BankAccount(int accountNumber, int balance, int userId) {
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

	public int getbalance() {
		return balance;
	}

	public void setbalance(int balance) {
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
		return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance + ", userId=" + userId + "]";
	};
	

}
