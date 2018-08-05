package com.ex.store;

/**
<<<<<<< HEAD
  * @author USER
  * 
  *  The screen interface defines one method start().  All screens that implement this interface
  *  will then run that method and return the next screen to transition to.
  */

public interface Screen {
	Screen start();
	
	// implicit public abstract
	// so equivalent to
	// public abstract Screen start();
}
