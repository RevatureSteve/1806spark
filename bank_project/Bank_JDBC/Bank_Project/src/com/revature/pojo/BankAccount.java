package com.revature.pojo;

public class BankAccount {

	private int accountNumber;
	private Double balance;
	private int userId;
	
	public BankAccount() {}

	public BankAccount(int accountNumber, Double balance, int userId) {
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

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
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
	}
	
	
	
	
}
