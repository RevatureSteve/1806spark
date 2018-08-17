package com.revature.pojo;

public class User {
	
	private int user_id;
	private String email;
	private String password;
	private String fname;
	private String lname;
	private int pos_id;
	private String pos_name;
	
	public User() {
		
	}
		
	// lazy loading
	
	public User(int user_id, String email, String password, String fname, String lname, int pos_id) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.pos_id = pos_id;
	}

	

	// eagerly loading
	public User(int user_id, String email, String password, String fname, String lname, int pos_id, String pos_name) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.pos_id = pos_id;
		this.pos_name = pos_name;
	}



	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public int getPos_id() {
		return pos_id;
	}
	public void setPos_id(int pos_id) {
		this.pos_id = pos_id;
	}
	public String getPos_name() {
		return pos_name;
	}
	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", email=" + email + ", password=" + password + ", fname=" + fname
				+ ", lname=" + lname + ", pos_id=" + pos_id + ", pos_name=" + pos_name + "]";
	}
	
	
}
