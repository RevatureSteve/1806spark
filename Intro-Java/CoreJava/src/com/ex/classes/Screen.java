package com.ex.classes;

public interface Screen {

// The public abstract is implicit before screen
// The screen interface defines one method start(); all screens that implement Screen will implement that method
// Equivalent to public abstract Screen start();
	
	Screen start();

}
