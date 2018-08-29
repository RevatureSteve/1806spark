package com.revature.domain;

public class Position {
	
	private int pId;
	private String p_name;
	
	
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Position(int pId, String p_name) {
		super();
		this.pId = pId;
		this.p_name = p_name;
	}
	
	
	public int getpId() {
		return pId;
	}
	
	
	public void setpId(int pId) {
		this.pId = pId;
	}
	
	
	public String getP_name() {
		return p_name;
	}
	
	
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	
	

}
