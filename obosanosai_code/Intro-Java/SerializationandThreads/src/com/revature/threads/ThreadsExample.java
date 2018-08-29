package com.revature.threads;

public class ThreadsExample {
		
		public static void main(String[] args) {
		
			
		Thread t1 = new ChildThread(); // ChildThread actually had implementation for the run method
		t1.setPriority(1); // 1 - 10, 10 is the highest priority, 1 is low but hardly makes a difference
		t1.start(); // start() will call/invoke the run() when ready
		
		
		
		Runnable ehr = new EmailHr();
	    Thread t2 = new Thread(ehr);
		t2.start();
		
		

		
		
		for(int i = 0; i < 10; i++) {
			System.out.println("Main" + "i:" + i);// static when you are accessing something that starts with a capital letter
		}
	}
	
}
