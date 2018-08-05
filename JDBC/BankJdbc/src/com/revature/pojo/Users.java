package com.revature.pojo;

public class Users {
	
	private int userId;
	private String userName;
	private String password;
	private String fName;
	private String lName;
	
	
	//constructor using field
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

	//toString()
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", password=" + password + ", fName=" + fName
				+ ", lName=" + lName + "]";
	}
}
