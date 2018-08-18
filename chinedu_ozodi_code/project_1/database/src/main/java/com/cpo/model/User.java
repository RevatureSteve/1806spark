package com.cpo.model;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int uId;
	private String email;
	private String password;
	private String fname;
	private String lname;
	private int posId;
	private String posType;
	
	public User() {
		super();
	}
	
	
	public User(String email, String password, String fname, String lname, int posId) {
		super();
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.posId = posId;
	}


	public User(int uId, String email, String password, String fname, String lname, int posId, String posType) {
		super();
		this.uId = uId;
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.posId = posId;
		this.posType = posType;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
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
	public int getPosId() {
		return posId;
	}
	public void setPosId(int posId) {
		this.posId = posId;
	}
	public String getPosType() {
		return posType;
	}
	public void setPosType(String posType) {
		this.posType = posType;
	}


	@Override
	public String toString() {
		return "User [uId=" + uId + ", email=" + email + ", password=" + password + ", fname=" + fname + ", lname="
				+ lname + ", posId=" + posId + ", posType=" + posType + "]";
	}
	
	

}
