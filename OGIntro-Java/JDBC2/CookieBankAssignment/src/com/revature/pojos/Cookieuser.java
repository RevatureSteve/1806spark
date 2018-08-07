package com.revature.pojos;

public class Cookieuser {

	private static Cookieuser currentCookie = null;//any time we needthe info of the current user this will be used
	
	private int id;
	private String usename;
	private String pw;
	private String fname;
	private String lname;
	
	
	public Cookieuser() {}
	
	public Cookieuser(int id, String usename, String pw, String fname, String lname) {
		super();
		this.id = id;
		this.usename = usename;
		this.pw = pw;
		this.fname = fname;
		this.lname = lname;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
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
		return "Cookieuser [id=" + id + ", usename=" + usename + ", pw=" + pw + ", fname=" + fname + ", lname=" + lname
				+ "]";
	}

	public static Cookieuser getCurrentCookie() {
		return currentCookie;
	}

	public static void setCurrentCookie(Cookieuser currentCookie) {
		Cookieuser.currentCookie = currentCookie;
	}
	
	
	
}
