package com.registrar.pojo;

import java.io.Serializable;

public class User implements Serializable {
	
	private int users_id;
	private String username;  // UNIQUE NOT NULL
	private String password;  // NOT NULL,
	private String fname;
	private String lname;
	
	public User() {}

	public User(int users_id, String username, String password, String fname, String lname) {
		super();
		this.users_id = users_id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
	}

	public int getUsers_id() {
		return users_id;
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	/* does not include user password */
	@Override
	public String toString() {
		return "User [users_id=" + users_id + ", username=" + username + ", fname=" + fname + ", lname=" + lname + "]";
	}

}
