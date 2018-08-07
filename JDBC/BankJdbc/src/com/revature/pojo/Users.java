package com.revature.pojo;

/*
 * This here is my users pojo that I will use to persist data to sql using my register method
 * 		I will also use this very same pojo to access the users table in sql to display user info such as:
 * 			balance, transaction history, withdrawls and deposits.
 */

public class Users {
	
	private static Users currentUser = null;
	
	private int userId;
	private String userName;//user name
	private String password;//password
	private String fName;//first name
	private String lName;//last name
	
	
	//constructor using fields
	public Users(int userId, String userName, String password, String fName, String lName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
	}
	
	//NO-ARGS constructor
	public Users() {}

	//getters n' setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public static Users getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(Users currentUser) {
		Users.currentUser = currentUser;
	}
	
	
	//toString()
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", password=" + password + ", fName=" + fName
				+ ", lName=" + lName + "]";
	}
}
