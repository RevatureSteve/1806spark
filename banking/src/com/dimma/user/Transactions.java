package com.dimma.user;

public class Transactions {

	private String txtimestamp;
	private int txid;
	private int txamt;
	private String txtype;
	private int account_number;
	
	
	public Transactions(String txtimestamp, int txid, int txamt, String txtype, int account_number) {
		super();
		this.txtimestamp = txtimestamp;
		this.txid = txid;
		this.txamt = txamt;
		this.txtype = txtype;
		this.account_number = account_number;
	}
	public String getTxtimestamp() {
		return txtimestamp;
	}
	public void setTxtimestamp(String txtimestamp) {
		this.txtimestamp = txtimestamp;
	}
	public int getTxid() {
		return txid;
	}
	public void setTxid(int txid) {
		this.txid = txid;
	}
	public int getTxamt() {
		return txamt;
	}
	public void setTxamt(int txamt) {
		this.txamt = txamt;
	}
	public String getTxtype() {
		return txtype;
	}
	public void setTxtype(String txtype) {
		this.txtype = txtype;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	@Override
	public String toString() {
		return "||TXID=" + txid + "||ON DATE=" + txtimestamp +
				  "||FOR $" + txamt + "||\n";
	}
	
	
	
	
	
	
}
