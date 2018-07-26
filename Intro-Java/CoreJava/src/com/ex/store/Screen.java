package com.ex.store;

/**
 * 
<<<<<<< HEAD
<<<<<<< HEAD
 * 	@author USER
 * 
 * 	The screen interface defines one method start(). All screens that implement this interface
 * 	will implement that method and return the next screen to transition to
=======
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
 * @author USER
 *
 *	The screen inteface defines one method start(). All screens that implement this interface
 *	will implement that method and retun the next screen to transition to. 
<<<<<<< HEAD
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
 */
public interface Screen {
	Screen start();
	
	// implicit public abstract
	// so equivalent to
	// public abstract Screen start();
}
