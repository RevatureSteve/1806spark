package com.revature.domain;

public class User {
	
	private int uId;
	private String email;
	private String password;
	private String fname;
	private String lname;
	private int positionId;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(int uId, String email, String password, String fname, String lname, int positionId) {
		super();
		this.uId = uId;
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.positionId = positionId;
	}



	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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



	public int getPositionId() {
		return positionId;
	}



	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}



	@Override
	public String toString() {
		return "User [uId=" + uId + ", email=" + email + ", password=" + password + ", fname=" + fname + ", lname="
				+ lname + ", positionId=" + positionId + "]";
	}
	
	
	

}
