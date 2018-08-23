package com.revature.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {

	@Id //PK
	@Column(name="U_ID")
	private int U_Id;
	
	@Column(name="USERNAME", unique=true)
	private String Username;
	
	@Column(name="PW")
	private String pw;
	
	public Users() {}

	public Users(int u_Id, String username, String pw) {
		super();
		U_Id = u_Id;
		Username = username;
		this.pw = pw;
	}

	public int getU_Id() {
		return U_Id;
	}

	public void setU_Id(int u_Id) {
		U_Id = u_Id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Users [U_Id=" + U_Id + ", Username=" + Username + ", pw=" + pw + "]";
	}
}
