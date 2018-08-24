package com.revature.domain;


public class Users  {
	
private int u_id;
private String email;
private String password;
private String fname;
private String lname;
private int posId;
private String posType;


public Users() {
	super();
}




public Users(int u_id, String email, String password, String fname, String lname) {
	super();
	this.u_id = u_id;
	this.email = email;
	this.password = password;
	this.fname = fname;
	this.lname = lname;
}

public Users(int u_id, String email, String password, String fname, String lname, int posId, String posType) {
	super();
	this.u_id = u_id;
	this.email = email;
	this.password = password;
	this.fname = fname;
	this.lname = lname;
	this.posId = posId;
	this.posType = posType;
}




public int getu_id() {
	return u_id;
}




public void setu_id(int u_id) {
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




public int getPosId() {
	return posId;
}




public void setPosId(int posId) {
	this.posId = posId;
}




public String getPosType() {
	return posType;
}




public void setPosType(String posType) {
	this.posType = posType;
}




@Override
public String toString() {
	return "Users [u_id=" + u_id + ", email=" + email + ", password=" + password + ", fname=" + fname + ", lname=" + lname
			+ ", posId=" + posId + ", posType=" + posType + "]";
}




	

}
