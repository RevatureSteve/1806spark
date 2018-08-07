package com.revature.domain;

import java.io.Serializable;
import java.util.List;

/**
 * User CLass found in the Domain package (classes that are ORM)
 * 		(ORM: object relational mapping... a class that is modeled after a table)
 * @author christopherholmes
 *
 */

public class User implements Serializable{

	private int userId; 
	private String username;
	private String password;
	
	
	public User() {}
	// lazy loading from the Database - only get this table's information not foreign key
	public User(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	
	// eager loading from the Database - get other table's information like user's tasks
	public User(int userId, String username, String password, List<Task> userTasks) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userTasks = userTasks;
	}


	//additional property I probably will need here (not a field/attribute in the data
	//I know User will have multiple task.. probably use a collection or Array to hold them
	private List<Task> userTasks;
 	
	public List<Task> getUserTasks() {
		return userTasks;
	}


	public void setUserTasks(List<Task> userTasks) {
		this.userTasks = userTasks;
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
	
}
