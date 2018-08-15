package com.revature.pojos;

public class Users {

	private int usersId;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private int postitionId;
	
	
	public Users() {}


	public Users(int usersId, String firstname, String lastname, String email, String password, int postitionId) {
		super();
		this.usersId = usersId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.postitionId = postitionId;
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


	public int getUsersId() {
		return usersId;
	}


	public int getPostitionId() {
		return postitionId;
	}


	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", postitionId=" + postitionId + "]";
	};
	
	
	
	
	

}
