package com.revature.domain;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="BANK_ACCOUNT")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class BankAccount implements Serializable {

	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USERS_ID")
	private BankUser User;
	@Id
	@Column(name="ACCOUNT_NUMBER")
	private int AcctNum;
	@Column(name="BALANCE")
	private int Balance;
	
	

	/**
	 * 
	 */
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	public BankAccount(BankUser user, int acctNum, int balance) {
		super();
		User = user;
		AcctNum = acctNum;
		Balance = balance;
	}


	public int getAcctNum() {
		return AcctNum;
	}
	public void setAcctNum(int acctNum) {
		AcctNum = acctNum;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public BankUser getUserId() {
		return User;
	}
	public void setUserId(BankUser userId) {
		User = userId;
	}
	@Override
	public String toString() {
		return "BankAccount [UserId=" + User + ", AcctNum=" + AcctNum + ", Balance=" + Balance + "]";
	}

	
	
	
}
