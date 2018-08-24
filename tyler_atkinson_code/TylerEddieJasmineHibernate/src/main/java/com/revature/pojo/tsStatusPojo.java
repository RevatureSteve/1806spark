package com.revature.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ts_status")
public class tsStatusPojo {
	
	@Id
	@Column(name = "TS_ID")
	private int tsId;
	@Column(name = "TS_LEVEL")
	private String tsLevel;
	
	
	public tsStatusPojo () {}


	public tsStatusPojo(int tsId, String tsLevel) {
		super();
		this.tsId = tsId;
		this.tsLevel = tsLevel;
	}


	public int getTsId() {
		return tsId;
	}


	public void setTsId(int tsId) {
		this.tsId = tsId;
	}


	public String getTsLevel() {
		return tsLevel;
	}


	public void setTsLevel(String tsLevel) {
		this.tsLevel = tsLevel;
	}


	@Override
	public String toString() {
		return "tsStatusPojo [tsId=" + tsId + ", tsLevel=" + tsLevel + "]";
	}
	
	

}
