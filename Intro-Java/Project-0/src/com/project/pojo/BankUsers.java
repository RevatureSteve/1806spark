package com.project.pojo;

import java.io.Serializable;

public class BankUsers  implements Serializable{
	
	private static BankUsers currentUser = null;
	private int userId;
	private String username;
	private String password;
	private String fName;
	private String lName;
	
	public BankUsers() {}
	
	public int BankUsers() {
		
		return userId;
	}



	public BankUsers(int userId, String username, String password, String fName, String lName) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "" + userId;
	}
	public static BankUsers getCurrentUser() {
		return currentUser;
	}


	public static void setCurrentUser(BankUsers currentUser) {
		BankUsers.currentUser = currentUser;
	}
	
	

}