package com.kingsgame.pojo;

public class Type {

	private int rq_type_id;
	private String rq_type;
	public Type(int rq_type_id, String rq_type) {
		super();
		this.rq_type_id = rq_type_id;
		this.rq_type = rq_type;
	}
	public int getRq_type_id() {
		return rq_type_id;
	}
	public void setRq_type_id(int rq_type_id) {
		this.rq_type_id = rq_type_id;
	}
	public String getRq_type() {
		return rq_type;
	}
	public void setRq_type(String rq_type) {
		this.rq_type = rq_type;
	}
	
}
