package com.advanced.drake;

public class ThickCrustTop extends ThickCrust {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6711314553568305602L;

	public ThickCrustTop(int numberOfToppings) {
		
		super();
		isPlain = false;
		this.numberOfToppings = numberOfToppings;
		System.out.println("thick crust w/ " + numberOfToppings + " toppings chosen");
		
	}

}
