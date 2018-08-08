package com.revature.pogo;

import java.io.Serializable;

public class Users implements Serializable {

	private int usersId;
	private String username;
	private String password;
	private String firstname;
	private String lastname;

	public Users() {

	}

	public Users(int usersId, String username, String password, String firstname, String lastname) {
		super();
		this.usersId = usersId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + "]";
	}

}
