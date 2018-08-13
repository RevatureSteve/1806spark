package com.revature.pojo;

public class User {
	
	//	state
	private int userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	
	private static User currentUser = null;
	
	//	no-args constructor
	public User() {
		super();
	}

	public User(int userId, String userName, String password, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	//	getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + "]";
	}
	
	public static User getCurrentUser() {
		return currentUser;
	}


	public static void setCurrentUser(User currentUser) {
		User.currentUser = currentUser;
	}

}
