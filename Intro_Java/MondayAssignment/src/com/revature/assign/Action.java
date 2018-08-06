package com.revature.assign;

/**
 * 
 * @author Eddie
 * 
 * 		Create an interface:
 * 			-At least one abstract method, one concrete method, and one variable
 *
 */

public interface Action {
	
	/*
	 * Variable
	 */
	public String name = null;
	
	/*
	 * Abstract Method
	 */
	public void standGround();
	
	/*
	 * Concrete Method
	 */
	public default void growl() {
		
	}

}
