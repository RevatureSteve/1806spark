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

	private LoggedUser(String username, String password, int userId) {
		super();
		this.username = username;
		this.password = password;
		this.userId = userId;
	}

	public static LoggedUser getUser() {
		return user;

	}

	public static void createUser(String username, String password, int userId) {
		user = new LoggedUser(username, password, userId);
	}

	public int getUserId() {
		return userId;
	}

}
