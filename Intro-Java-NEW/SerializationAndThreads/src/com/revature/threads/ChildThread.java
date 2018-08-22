package com.revature.threads;

<<<<<<< HEAD
public class ChildThread extends Thread{

	
	@Override
	public void run() {
		// this is the code that will execute when creating a new thread
		for(int j = 0; j < 10; j++) {
			System.out.println("\t\t " + "ChildThread" + " j:" + j);
		}
	
	}
	
	
=======
public class ChildThread extends Thread {

	@Override
	public void run() {
		// This is the code that will run execute when creating a new thread
		for(int j = 0; j < 10; j++) {
			System.out.println("\t\t " + "ChildThread" + " j: " + j);
		}
	}
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
}
