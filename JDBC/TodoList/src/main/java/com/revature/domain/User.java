package com.revature.domain;

import java.io.Serializable;
import java.util.List;

/**
<<<<<<< HEAD
 * User Class found in the Domain package (classes that are ORM)
 * 		(ORM: object relational mapping... a class that is modeled after a table)
 * @author lolitsrhys
 *
 */

public class User implements Serializable{
=======
 * User Class found in the Domain package (classes that are ORM) (ORM: object
 * relational mapping...a class that is modeled after a table)
 * 
 * @author Steve Work PC
 *
 */
public class User implements Serializable {
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8

	private int userId;
	private String username;
	private String password;
<<<<<<< HEAD
	
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
=======

	// additional property I probably will need here (not a field/attribute in the
	// database)
	// I know User will have multiple task...probably use a Collection or Array to
	// hold them
	private List<Task> userTasks;

	public User() {
	}

	// lazy loading from the Database - only get this table's information not foreign key
	public User(int userId, String username, String password) {
		super();
		this.userId = userId;
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
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

<<<<<<< HEAD
	public int getuserId() {
		return userId;
	}

	public void setuserId(int uId) {
		this.userId = uId;
=======
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
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
	
=======
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8

	public List<Task> getUserTasks() {
		return userTasks;
	}

	public void setUserTasks(List<Task> userTasks) {
		this.userTasks = userTasks;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "User [uId=" + userId + ", username=" + username + ", password=" + password + "]";
	}

	
	
=======
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}
	

>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
}
