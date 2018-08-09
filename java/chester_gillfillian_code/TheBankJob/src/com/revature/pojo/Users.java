/**
 * 
 */
package com.revature.pojo;

import java.io.Serializable;

/**
 * @author sethc
 *
 */
public class Users implements Serializable {


	private int usersId;

	private String username;

	private String password;

	private String firstname;

	private String lastname;
	private static Users userSingleton;  // this is the singleton that you will call 
	
	private Users() {
		//no-args constructor
	}
	
	public static Users getInstance() { // Users is the return type and getInstance is teh variable
		if(userSingleton == null) {
			userSingleton = new Users();
			
		}
		
		return userSingleton;
		
	}
	

	/**
	 * @param usersId
	 * @param username
	 * @param password
	 * @param firstname
	 * @param lastname
	 */
	public Users(int usersId, String username, String password, String firstname, String lastname) {
		super();
		this.usersId   =  usersId;
		this.username  =  username;
		this.password  =  password;
		this.firstname =  firstname;
		this.lastname  =  lastname;
	}




	/**
	 * @return the usersId
	 */
	public int getUsersId() {
		return usersId;
	}

	/**
	 * @param usersId the usersId to set
	 */
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + "]";
	}

	
	
	
	
	

}
