package com.revature.bank.pojo;

public class User {
	public int u_id;
	public String username;
	public String password;
	
	public User(int u_id, String username, String password) {
		super();
		this.u_id = u_id;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", username=" + username + ", password=" + password + "]";
	}
	public User() {
		super();
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
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
	
	
}
