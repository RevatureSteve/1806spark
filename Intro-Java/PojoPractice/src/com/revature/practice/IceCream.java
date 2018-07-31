package com.revature.practice;

public class IceCream implements Dessert {

	private String flavor;
	public boolean sprinkles;
	private int numberOfScoops;
	
	
	public IceCream() {
		super();
	}


	public IceCream(String flavor, boolean sprinkles, int numberOfScoops) {
		super();
		this.flavor = flavor;
		this.sprinkles = sprinkles;
		this.numberOfScoops = numberOfScoops;
	}


	public String getFlavor() {
		return flavor;
	}


	public void setFlavor(String flavor) throws NoNull {
		if (flavor == null) {
			throw new NoNull();
		}
		this.flavor = flavor;
	}


	public int getNumberOfScoops() {
		return numberOfScoops;
	}


	public void setNumberOfScoopes(int numberOfScoops) {
		if(numberOfScoops < 0) {
			throw new NoNegativeNumber();
			
		}
		this.numberOfScoops = numberOfScoops;
	}


	@Override
	public String toString() {
		return "[ Flavor= " + this.flavor + " Sprinkles= " + this.sprinkles + " Number Of Scoops= " 
	+ this.numberOfScoops + "]";
	}


	@Override
	public void placeInHolder() {
		System.out.println("put on cone");
		
	}
	
	
	
	

}
