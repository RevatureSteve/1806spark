package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USERS")
public class User {

	@Id
	@Column
	private int u_id;
	@Column
	private String username;
	@Column
	private String pw;


	public User() {
	}


	public User(int u_id, String username, String pw) {
		super();
		this.u_id = u_id;
		this.username = username;
		this.pw = pw;
	}


	public int getU_id() {
		return u_id;
	}


	public void setU_id(int u_id) {
		this.u_id = u_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", username=" + username + ", pw=" + pw + "]";
	}
	
	

}
