package com.revature.threads;

public class EmailHr implements Runnable{

<<<<<<< HEAD
	@Override
	public void run() {
		// again the run method is the code that runs on a new thread
		
		for (int k = 0; k < 10; k++) {
			System.out.println("\t\t\t\t" + Thread.currentThread() + " k:" + k);
		}
	}
	
	
=======
	
	@Override
	public void run() {
		// again the run method is the code that runs on a new thread
		for(int k = 0; k < 10; k++) {
			System.out.println("\t\t\t\t " + "EmailHr" + " k:" + k);
		}
	}
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8

}
