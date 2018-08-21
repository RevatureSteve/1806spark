package com.revature.domain;


public class Users  {
	
private int UId;
private String email;
private String password;
private String fname;
private String lname;
private int posId;
private String posType;


public Users() {
	super();
}




public Users(int uId, String email, String password, String fname, String lname) {
	super();
	UId = uId;
	this.email = email;
	this.password = password;
	this.fname = fname;
	this.lname = lname;
}

public Users(int uId, String email, String password, String fname, String lname, int posId, String posType) {
	super();
	UId = uId;
	this.email = email;
	this.password = password;
	this.fname = fname;
	this.lname = lname;
	this.posId = posId;
	this.posType = posType;
}




public int getUId() {
	return UId;
}




public void setUId(int uId) {
	UId = uId;
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
	return "Users [UId=" + UId + ", email=" + email + ", password=" + password + ", fname=" + fname + ", lname=" + lname
			+ ", posId=" + posId + ", posType=" + posType + "]";
}




	

}
