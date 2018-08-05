package com.revature.pojos;

public class User {
	private String username;
	private String password;
	private int id;
	private String firstname;
	private String lastname;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public User(int id, String username, String password, String firstname, String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}
}
