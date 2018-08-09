package com.revature.domain;

import java.io.Serializable;
import java.util.List;

/**
 * User Class found in the Domain package (classes that are ORM)
 * 	(ORM: object relational mapping.... a class that is modeled after a table)
 * @author Joshua
 *
 */

public class User implements Serializable{
	
	private int uId;
	private String username;
	private String password;
	
	//additional property I probably will need here (not a field/attribute in the data)
	//i know user will have multiple task... probably use a collection or array to hold them
	
	
	private List<Task> userTasks;
	
	public User() {
	}
	
	// lazy loading from the database: only get this table's information, not foreign key
	public User(int uId, String username, String password) {
		super();
		this.uId = uId;
		this.username = username;
		this.password = password;
	}
	
	
	// eager loading from the database- get other table's information like user's tasks
	public User(int uId, String username, String password, List<Task> userTasks) {
		super();
		this.uId = uId;
		this.username = username;
		this.password = password;
		this.userTasks = userTasks;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
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
		return "User [uId=" + uId + ", username=" + username + ", password=" + password + "]";
	}


	
	

}
