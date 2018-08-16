package com.revature.domain;

import java.io.Serializable;
import java.util.List;

/**
 * User Class found in the Domain package (classes that are ORM)
 * 		(ORM: object relational mapping... a class that is modeled after a table)
 * @author lolitsrhys
 *
 */

public class User implements Serializable{

	private int userId;
	private String username;
	private String password;
	
	// additional property I probably will need here (not a field/attribute in the database)
	// I know User will have multiple task... probably use a Collection or ARray to hold them
	private List<Task> userTasks;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	// lazy loading from the Database - only get this table's information not foreign key
	public User(int uId, String username, String password) {
		super();
		this.userId = uId;
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

	public int getuserId() {
		return userId;
	}

	public void setuserId(int uId) {
		this.userId = uId;
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
	

	public List<Task> getUserTasks() {
		return userTasks;
	}

	public void setUserTasks(List<Task> userTasks) {
		this.userTasks = userTasks;
	}

	@Override
	public String toString() {
		return "User [uId=" + userId + ", username=" + username + ", password=" + password + "]";
	}

	
	
}
