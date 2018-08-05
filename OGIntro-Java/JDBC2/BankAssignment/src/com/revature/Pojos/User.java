package com.revature.Pojos;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 37;
	public int i;
	public String usename;
	public String pw;
	
	

	public User(int i, String usename, String pw) {
		super();
		this.i= i;
		this.usename = usename;
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "User [i=" + i + ", usename=" + usename + ", pw=" + pw + "]";
	}
	public User() {
		super();
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getUsename() {
		return usename;
	}

	public void setUsename(String usename) {
		this.usename = usename;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	

	
}
