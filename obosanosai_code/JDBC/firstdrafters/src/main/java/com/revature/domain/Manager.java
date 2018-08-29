package com.revature.domain;

import java.io.Serializable;
import java.util.List;

/**
 * User class found in the Domain package (classes that are ORM)
 *       (ORM: object relational mapping...a class that is modeled after a table)
 * @author obosanosa-igiebor
 *
 */
public class Manager implements Serializable {

	private int userId;
	private String email;
	private String password;
	
	// additional I probably will need here (not a field/attribute in the data)
	// I know users will have multiple task... probably use a collection or Array to hold them
	private List<Task> userTasks;
	
	public Manager() {}

	// lazy loading from the Database - only gets this table's info not, foreign key.
	public Manager(int userId, String email, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
	}
	
   // eager  oading from the Database - gets other table's info like user's tasks
	public Manager(int userId, String email, String password, List<Task> userTasks) {
		super();
		this.userId = userId;
		this.email = email;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + "]";
	}
	
}
