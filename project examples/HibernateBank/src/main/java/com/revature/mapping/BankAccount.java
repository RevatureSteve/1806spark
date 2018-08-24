package com.revature.mapping;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="bank_account")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class BankAccount {
	
	@Id
	@Column(name="account_number")
	@SequenceGenerator(sequenceName="newaccnum", name="newaccnum")
	@GeneratedValue(generator="newaccnum",
			strategy=GenerationType.SEQUENCE)
	private int accNum;
	
	@OneToMany(mappedBy="ba", fetch=FetchType.EAGER)
	private Set<BankTx> tx = new HashSet<BankTx>();
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "users_id")
	private BankUser user;
	
	
	@Column(name= "balance")
	private String balance;


	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BankAccount(int accNum, Set<BankTx> tx, BankUser user, String balance) {
		super();
		this.accNum = accNum;
		this.tx = tx;
		this.user = user;
		this.balance = balance;
	}


	public int getAccNum() {
		return accNum;
	}


	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}


	public Set<BankTx> getTx() {
		return tx;
	}


	public void setTx(Set<BankTx> tx) {
		this.tx = tx;
	}


	public BankUser getUser() {
		return user;
	}


	public void setUser(BankUser user) {
		this.user = user;
	}


	public String getBalance() {
		return balance;
	}


	public void setBalance(String balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "BankAccount [accNum=" + accNum + ", tx=" + tx + ", user=" + user + ", balance=" + balance + "]";
	}
	
	
	
	
	
	

}
