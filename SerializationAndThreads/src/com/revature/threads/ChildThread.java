package com.revature.threads;

public class ChildThread extends Thread{

	@Override
	public void run() {
		//This is the code that will execute when creating a new thread
		for(int j = 0; j < 10; j++) {
			System.out.println("\t\t" + Thread.currentThread() + "j: " + j);
		}
	
	}
	
	
	
}
