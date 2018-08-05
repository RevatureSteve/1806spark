package com.revature.pojos;

public class BankAccount {
	private int account_number;
	private int balance;
	private int users_id;
	public BankAccount(int account_number, int balance, int users_id) {
		super();
		this.account_number = account_number;
		this.balance = balance;
		this.users_id = users_id;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
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
	
}
