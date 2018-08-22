package com.revature.Pojo;

public class Rq_Status {
	
	private int rq_Status_Id;
	private String rq_Type;
	
	
	public Rq_Status(int rq_Status_Id, String rq_Type) {
		super();
		this.rq_Status_Id = rq_Status_Id;
		this.rq_Type = rq_Type;
	}
	
	
	public int getRq_Status_Id() {
		return rq_Status_Id;
	}
	public void setRq_Status_Id(int rq_Status_Id) {
		this.rq_Status_Id = rq_Status_Id;
	}
	
	
	public String getRq_Type() {
		return rq_Type;
	}
	public void setRq_Type(String rq_Type) {
		this.rq_Type = rq_Type;
	}


	@Override
	public String toString() {
		return "Rq_Status [rq_Status_Id=" + rq_Status_Id + ", rq_Type=" + rq_Type + "]";
	}
	
	
	
	

}
