package com.revature.models;

public class User {
	private int id;
	private String username;
	private String pwHash;
	private String pwSalt;
	private String firstName;
	private String lastName;
	private String email;
	private int role;
	
	public User() {}

	public User(int id, String username, String pwHash, String pwSalt, String firstName, String lastName, String email,
			int role) {
		super();
		this.id = id;
		this.username = username;
		this.pwHash = pwHash;
		this.pwSalt = pwSalt;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwHash() {
		return pwHash;
	}

	public void setPwHash(String pwHash) {
		this.pwHash = pwHash;
	}

	public String getPwSalt() {
		return pwSalt;
	}

	public void setPwSalt(String pwSalt) {
		this.pwSalt = pwSalt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwHash=" + pwHash + ", pwSalt=" + pwSalt
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", role=" + role + "]";
	}
	
	
}
