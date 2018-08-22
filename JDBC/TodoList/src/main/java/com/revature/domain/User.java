package com.revature.domain;

import java.io.Serializable;
import java.util.List;

/**
<<<<<<< HEAD
 * User Class found in the Domain package (classes that are ORM) (ORM: object
 * relational mapping...a class that is modeled after a table)
 * 
 * @author Steve Work PC
 *
 */
public class User implements Serializable {

	private int userId;
	private String username;
	private String password;

	// additional property I probably will need here (not a field/attribute in the
	// data)
	// I know User will have multiple task...probably use a Collection or Array to
	// hold them
	private List<Task> userTasks;

	public User() {
	}

	// lazy loading from the Database - only get this table's information not foreign key
=======
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
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	public User(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

<<<<<<< HEAD
	// eager loading from the Database - get other table's information like user's tasks
=======
	//	eager loading from the db - get other table's info like user's tasks
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	public User(int userId, String username, String password, List<Task> userTasks) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userTasks = userTasks;
	}

<<<<<<< HEAD
=======
	public List<Task> getUserTasks() {
		return userTasks;
	}

	public void setUserTasks(List<Task> userTasks) {
		this.userTasks = userTasks;
	}

>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
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

<<<<<<< HEAD
	public List<Task> getUserTasks() {
		return userTasks;
	}

	public void setUserTasks(List<Task> userTasks) {
		this.userTasks = userTasks;
	}

=======
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}
<<<<<<< HEAD
	
=======
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf

}
