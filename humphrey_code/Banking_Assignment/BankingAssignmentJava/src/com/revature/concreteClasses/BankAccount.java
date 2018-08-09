package com.revature.concreteClasses;

public class BankAccount {

	private int accountNumber;//PRIMARY KEY(account_number),
	private int balance;
	private int users_id; //FOREIGN KEY (users_id) REFERENCES users(users_id)
	
	
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BankAccount(int accountNumber, int balance, int users_id) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.users_id = users_id;
	}



	public int getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public int getUsers_id() {
		return users_id;
	}



	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}



	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance + ", users_id=" + users_id + "]";
	}
	
	
	
	
	
	
	
}
