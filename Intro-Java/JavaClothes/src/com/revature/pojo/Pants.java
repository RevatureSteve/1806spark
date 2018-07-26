package com.revature.pojo;

import com.revature.abstracts.Clothes;

public class Pants extends Clothes {
	
	public int lenght;
	private int waist;
	private String color;
	
	
	
	
	public Pants() {
		super();
	}




	public Pants(int lenght, int waist, String color) {
		super();
		this.lenght = lenght;
		this.waist = waist;
		this.color = color;
	}

	
	



	public int getLenght() {
		return lenght;
	}




	public void setLenght(int lenght) {
		this.lenght = lenght;
	}




	public int getWaist() {
		return waist;
	}




	public void setWaist(int waist) {
		this.waist = waist;
	}




	public String getColor() {
		return color;
	}




	public void setColor(String color) {
		this.color = color;
	}




	@Override
	public String toString() {
		return "Pants [lenght=" + lenght + ", waist=" + waist + ", color=" + color + "]";
	}
	
	

	
	
}
