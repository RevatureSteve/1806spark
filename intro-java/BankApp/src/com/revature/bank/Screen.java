package com.revature.bank;

import com.revature.bank.Screen;

/*
 * @author Richard-Iskra
 * 
 * The screen interface defines one method start(); all screens that implement this interface will
 * then implement that method and return the next screen to transition to.
 */
public interface Screen {
	Screen start();
	
	//implicit public abstract
}