package com.ex.store;

/**
<<<<<<< HEAD
  * @author USER
  * 
  *  The screen interface defines one method start().  All screens that implement this interface
  *  will then run that method and return the next screen to transition to.
  */


=======
 * 
 * @author USER
 *
 *	The screen inteface defines one method start(). All screens that implement this interface
 *	will implement that method and retun the next screen to transition to. 
 */
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
public interface Screen {
	Screen start();
	
	// implicit public abstract
	// so equivalent to
	// public abstract Screen start();
}
