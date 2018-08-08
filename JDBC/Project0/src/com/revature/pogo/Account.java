package com.revature.pogo;

import java.io.Serializable;

public class Account implements Serializable {

	private int accountNumber;
	private double balance;
	private int usersId;

	public Account() {

	}

	public Account(int accountNumber, double balance, int usersId) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.usersId = usersId;
	}

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

	@Override
	public String toString() {
		return "Accounts [accountNumber=" + accountNumber + ", balance=" + balance + ", usersId=" + usersId + "]";
	}

}
