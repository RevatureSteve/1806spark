package com.revature.Pojo;

public class Rq_Type {
	
	
	private int rq_Type_Id;
	private String rq_Type;
	
	
	public Rq_Type(int rq_Type_Id, String rq_Type) {
		super();
		this.rq_Type_Id = rq_Type_Id;
		this.rq_Type = rq_Type;
	}


	public int getRq_Type_Id() {
		return rq_Type_Id;
	}


	public void setRq_Type_Id(int rq_Type_Id) {
		this.rq_Type_Id = rq_Type_Id;
	}


	public String getRq_Type() {
		return rq_Type;
	}


	public void setRq_Type(String rq_Type) {
		this.rq_Type = rq_Type;
	}


	@Override
	public String toString() {
		return "Rq_Type [rq_Type_Id=" + rq_Type_Id + ", rq_Type=" + rq_Type + "]";
	}
	
	
	

}
