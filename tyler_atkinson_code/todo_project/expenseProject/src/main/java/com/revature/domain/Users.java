package com.revature.domain;

import java.io.Serializable;

public class Users implements Serializable {
	
	private int uid;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private int posid;
	
	
	
	
	public Users(int uid, String fname, String lname, String email, String password, int pos_id) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.posid = posid;
	}




	public Users() {}




	


	public int getUid() {
		return uid;
	}




	public void setUid(int uid) {
		this.uid = uid;
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




	public int getPosid() {
		return posid;
	}




	public void setPosid(int posid) {
		this.posid = posid;
	}




	@Override
	public String toString() {
		return "Users [uid=" + uid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", pos_id=" + posid + "]";
	}


	
	

}
