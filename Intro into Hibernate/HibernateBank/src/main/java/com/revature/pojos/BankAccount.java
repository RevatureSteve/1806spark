package com.revature.pojos;


import javax.persistence.Cacheable;
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
import javax.persistence.CascadeType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Entity;

@Entity 
@Table(name="BANK_ACCT")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable

public class BankAccount {
	
	@Id
	@Column
	@SequenceGenerator(sequenceName="ACC_SEQ", name="ACC_SEQ")
	@GeneratedValue(generator="ACC_SEQ", 
		strategy=GenerationType.SEQUENCE)
	private int acctID;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BANK_TXT")
	private BankTxtType txtId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BANK_TXT_TYPE")
	private BankTxtType txtTypeId;
	
	@Column
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BANK_USER")
	private BankUser userId;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PARENT_CUB", 
		joinColumns=@JoinColumn(name="BEAR_ID"), 
		inverseJoinColumns=@JoinColumn(name="CUB_ID"))
	
@Column
private double balance;


	
	
	
	
	
	
	
	

}
