package com.revature.pojos;

public class BankAccount {
	private int account_number;
	private double balance;
	private int users_id;
	public BankAccount(int account_number, double balance, int users_id) {
		super();
		this.account_number = account_number;
		this.balance = balance;
		this.users_id = users_id;
	}
	public int getAccount_number() {
		return account_number;
	}

	public double getBalance() {
		return balance;
	}

	public int getUsers_id() {
		return users_id;
	}

}
