package com.revature.pojo;

import com.revature.abstracts.Clothes;

public class Shirt extends Clothes {
	private int sleeveLength;
	private String occassion;
	public boolean hasButtons;
	
	/*
	 * everytiem you create a new instance variable like isFluff
	 * 	-do you need to add another constructor that takes isFluffy
	 * 	- do you need getters and setters
	 * 	- do you need to update your toString()?
	 */
	
	
	
	public Shirt() {
		
	}
	
	
	public Shirt(int sleeveLength, String occassion, boolean hasButtons) {
		super();
		this.sleeveLength = sleeveLength;
		this.occassion = occassion;
		this.hasButtons = hasButtons;
	}


	public int getSleeveLength() {
		return sleeveLength;
	}


	public void setSleeveLength(int sleeveLength) {
		this.sleeveLength = sleeveLength;
	}


	public String getOccassion() {
		return occassion;
	}


	public void setOccassion(String occassion) {
		this.occassion = occassion;
	}


	@Override
	public String toString() {
		return "Shirt [sleeveLength=" + sleeveLength + ", occassion=" + occassion + ", hasButtons=" + hasButtons + "]";
	}




	
	
	

}
