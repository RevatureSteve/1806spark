package com.revature.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	
	private int userId;
	private int positionId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	
	//	additional property I probably will need here (not a field/attribute in the data)
	//	I know users will have multiple tasks...probably use a Collection or Array to hold them
		private List<Reimbursement> userReimburse;
	
	public User() {}

	public User(int userId, int positionId, String email, String password, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.positionId = positionId;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", positionId=" + positionId + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public List<Reimbursement> getUserReimburse() {
		return userReimburse;
	}

	public void setUserReimburse(List<Reimbursement> userReimburse) {
		this.userReimburse = userReimburse;
	}

}
