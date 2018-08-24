package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BANK_ACCOUNT")

public class BankAccount {
	
	@Id //PK
	@Column(name="ACCOUNT_NUMBER")
	private int accountNumber;
	
	@Column(name="BALANCE")
	private int balance;
	
	/*
	 * first annotation: many bank accounts to one user
	 * second annotation: joining the bank account and bank user by the USER_ID
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERS_ID")
	private BankUser bankUser;

	
	
	public BankAccount() {}



	public BankAccount(int accountNumber, int balance, BankUser bankUser) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.bankUser = bankUser;
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



	public BankUser getBankUser() {
		return bankUser;
	}



	public void setBankUser(BankUser bankUser) {
		this.bankUser = bankUser;
	}


	/*
	 * here we had to remove the BankUser state otherwise we get a stackoverflow
	 */
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance +"]";
	}



	
	
	
	

}
