package com.advanced.drake;

public class ChicagoTop extends Chicago {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4286102507856702323L;

	public ChicagoTop(int numberOfToppings) {
		
		super();
		isPlain = false;
		this.numberOfToppings = numberOfToppings;
		System.out.println("Chicago style w/ " + this.numberOfToppings + " toppings chosen");
		
	}

}
