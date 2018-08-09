package com.revature.domain;

import java.io.Serializable;
import java.util.List;

/**
 * User Class found in the Domain package (classes that are ORM)
 * 		(ORM: object relational mapping...a class that is modeled after a table
 * @author Stephen Hong
 *
 */

public class User implements Serializable{
	
	private int userId;
	private String username;
	private String password;
	
	//	additional property I probably will need here (not a field/attribute in the data)
	//	I know users will have multiple tasks...probably use a Collection or Array to hold them
	private List<Task> userTasks;
	
	public User() {}

	//	lazy loading from the db - only get this table's info, not foreign key
	public User(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	//	eager loading from the db - get other table's info like user's tasks
	public User(int userId, String username, String password, List<Task> userTasks) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userTasks = userTasks;
	}

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
