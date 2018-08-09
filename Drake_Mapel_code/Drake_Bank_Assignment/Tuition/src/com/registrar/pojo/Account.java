package com.registrar.pojo;

import java.io.Serializable;

public class Account implements Serializable {
	
	private int account_number;
	private double balance;
	private int users_id;

	public Account() {}

	public Account(int account_number, double balance, int users_id) {
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUsers_id() {
		return users_id;
	}

	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", balance=" + balance + ", users_id=" + users_id + "]";
	}
	
	
}
