package com.revature.pojo;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="USER")
public class BankUserPojo {
	
	@Id
	@Column(name="U_ID")
	@SequenceGenerator(sequenceName="UID_SEQ", name="UID_SEQ")
	@GeneratedValue(generator="UID_SEQ", 
		strategy=GenerationType.SEQUENCE)
	
	private int uid;
	
	@Column
	private String fname;
	
	@Column
	private String lname;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	BankUserPojo (){}

	public BankUserPojo(String fname, String lname, String username, String password, int uid) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.uid = uid;
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "BankUser [fname=" + fname + ", lname=" + lname + ", username=" + username + ", password=" + password
				+ ", uid=" + uid + "]";
	}
	
	
	
	

}
