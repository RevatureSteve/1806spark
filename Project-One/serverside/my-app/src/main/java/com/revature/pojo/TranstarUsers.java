package com.revature.pojo;

public class TranstarUsers {

	private int u_id;
	private String email;
	private String password;
	private String fname;
	private String lname;
	private int pos_id;
	private String position;


public TranstarUsers(){
	super();
 }


public TranstarUsers(int u_id, String email, String password, String fname, String lname, int pos_id, String position) {
	super();
	this.u_id = u_id;
	this.email = email;
	this.password = password;
	this.fname = fname;
	this.lname = lname;
	this.pos_id = pos_id;
	this.position = position;
}


public TranstarUsers(int int1, String string, String string2, String string3) {
	this.u_id = int1;
	this.fname = string;
	this.lname = string2;
	this.email = string3;
}


@Override
public String toString() {
	return "TranstarUsers [u_id=" + u_id + ", email=" + email + ", password=" + password + ", fname=" + fname
			+ ", lname=" + lname + ", pos_id=" + pos_id + ", position=" + position + "]";
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


public String getPosition() {
	return position;
}


public void setPosition(String position) {
	this.position = position;
}


}