package com.revature.pogo;

import java.io.Serializable;
import java.util.List;

/**
 * Users Class will be modeled after a table in the database.
 * Each state will represent a field in the database. 
 * (pretty much a variable will be a column in the database)
 * 
 * 
 * @author Alex Moraga
 *
 */

public class Users implements Serializable {
	
	// States
	private int u_Id; // PRIMARY KEY
	private String email;
	private String password;
	private String fname;
	private String lname;
	private int pos_Id; // FOREIGN KEY
	
	
	// This list is to grab reimbursement submissions for the User
	private List<Reimbursement> userReimbursement;
	
	// no-args constructor
	public Users() {
		super();
	}

	
	// constructors w/parameters (overloading)
	public Users(int u_Id, String email, String password, String fname, String lname, int pos_Id) {
		super();
		this.u_Id = u_Id;
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.pos_Id = pos_Id;
	}
	
	// Constructor with userReimbursement 
	public Users(int u_Id, String email, String password, String fname, String lname, int pos_Id,
			List<Reimbursement> userReimbursement) {
		super();
		this.u_Id = u_Id;
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.pos_Id = pos_Id;
		this.userReimbursement = userReimbursement;
	}

	// setter & getters 
	
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

	public int getPos_Id() {
		return pos_Id;
	}

	public void setPos_Id(int pos_Id) {
		this.pos_Id = pos_Id;
	}

	@Override
	public String toString() {
		return "Users [u_Id=" + u_Id + ", email=" + email + ", password=" + password + ", fname=" + fname + ", lname="
				+ lname + ", pos_Id=" + pos_Id + "]";
	}
	
}
