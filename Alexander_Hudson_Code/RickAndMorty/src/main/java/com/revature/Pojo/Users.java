package com.revature.Pojo;

public class Users {
	
	private int u_Id;
	private String email;
	private String passWord;
	private String fName;
	private String lName;
	private int pos_Id;
	
	
	
	public Users(int u_Id, String email, String passWord, String fName, String lName, int pos_Id) {
		super();
		this.u_Id = u_Id;
		this.email = email;
		this.passWord = passWord;
		this.fName = fName;
		this.lName = lName;
		this.pos_Id = pos_Id;
	}
	
	
	
	public Users(String passWord) {
		super();
		this.passWord = passWord;
	}



	public Users () {}
	
	public int getU_Id() {
		return u_Id;
	}
	public void setU_Id(int u_Id) {
		this.u_Id = u_Id;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	
	public int getPos_Id() {
		return pos_Id;
	}
	public void setPos_Id(int pos_Id) {
		this.pos_Id = pos_Id;
	}
	
	
	@Override
	public String toString() {
		return "Users [u_Id=" + u_Id + ", email=" + email + ", passWord=" + passWord + ", fName=" + fName + ", lName="
				+ lName + ", pos_Id=" + pos_Id + "]";
	}
	
	
	

}
