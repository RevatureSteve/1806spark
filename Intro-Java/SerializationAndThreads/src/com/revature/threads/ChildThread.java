package com.revature.threads;

public class ChildThread extends Thread{
<<<<<<< HEAD
=======

>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	
	@Override
	public void run() {
		// this is the code that will execute when creating a new thread
<<<<<<< HEAD
		for (int j = 0; j < 10; j++) {
			
			System.out.println("\t\t" + Thread.currentThread() +  " j:" + j);
		}
		
	}
=======
		for(int j = 0; j < 10; j++) {
			System.out.println("\t\t " + "ChildThread" + " j:" + j);
		}
	
	}
	
	
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
}
