package com.revature.singletons;

public class LoggedUser {
	private String username;
	private String password;
	private int userId;

	private static LoggedUser user;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	private LoggedUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;

	}

	public static LoggedUser getUser() {
		return user;

	}

	public static void createUser(String username, String password) {
		user = new LoggedUser(username, password);
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
