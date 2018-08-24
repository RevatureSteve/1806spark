package com.revature.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount {

	@Id
	@Column(name = "ACCOUNT_NUMBER")
	private int accountNumber;

	@Column(name = "BALANCE")
	private double balance;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USERS_ID")
	private BankUser user;
	
	@OneToMany(mappedBy="bankaccount", fetch=FetchType.EAGER)
	private Set<Transaction> trans;
	
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
	
	public BankUser getUsersId() {
		return user;
	}

	public void setUsersId(BankUser usersId) {
		this.user = usersId;
	}

	public Set<Transaction> getTrans() {
		return trans;
	}

	public void setTrans(Set<Transaction> trans) {
		this.trans = trans;
	}

	public BankAccount() {}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance + ", trans=" + trans + "]";
	}
	
	

}
