package com.revature.bank.pojo;

import java.io.Serializable;

public class Bank_AccountPojo implements Serializable {
	
	private int account_number;
	private double balance;
	private String users_id;
	
	public Bank_AccountPojo() {}

	public Bank_AccountPojo(int account_number, double balance, String users_id) {
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

	public String getUsers_id() {
		return users_id;
	}

	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}

	@Override
	public String toString() {
		return "Bank_AccountPojo [account_number=" + account_number + ", balance=" + balance + ", users_id=" + users_id
				+ "]";
	}
	
	
	

}


