package com.revature.pojo;

import com.revature.abstracts.Sandwish;


//two way to fix one way to make the class abstract
// or override the parents
	
public class Club extends Sandwish{
	
	//state
	private boolean istoasted;
	private int numberOfToothpicks;
	// protected int size; we inherited this property as size is protected in the 


	// all pojo need to have NO-ARGS CONSTRUCTORS
	public Club() {
		//NO-Args
	}
	
  @Override
public int TakeBite(int biteSize) {
	  
	// TODO Auto-generated method stub
	  System.out.println("Taking a bite of the club");
	return this.size;
}
	
	@Override
	public void prepping() {
		// TODO Auto-generated method stub
		System.out.println(" club is being made, will toast");
		
	}
	
	

}
