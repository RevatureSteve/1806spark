package com.revature.pojo;

public class BankAccount {
	
	//states
	private int accountNumber;
	private double balance;
	private int usersId;
	
	//constructor using fields
	public BankAccount(int accountNumber, double balance, int usersId) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.usersId = usersId;
	}
	
	//NO-ARGS constructor
	public BankAccount() {}

	//getters n' setters
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	//toString()
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance + ", usersId=" + usersId + "]";
	}
}
