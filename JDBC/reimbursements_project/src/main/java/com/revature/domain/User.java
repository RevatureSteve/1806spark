package com.revature.domain;

public class User {
	private int uId;
	private String email;
	private String password;
	private String fname;
	private String lname;
	private int positionId;
	private String position;
	
	public User(int uId, String email, String password, String fname, String lname,int positionId, String position) {
		super();
		this.uId = uId;
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.positionId = positionId;
		this.position = position;
	}

	public int getuId() {
		return uId;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getPosition() {
		return position;
	}

	public int getPositionId() {
		return positionId;
	}
}
