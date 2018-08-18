package com.revature.domain;

import java.io.Serializable;

public class Users implements Serializable {
	
	private int u_id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private int pos_id;
	
	
	
	
	public Users(int u_id, String fname, String lname, String email, String password, int pos_id) {
		super();
		this.u_id = u_id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.pos_id = pos_id;
	}




	public Users() {}




	public int getU_id() {
		return u_id;
	}




	public void setU_id(int u_id) {
		this.u_id = u_id;
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




	public int getPos_id() {
		return pos_id;
	}




	public void setPos_id(int pos_id) {
		this.pos_id = pos_id;
	}




	@Override
	public String toString() {
		return "Users [u_id=" + u_id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", pos_id=" + pos_id + "]";
	}


	
	

}
