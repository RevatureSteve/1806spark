package com.revature.pojos;

public class Users {
	
	private int empId;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private int positionId;
	
	
	public Users() {
	}


	public Users( String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public Users(int empId, String firstname, String lastname) {
		super();
		this.empId = empId;
		this.firstname = firstname;
		this.lastname = lastname;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
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


	public int getPositionId() {
		return positionId;
	}


	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}


	@Override
	public String toString() {
		return "Users [empId=" + empId + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", positionId=" + positionId + "]";
	}
	
	

}
