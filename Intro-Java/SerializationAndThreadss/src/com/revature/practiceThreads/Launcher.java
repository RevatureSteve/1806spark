package com.revature.practiceThreads;


// I am going to create a new thread
/*
 *  To create a new thread
 *   	- class extends thread override run(); OR..... implements runnable
 *   
 *   The .start() method belongs to thread class
 *   the .start() method will invoke/call the run() method
 * 
 * 
 * 
 */



public class Launcher {
	
	public static void main(String[] args) {
		
		
		
		Runnable me = new myPracticeThread();
		Thread runner = new Thread(me);
		
		runner.start();
		
		for (int i = 0; i< 10; i++) {
			System.out.println("Main thread " + i);
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
