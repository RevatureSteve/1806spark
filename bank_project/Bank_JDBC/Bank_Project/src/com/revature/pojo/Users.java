package com.revature.pojo;

public class Users {

	private int userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	
	
	public Users() {}
	
	
	public Users(int userId, String userName, String password, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}


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


	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	
	
}
