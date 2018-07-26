package com.ex.store;

/**
 * 
 * @author Marcin Salamon
 * 
 * The screen interface defines one method start(). 
 * All screens that implements this interface will interface will implement that 
 * method and return the next screen to transition to.
 */
public interface Screen {
	Screen start();
	
	//implicit public abstract
	//equivalent to 
	//public abstract Screen start
}
