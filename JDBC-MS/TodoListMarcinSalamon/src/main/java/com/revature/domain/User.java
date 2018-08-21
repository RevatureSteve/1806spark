package com.revature.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * User Call found in the Dmain package (classes that are ORM)
 * 	(OBJECT RELATIONAL MAPPING...a class that is modeled after a table)
 * @author marci
 *
 */
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5693019958802813321L;
	private int userId;
	private String username;
	private String password;
	private List<Task> userTasks;
	//lazy loading from Database - only get this table's information not foreign key
	public User(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	
	//eager loading from the Database - get other table's information like user's tasks
	public User(int userId, String username, String password, List<Task> userTasks) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
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
	public List<Task> getUserTasks() {
		return userTasks;
	}
	public void setUserTasks(List<Task> userTasks) {
		this.userTasks = userTasks;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}
}
