package com.revature.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity	
@Table(name="USERS")
public class BankUser {
	
	@Id //PK
	@Column(name="USERS_ID")
	private int usersId;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="FNAME")
	private String fname;
	
	@Column(name="LNAME")
	private String lname;
	
	/*
	 * first annotation: one user to many bankaccounts
	 * second annotation: join the users to the bank account by their ACCOUNT_NUMBER
	 */
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="ACCOUNT_NUMBER")
	private List<BankAccount> bankAccount;   
//	private transient BankAccount bankAccount;   
	


	public BankUser(int usersId, String username, String password, String fname, String lname) {
		super();
		this.usersId = usersId;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
	}


	/*
	 * create a constructor with the bankAccount list
	 * we don't know the definate length of the bankAccount list so we use lazy loading
	 */
	public BankUser(int usersId, String username, String password, String fname, String lname,
		List<BankAccount> bankAccount) {
	super();
	this.usersId = usersId;
	this.username = username;
	this.password = password;
	this.fname = fname;
	this.lname = lname;
	this.bankAccount = bankAccount;
}



	public List<BankAccount> getBankAccount() {
		return bankAccount;
	}



	public void setBankAccount(List<BankAccount> bankAccount) {
		this.bankAccount = bankAccount;
	}



	public BankUser() {}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "BankUser [usersId=" + usersId + ", username=" + username + ", password=" + password + ", fname=" + fname
				+ ", lname=" + lname + ", bankAccount=" + bankAccount + "]";
	}


	
}
