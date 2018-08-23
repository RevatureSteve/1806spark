package com.kingsgame.pojo;

public class User {

private int u_id;
private String email;
private String password;
private String fname;
private String lname;
private int pos_id;
private String pos_type;

private static User myUser;

//FULL USER & REGISTER
public static User getUser
(int u_id, String email, String password,
String fname, String lname, int pos_id, String pos_type) {
	if (myUser == null) {
		myUser = new User(u_id,email,password,
		fname, lname, pos_id, pos_type);
	}return myUser;
	//CREATE A FUNCTION THAT ALLOWS ME TO LOGOUT OF THE USER, AND DELETE MYUSERS INFORMATION AND RETURN IT TO NULL.
	
}
// LOGIN
public User(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}

public User(int u_id, String email, String password, String fname, String lname, int pos_id, String pos_type) {
	super();
	this.u_id = u_id;
	this.email = email;
	this.password = password;
	this.fname = fname;
	this.lname = lname;
	this.pos_id = pos_id;
	this.pos_type = pos_type;
}
public User(String email, String password, String fname, String lname, int pos_id) {
	super();
	this.email = email;
	this.password = password;
	this.fname = fname;
	this.lname = lname;
	this.pos_id = pos_id;
}

public User() {
	super();
}

public int getU_id() {
	return u_id;
}

public void setU_id(int u_id) {
	this.u_id = u_id;
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

public int getPos_id() {
	return pos_id;
}

public void setPos_id(int pos_id) {
	this.pos_id = pos_id;
}

public static User getMyUser() {
	return myUser;
}

public String getPos_type() {
	return pos_type;
}
public void setPos_type(String pos_type) {
	this.pos_type = pos_type;
}
public static void setMyUser(User myUser) {
	User.myUser = myUser;
}
@Override
public String toString() {
	return "User [u_id=" + u_id + ", email=" + email + ", password=" + password + ", fname=" + fname + ", lname="
			+ lname + ", pos_id=" + pos_id + "pos_type="+pos_type+"]";
}



	
}
