package com.revature.basket;
// in basket will be a template for what fruits can go inside the baske

/*
 * what should be in the basket
 * 
		 * -apple how many
		 * -banana how many and size
		 * -grape
		 * -cherry
		 * 
		 * 3 type of fruit basket
		 *  1 large fruit basket
		 *  2 medium fruit basket 
		 *  3 small fruit basket
		 * 
 * 
 */

public abstract class InBasket {
	
	//stake aka variables
	public String name;
	private int apple;
	private  int banana;
	private boolean juice;
	private int cherry;
	private int grape;


public InBasket() {
	//NO-argus constructor	
}





// behavior 
public abstract void makeBAsket();
// this is an abstract method need no-args


}