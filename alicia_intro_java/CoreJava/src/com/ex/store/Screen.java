package com.ex.store;

public interface Screen {
	

	
	
/*
 *  The screen interface defines one method start(). All screens implement this interface 
 *  will implement that method and return the next screen to transition to.
 */
	Screen start();
//	implicit public abstract
//	so equivalent to 
//	public abstract Screen start();
}
