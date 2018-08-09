package com.revature.pojo;

public class User {
	
	//	state
	private int userId;
	private String fName;
	private String lName;
	private String userName;
	private String password;
	
	private static User currentUser = null;
	
	//	no-args constructor
	public User() {
		super();
	}

	public User(int userId, String fName, String lName, String userName, String password) {
		super();
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.password = password;
	}

	//	getters and setters
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

	//	toString
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + fName + ", lastName=" + lName + ", userName="
				+ userName + ", password=" + password + "]";
	}
	
	public static User getCurrentUser() {
		return currentUser;
	}


	public static void setCurrentUser(User currentUser) {
		User.currentUser = currentUser;
	}

}
