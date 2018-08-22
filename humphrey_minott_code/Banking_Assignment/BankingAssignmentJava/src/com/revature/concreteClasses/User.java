package com.revature.concreteClasses;



public class User{

	private int userID;
	private String username;
	private String password;
	private String fname;
	private String lname;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId, String username, String password, String fname, String lname) {
		super();
		this.userID = userId;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		
	}
	
	

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", fname=" + fname
				+ ", lname=" + lname + "]";
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	

	
	
}
