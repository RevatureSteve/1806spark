package com.revature.pojo;

public class Shirt {
	public int sleeveLength;
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




	public Shirt(int sleeveLength, String occassion) {
		super();
		this.sleeveLength = sleeveLength;
		this.occassion = occassion;
	}
	
	
	
	

}
