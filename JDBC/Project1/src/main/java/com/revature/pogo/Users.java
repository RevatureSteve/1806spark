package com.revature.pogo;

import java.io.Serializable;

public class Users implements Serializable{
	
	private int uId;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private int posId;
	
	public Users() {
		
	}
	
	public Users(int uId, String email, String password, String firstname, String lastname, int posId) {
		super();
		this.uId = uId;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getPosId() {
		return posId;
	}

	public void setPosId(int posId) {
		this.posId = posId;
	}

	@Override
	public String toString() {
		return "users [uId=" + uId + ", email=" + email + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", posId=" + posId + "]";
	}

}
