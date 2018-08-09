package com.revature.domain;

import java.util.List;

/**
 * User Class found in the domain package (classes that are ORM)
 * 		(ORM: object relational mapping...a class that is modeled after a table)
 * @author Ola
 *
 */

public class User {

	private int userId;
	private String username;
	private String password;
	
	//additional property I probably will need here (not a field/attribute in the data)
	//I know User will have multiple Task..probably use a Collection or Array to hold them
	private List<Task> userTask;
	
	public User () {}
	
	//lazy loading from the Database - only get this table's information not foreign key
	public User(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	//eager loading database - get other table's information like user's tasks
	public User(int userId, String username, String password, List<Task> userTask) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userTask = userTask;
	}
	
	public List<Task> getUserTask() {
		return userTask;
	}

	public void setUserTask(List<Task> userTask) {
		this.userTask = userTask;
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
