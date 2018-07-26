package com.ex.store;

/*
 * The screen interface defines one method start(). All screens that implement this interface will implement 
 * that method and return the next screen to transition to. 
 */
public interface Screen {
	

	Screen start(); //public abstract is implicit in the beginning

}
