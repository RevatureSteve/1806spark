package com.revature.threads;

public class threadsExample {
	
	/*
	 * What is a thread?
	 * individual task, process
	 * Each thread in java gets its own memory stack
	 * that all have access to the same HEAP
	 * 
	 * Multithreading....multiple threads running in a single application
	 * 
	 * How do we create threads in Java?
	 * 2 ways!
	 * 
	 * Create a class that
	 *  1. -extends Thread class, then override the run method
	 *    			Then create an instance of the child thread and call .start()
	 * 	2. -implements Runnable then again override the run method
	 * 				Then create an instance of the run class that implements Runnable
	 * 				and create an instance of Thread with the Runnable as the constructor argument
	 * 				and finally call .start()
	 * 				
	 * Which is the better way and why?
	 * Use Runnable if you are only trying to provide code to run on a new thread
	 * because you do not want to waste your only extends 
	 * 
	 * Use Thread if you are changing Threads in general like the way they start up or terminate ect which you probably wont ever do...
	 * 
	 * 2 important methods of a thread
	 * 		-run() contains the code to execute; never call/invoke the run()
	 * 		-start() creates the new thread, invoke run() on the new thread, terminates the thread
	 * 
	 * 	Cannot control when a thread will execute over another thread in Java
	 * Starvation: when a thread is waiting for processing time and not getting it
	 * Deadlock:
	 * e.g. Threads A and B
	 * A has resource X
	 * B has resource Y
	 * A also needs resource y to finish
	 * B also needs resource x to finish.. neither can finish because both are waiting for other
	 * 
	 * 
	 * Life cycle of a Thread
	 * -new
	 * -runnable (can be running)
	 * -waiting
	 * -timed waiting
	 * -terminated
	 * 
	 */
	
	public static void main(String[] args) {
		System.out.println("Threads...");
		
		Thread t1 = new ChildThread(); //ChildThread actually had implementation for the run method
		//t1.run();//when calling the run() I will execute it on the SAME thread....not a new one
		t1.start();//start() will call/invoke the run() when ready
		
		Runnable ehr = new EmailHr();
		Thread t2 = new Thread(ehr);
		t2.start();
		for(int i = 0; i < 10; i++) {
			System.out.println("Current Thread" + Thread.currentThread() + "i: " + i);
		}
	}

}
