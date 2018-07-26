package com.revature.abstracts;

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

	public Clothes(String brand, int cost) {
		super();
		this.brand = brand;
		this.cost = cost;
	}
	
	
	
}