package com.revature.POJO;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	private int uId;
	private int posId;
	private String email;
	private String password;
	private String fname;
	private String lname;
	private List<Reimbursement> userRes;
	
	public User() {
		super();
	}
	
	public User(int uId, String email, String password, String fname, String lname, int posId) {
		super();
		this.uId = uId;
		this.posId = posId;
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
	}

	public User(int posId, String email, String password) {
		super();
		this.posId = posId;
		this.email = email;
		this.password = password;
	}
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getPosId() {
		return posId;
	}

	public void setPosId(int posId) {
		this.posId = posId;
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

	@Override
	public String toString() {
		return "User Id: " + uId + "\nPosition:" + posId
				+ "\nEmail: " + email + "\nPassword: " + password + "\nName: " + fname + " " + lname;
	}
	
	public List<Reimbursement> getUserRes() {
		return userRes;
	}
	public void setUserRes(List<Reimbursement> userRes) {
		this.userRes = userRes;
	}

	
}
