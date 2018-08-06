package com.revature.sing;

public class User {
  private String username;
  private String password;
  private int userId;
  
  private static User log;
  

private User(String username, String password, int userId) {
	super();
	this.username = username;
	this.password = password;
	this.userId = userId;
}

public String getUsername() {
	return username;
}

public String getPassword() {
	return password;
}
public int getUserId() {
	return userId;
}

public static void newUser(String username, String password, int userId) {
	log = new User(username, password, userId);
}
  
}
