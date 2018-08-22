package com.revature.domain;

import java.io.Serializable;

public class User implements Serializable{
	private int uId;
	private String email;
	private String password;
	private String fName;
	private String lName;
	private int posId;
	
	
	
	
	public User() {
		super();
	}




	public User(int uId, String email, String password, String fName, String lName, int posId) {
		super();
		this.uId = uId;
		this.email = email;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.posId = posId;
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




	public String getfName() {
		return fName;
	}




	public void setfName(String fName) {
		this.fName = fName;
	}




	public String getlName() {
		return lName;
	}




	public void setlName(String lName) {
		this.lName = lName;
	}




	public int getPosId() {
		return posId;
	}




	public void setPosId(int posId) {
		this.posId = posId;
	}




	@Override
	public String toString() {
		return "User [uId=" + uId + ", email=" + email + ", password=" + password + ", fName=" + fName + ", lName="
				+ lName + ", posId=" + posId + "]";
	}

	
}
