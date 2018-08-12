package com.revature.domain;

public class Users {

	private int u_id;
	private String email;
	private String password;
	private String fname;
	private String lname;
	private int pos_id;
	
	
	public Users() {
		super();
	}
	
	public Users(int u_id, String email, String password, String fname, String lname, int pos_id) {
		super();
		this.u_id = u_id;
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.pos_id = pos_id;
	}
	
	public int getU_id() {
		return u_id;
	}
	
	public void setU_id(int u_id) {
		this.u_id = u_id;
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
	
	@Override
	public String toString() {
		return "Users [u_id=" + u_id + ", email=" + email + ", password=" + password + ", fname=" + fname + ", lname="
				+ lname + ", pos_id=" + pos_id + "]";
	}
	
	
}
