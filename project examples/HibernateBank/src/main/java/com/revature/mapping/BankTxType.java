package com.revature.mapping;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "BANK_TX_TYPE")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable

public class BankTxType {

	@Id
	@Column(name="TX_TYPE_ID")
	private int txTypeId;
	
	@OneToMany(mappedBy = "txType", fetch = FetchType.EAGER)
	private Set<BankTx> tx = new HashSet<BankTx>();

	public BankTxType(int txTypeId, Set<BankTx> tx) {
		super();
		this.txTypeId = txTypeId;
		this.tx = tx;
	}

	public BankTxType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTxTypeId() {
		return txTypeId;
	}

	public void setTxTypeId(int txTypeId) {
		this.txTypeId = txTypeId;
	}

	public Set<BankTx> getTx() {
		return tx;
	}

	public void setTx(Set<BankTx> tx) {
		this.tx = tx;
	}

	@Override
	public String toString() {
		return "BankTxType [txTypeId=" + txTypeId + ", tx=" + tx + "]";
	}
	
	
	
}
