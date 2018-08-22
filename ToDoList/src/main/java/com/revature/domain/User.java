package com.revature.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	
	/**
	 * 
	 * User Class found in the Domain package (Classes that are ORM)
	 * (ORM: Object Relational Mapping... a class that is modeled after a table)
	 */
	
	private int userId;
	private String username;
	private String password;
	private  List<Task> userTask;
	

	//lazy loading from database - only get this table's information, (not foreign key)
	public User(int userId, String username, String password, List<Task> userTask) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userTask = userTask;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// eager loading from the database - get other table's information like user's table
	public User(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
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


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}

	public List<Task> getUserTask() {
		return userTask;
	}

	
	public void setUserTask(List<Task> userTask) {
		this.userTask = userTask;
	}
	
	
	
	
	
	
	

}
