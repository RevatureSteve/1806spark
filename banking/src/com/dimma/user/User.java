package com.dimma.user;


public class User{
	
private int users_id;
private String username;
private String password;

private String fname;
private String lname;

private static User user;

public static User getUser(int users_id, String username,
		String password, String fname, String lname) {
	if (user == null) {
		user = new User(users_id,username,password,fname,lname);
	}return user;
}
public static User getUser() {
return user;
}


public User() {
	super();
}

//Login Constructor
public User(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
// Register Constructor
public User(int users_id, String username, String password, String fname, String lname) {
	super();
	this.users_id = users_id;
	this.username = username;
	this.password = password;
	this.fname = fname;
	this.lname = lname;
}
public int getUsers_id() {
	return users_id;
}
public void setUsers_id(int users_id) {
	this.users_id = users_id;
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
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}

@Override
public String toString() {
	return "User [users_id=" + users_id + ", username=" + username + ", password=" + password + ", fname=" + fname
			+ ", lname=" + lname + "]";
}
}
