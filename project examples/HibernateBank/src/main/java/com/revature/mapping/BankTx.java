package com.revature.mapping;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="bank_tx")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class BankTx {

	
		@Id
		@Column(name="tx_id")
		@SequenceGenerator(sequenceName= "A_NEW_TRANSACTION", name = "A_NEW_TRANSACTION")
		@GeneratedValue(generator= "A_NEW_TRANSACTION",
		strategy=GenerationType.SEQUENCE)
		
		private int txId;
		
		@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinColumn(name="ACCOUNT_NUMBER")
		private BankAccount ba;
		
		@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinColumn(name="TX_TYPE_ID")
		private BankTxType txType;
		
		@Column(name = "TX_TIMESTAMP")
		private String txTimestamp;
		
		@Column(name = "TX_AMT")
		private int txAmt;

		public BankTx() {
			super();
			// TODO Auto-generated constructor stub
		}

		public BankTx(int txId, BankAccount ba, BankTxType txType, String txTimestamp, int txAmt) {
			super();
			this.txId = txId;
			this.ba = ba;
			this.txType = txType;
			this.txTimestamp = txTimestamp;
			this.txAmt = txAmt;
		}

		public int getTxId() {
			return txId;
		}

		public void setTxId(int txId) {
			this.txId = txId;
		}

		public BankAccount getBa() {
			return ba;
		}

		public void setBa(BankAccount ba) {
			this.ba = ba;
		}

		public BankTxType getTxType() {
			return txType;
		}

		public void setTxType(BankTxType txType) {
			this.txType = txType;
		}

		public String getTxTimestamp() {
			return txTimestamp;
		}

		public void setTxTimestamp(String txTimestamp) {
			this.txTimestamp = txTimestamp;
		}

		public int getTxAmt() {
			return txAmt;
		}

		public void setTxAmt(int txAmt) {
			this.txAmt = txAmt;
		}

		@Override
		public String toString() {
			return "BankTx [txId=" + txId + ", ba=" + ba + ", txType=" + txType + ", txTimestamp=" + txTimestamp
					+ ", txAmt=" + txAmt + "]";
		}

		
		
		
}
