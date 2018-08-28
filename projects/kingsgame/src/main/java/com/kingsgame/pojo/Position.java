package com.kingsgame.pojo;

public class Position {

private int pos_id;
private String pos_type;
public int getPos_id() {
	return pos_id;
}
public void setPos_id(int pos_id) {
	this.pos_id = pos_id;
}
public String getPos_type() {
	return pos_type;
}
public void setPos_type(String pos_type) {
	this.pos_type = pos_type;
}
public Position(int pos_id, String pos_type) {
	super();
	this.pos_id = pos_id;
	this.pos_type = pos_type;
}
@Override
public String toString() {
	return "Position [pos_id=" + pos_id + ", pos_type=" + pos_type + "]";
}
	
	
}
