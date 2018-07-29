package com.revature.threads;

public class EmailHr implements Runnable{

	@Override
	public void run() {
		//again the run method is the code that runs on a new thread
		for(int k = 0; k<10; k++) {
			System.out.println("\t\t\t\t "+ Thread.currentThread());
		}
	}
	
}
