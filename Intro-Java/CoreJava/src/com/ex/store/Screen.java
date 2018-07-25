package com.ex.store;

<<<<<<< HEAD
/*
 * The screen interface defines one method start(). All screens that implement this interface will implement 
 * that method and return the next screen to transition to. 
 */
public interface Screen {
	

	Screen start(); //public abstract is implicit in the beginning

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
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
}
