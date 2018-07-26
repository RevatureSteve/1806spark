package com.ex.store;

<<<<<<< HEAD
public interface Screen {
	
	
	 /*
	  * the screen interface defines one method start();
	 all screens that implement this interface will
	 then run that method and return the next screen
	 to transition to
	 .*/
	
	Screen start();
	
=======
/**
 * 
 * @author USER
 *
 *	The screen inteface defines one method start(). All screens that implement this interface
 *	will implement that method and retun the next screen to transition to. 
 */
public interface Screen {
	Screen start();
	
	// implicit public abstract
	// so equivalent to
	// public abstract Screen start();
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
}
