package com.revature.abstracts;

import com.revature.exceptions.NegativeArgumentException;

public class Clothes {
	
	public String brand;
	private String material;
	private int cost;
		
	public Clothes() {
		
	}

	public Clothes(String brand, String material, int cost) {
		super();
		this.brand = brand;
		this.material = material;
		this.cost = cost;
	}


	public int getCost() {
		return cost;     //removed this.
	}
	
	
	
	public void setCost(int cost)  {  
		if(cost < 0) {
//			this.cost = 0;
			throw new NegativeArgumentException("Stop that");
		}else {
		this.cost = cost;
	}
	}	
	
	
	public String getMaterial() {
		return material;
	}
	
//	public void setMaterial
	
	
	
	
}