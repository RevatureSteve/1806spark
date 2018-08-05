package com.revature.pojo;

public class Users {
	
	
	private static Users user;
	
	private int users_id;
	private String username;
	private String password;
	private String fname;
	private String lname;
	
	
	public static Users prelimUser() {
		if (user == null) {
			user = new Users();
		}
		return user;
	}
	
	public Users() { }
	
	public Users(int users_id, String username, String password, String fname, String lname) {
		super();
		this.users_id = users_id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
	}
	
	public int getId() {
		return users_id;
	}
	public void setId(int id) {
		this.users_id = id;
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

	@Override
	public String toString() {
		return "Users [id=" + users_id + ", username=" + username + ", password=" + password + ", fname=" + fname + ", lname="
				+ lname + "]";
	}
	
	
	
	
}
