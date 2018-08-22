package com.revature.threads;

public class EmailHr implements Runnable{

<<<<<<< HEAD
	
	@Override
	public void run() {
		// again the run method is the code that runs on a new thread
		for(int k = 0; k < 10; k++) {
			System.out.println("\t\t\t\t " + "EmailHr" + " k:" + k);
=======
	@Override
	public void run() {
		// the run method is the code that runs on a new thread
		for(int k = 0; k < 10; k++) {
			System.out.println("\t\t\t\t "+ "EmailHr" + " k:" + k);
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
		}
	}

}
