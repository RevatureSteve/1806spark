package com.revature.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="users")
public class usersPojo {
	
	@Id 
	@Column(name = "U_ID")
	private int uId;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PW")
	private String pw;
	
	
	public usersPojo () {}


	public usersPojo(int uId, String username, String pw) {
		super();
		this.uId = uId;
		this.username = username;
		this.pw = pw;
	}


	public int getuId() {
		return uId;
	}


	public void setuId(int uId) {
		this.uId = uId;
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
		return "usersPojo [uId=" + uId + ", username=" + username + ", pw=" + pw + "]";
	}
	
	

}
