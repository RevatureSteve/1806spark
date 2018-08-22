package com.revature.Pojo;

public class Position {
	
	private int pos_Id;
	private String pos_Type;
	
	
	public Position(int pos_Id, String pos_Type) {
		super();
		this.pos_Id = pos_Id;
		this.pos_Type = pos_Type;
	}


	public int getPos_Id() {
		return pos_Id;
	}


	public void setPos_Id(int pos_Id) {
		this.pos_Id = pos_Id;
	}


	public String getPos_Type() {
		return pos_Type;
	}


	public void setPos_Type(String pos_Type) {
		this.pos_Type = pos_Type;
	}


	@Override
	public String toString() {
		return "Position [pos_Id=" + pos_Id + ", pos_Type=" + pos_Type + "]";
	}
	

}
