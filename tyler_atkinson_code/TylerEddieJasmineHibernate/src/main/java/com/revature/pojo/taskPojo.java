
package com.revature.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="task")
public class taskPojo {
	
	
	@Id
	@Column(name = "T_ID")
	private int tId;
	@Column(name = "U_ID")
	private int uId;
	@Column(name = "T_NAME")
	private String tName;
	@Column(name = "TS_ID")
	private int tsId;
	
	
	public taskPojo () {}
	
	public taskPojo(int tId, int uId, String tName, int tsId) {
		super();
		this.tId = tId;
		this.uId = uId;
		this.tName = tName;
		this.tsId = tsId;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public int getTsId() {
		return tsId;
	}

	public void setTsId(int tsId) {
		this.tsId = tsId;
	}

	@Override
	public String toString() {
		return "taskPojo [tId=" + tId + ", uId=" + uId + ", tName=" + tName + ", tsId=" + tsId + "]";
	}

	public taskPojo(int uId, String tName, int tsId) {
		super();
		this.uId = uId;
		this.tName = tName;
		this.tsId = tsId;
	}
	

}
