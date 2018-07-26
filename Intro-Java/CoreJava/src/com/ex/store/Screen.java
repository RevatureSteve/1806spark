package com.ex.store;

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
}
