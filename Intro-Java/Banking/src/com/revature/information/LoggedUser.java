package com.revature.information;

public class LoggedUser {
	private static String username;
	private static String password;
	
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		LoggedUser.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		LoggedUser.password = password;
	}	
}
