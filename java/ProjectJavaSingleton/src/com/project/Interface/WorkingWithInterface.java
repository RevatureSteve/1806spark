package com.project.Interface;


/// interface extend to other interface
// class implement interface 
//class extend class

public interface WorkingWithInterface { // cannot instantiate . have no constructor. method are implicitly public abstract .. field/state/variable public static final 
	
	// what does final do for class it do not allow you to extend. for field/state/variable it don't allow change. for method child cannot override parents.
	
	//create some field
	//public static final don't have put it bc it already implicitly there automatically
	int someNumber = 6; // have to give a value bc it final no changes
	boolean isDead = false;
	
	
	// only used the method signatures in interface
	void helloInterface(); // method signature 
	
	boolean helloWorld(int player); // return type at front boolean 
	
	
	// this don't have a main in any interface
	// contract between parties
	
	

}
