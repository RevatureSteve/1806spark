package com.revature.domain;

import java.io.Serializable;

public class Employee implements Serializable {
	
	private int userId;
	private String email;
	private String password;
	
	//constructor
	public Employee() {}

	//getters and setters
	public Employee(int userId, String email, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//toString
	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	
}
