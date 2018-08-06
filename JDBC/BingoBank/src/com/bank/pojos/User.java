package com.bank.pojos;

public class User {
	private int user_id;
	private String user_name;
	private String password;
	private String first_name;
	private String last_name;

	public User() {}


	public User( String user_name, String password) {
	super();
	this.user_name = user_name;
	this.password = password;
}
	public User(int user_id, String user_name, String password, String first_name, String last_name) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
	}
//Only getters.
	public int getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getPassword() {
		return password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	};
	


}
