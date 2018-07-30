package com.revature.threads;

public class ThreadsExample {

	/*
	 * A Thread is a individual task , process Each thread in Java gets its own
	 * memory Stack that all have access to the same HEAP
	 * 
	 * Multithreading.. multiple threads in a single application
	 * 
	 * garbage collecting is always running and uses its own thread
	 * 
	 * How do we create threads in Java? 2 ways -extends Thread Class then create an instance of the child thread and call .start()
	 * 
	 * - implementsRunnable then again override the run()
	 * tthen create an instance of athe class that implements runnable
	 * and create an instance of thread with the runnable as the constructor argument
	 * and finally call.start()
	 * 
	 * 2 important methods of a thread -run() contains the code to execute, we never
	 * call/invoke the run() -start() creates the new thread, invokes run on the new
	 * thread, terminates the thread
	 * 
	 * you cannot control when  your threads will execute over another thread in Java
	 * .................but I can try
	 * 
	 * Starvation: when a thread is waiting for processing time and not getting it
	 * 		not usually an issue in Java
	 * 
	 * Deadlock: 
	 * 
	 * example: 2 threads A and B 
	 * 		A has resource X locked (in use)
	 * 		B has resource Y 
	 * 		
	 * 		A also needs resource y to finish
	 * 		B also needs resource x to finish.. neither can finish because both are waiting for other
	 * 
	 * 		resource could be a method or the console
	 * 
	 * Synchronize keyword- makes it thread safe
	 * thread safe- only one thread can access it at a time
	 * 
	 * Which is the better way and why?
	 * Use runnable if you are only trying to provide code to run on a new thread
	 * because you don't want to waste your only extends
	 * 
	 * Use Thread if you are changing Threads in general like the way they start up or terminate etc, which you probably wont ever do..
	 * 
	 * Lifecycle of a thread - Threads have 5 states / status  
	 * 	-new
	 * 	-runnable
	 	-waiting
	 	-timed waiting
	 * 	-terminated
	 * 
	 *
	 * 
	 * 
	 */

	public static void main(String[] args) {

		System.out.println("Threads");

		Thread t1 = new ChildThread(); // child thread actually had implementation for the run method
		// t1.run();// when calling the run() I will execute it on the same thread..not
		// a new one
		t1.start(); // start will call/invoke the run() when ready

		EmailHr ehr = new EmailHr();
		Thread t2 = new Thread(ehr);
		t2.start();
		
		//Thread.sleep(millis, nanos); // example of timed waiting
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Current thread" + "ChildThread" + "i: " + i);
		}
	}
}
