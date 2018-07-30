package com.revature.monday;

public class DancingTh implements Runnable {
	
	@Override
	public void run() {
		// again the run method is the code that runs on a new thread
		for(int b = 0; b < 10; b++) {
			System.out.println("\t\t\t\t " + Thread.currentThread() + " b:" + b);
		}
		
	}

}
