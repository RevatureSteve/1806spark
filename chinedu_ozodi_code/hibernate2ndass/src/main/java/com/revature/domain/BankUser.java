package com.revature.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Table(name="USERS")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class BankUser implements Serializable {
	
	@Id
	@Column(name="users_id")
	private int usersId;
	@Column(name="fname")
	private String fName;
	@Column(name="lname")
	private String lName;
	private String username;
	private String password;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="ACCOUNT_NUMBER")
	private List<BankAccount> bankAccounts;
	
	public BankUser() {
	}
	

	/**
	 * @param usersId
	 * @param fName
	 * @param lName
	 * @param username
	 * @param password
	 */
	public BankUser(int usersId, String fName, String lName, String username, String password) {
		super();
		this.usersId = usersId;
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
	}

	

	/**
	 * @param usersId
	 * @param fName
	 * @param lName
	 * @param username
	 * @param password
	 * @param bankAccounts
	 */
	public BankUser(int usersId, String fName, String lName, String username, String password,
			List<BankAccount> bankAccounts) {
		super();
		this.usersId = usersId;
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
		this.bankAccounts = bankAccounts;
	}

	

	public List<BankAccount> getBankAccounts() {
		return  bankAccounts;
	}


	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}


	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "BankUser [usersId=" + usersId + ", fName=" + fName + ", lName=" + lName + ", username=" + username
				+ ", password=" + password + ", bankAccount=" + bankAccounts + "]";
	}	

}
