package com.revature.pojos;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity 
@Table(name="BANK_USER")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable

public class BankUser {
	@Id
	@Column
	@SequenceGenerator(sequenceName="USER_SEQ", name="USER_SEQ")
	@GeneratedValue(generator="USER_SEQ", 
		strategy=GenerationType.SEQUENCE)
	private int userID;
	
	@Column
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="BANK_ACCT")
	private BankAccount acctId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BANK_TXT")
	private BankTxt txtId;
	

	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PARENT_CUB", 
		joinColumns=@JoinColumn(name="BEAR_ID"), 
		inverseJoinColumns=@JoinColumn(name="CUB_ID"))
	
	private BankTxtType typeId;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String firstname;
	
	@Column
	private String lasname;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}


	public BankTxtType getTypeId() {
		return typeId;
	}

	public void setTypeId(BankTxtType typeId) {
		this.typeId = typeId;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLasname() {
		return lasname;
	}

	public void setLasname(String lasname) {
		this.lasname = lasname;
	}

	@Override
	public String toString() {
		return "BankUser [userID=" + userID + ", typeId=" + typeId + ", username=" + username + ", password=" + password
				+ ", firstname=" + firstname + ", lasname=" + lasname + "]";
	}

	
	
	
	

}
