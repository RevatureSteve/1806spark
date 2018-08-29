package com.revature.beans;

import java.util.List;

public class User {
	
	//variables
	private int usersId;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	
	//private Usertype userType;
	private List<Account> account;
	
	//no var constructor
	public User() {
		super();
		
	}
	
	//var constructor for returns
	public User(int usersId, String firstname, String lastname, String username, String password, List<Account> account) {
		super();
		this.usersId = usersId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	//	this.userType = userType;  Usertype userType,
		this.account = account;
	}
	
//	public User(int userId, String firstname, String lastname, String username, String password,
//			List<Account> account) {
//		super();
//		this.usersId = userId;
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.username = username;
//		this.password = password;
//		//this.userType = userType;
//		this.account = account;
//	}

	//var constructor for creation
	public User(String firstname, String lastname, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;

	}


	//setters and getters
	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
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

//	public Usertype getUserType() {
//		return userType;
//	}
//
//	public void setUserType(Usertype userType) {
//		this.userType = userType;
//	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	
	//toString method
	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + password + ", account=" + account + "]";
	}
	
	
	
	

	
	


	
	
}
