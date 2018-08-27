package com.revature.pojos;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Entity;

@Entity 
@Table(name="BANK_TXT")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class BankTxt {
	@Id
	private int txtId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BANK_USER")
	private BankUser userId;
	
	
	
	
	
	@Column
	private String timeSubmitted;
	@Column
	private double amount;
	
	@Column
	private int txtTypeId;

}
