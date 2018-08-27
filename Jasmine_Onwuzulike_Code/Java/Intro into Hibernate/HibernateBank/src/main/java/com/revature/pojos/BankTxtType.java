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
@Table(name="BANK_")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable

public class BankTxtType {
	
	
	@Id
	private int txtTypeId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BANK_TXT")
	private BankTxtType txtId;
	
	
	@Column
	private String tsType;

}
