package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users {
	
	@Id
	@Column(name="u_id")
	private int u_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="pw")
	private String pw;

	public Users() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param u_id
	 * @param username
	 * @param pw
	 */
	public Users(int u_id, String username, String pw) {
		super();
		this.u_id = u_id;
		this.username = username;
		this.pw = pw;
	}

	/**
	 * @param username
	 * @param pw
	 */
	public Users(String username, String pw) {
		super();
		this.username = username;
		this.pw = pw;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Users [u_id=" + u_id + ", username=" + username + ", pw=" + pw + "]";
	}
	
	

}
