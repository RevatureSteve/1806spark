package com.revature.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class BankUser {

	@Id
	@Column(name = "USERS_ID")
	private int id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "FNAME")
	private String fname;

	@Column(name = "LNAME")
	private String lname;

	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private Set<BankAccount> ba;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public Set<BankAccount> getBa() {
		return ba;
	}

	public void setBa(Set<BankAccount> ba) {
		this.ba = ba;
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

	public BankUser(int id, String username, String password, String fname, String lname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
	}

	public BankUser() {
	}

	@Override
	public String toString() {
		return "BankUser [id=" + id + ", username=" + username + ", password=" + password + ", fname=" + fname
				+ ", lname=" + lname + ", ba=" + ba + "]";
	}

}
