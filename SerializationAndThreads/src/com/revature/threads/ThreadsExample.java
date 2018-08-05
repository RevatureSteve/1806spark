package com.revature.threads;

public class ThreadsExample {
	
	
	/*
	 *  	What is a thread?
	 *  		individual task, process
	 *  	Each thread in java gets its own Memory Stack
	 *  		that all have access to the same HEAP
	 *  
	 *  	Multithreading... multiple threads in a single application
	 *  
	 *  	How do we create threads in Java?
	 *  		2 ways!
	 *  		Create a class that 
	 *  			1. extends Thread class then override the run()
	 *  					Then create an instance of the child thread and call .start()
	 *  			2. implements Runnable then again override the run()
	 *  					Then create an instance of the class that implements Runnable
	 *  					and create an instance of Thread with the Runnable as the constructor argument
	 *  					and finally call .start()
	 *  
	 *  		Which is the better way and why?
	 *  			Use Runnable if you are only trying to provide code to run on a new thread
	 *  				because you don't want to waste your only extends
	 *  			
	 *  			Use Thread if you are changing Threads in general like the way they start up 
	 *  				or terminate etc which you probably won't ever do...
	 *  
	 *  	2 important methods of a thread
	 *  			-run() contains the code to execute
	 *  			-start() contains the thread, invoke run() on the new thread, terminates the thread
	 *  
	 *  	Cannot control when a thread will execute over another thread in Java
	 *  		But I can try...
	 *  
	 *  
	 *  	Starvation: when a thread is waiting for processing time (execute) and not getting it
	 *  			Not usually an issue in Java
	 *  	Deadlock: 
	 *  		
	 *  		e.g. 2 Thread A and B
	 *  			A has resource X locked (in use)
	 *  			B has resource Y
	 *  			
	 *  			A also needs resource y to finish
	 *  			B also needs resource x to finish... neither can finish because both are waiting for the other
	 *  
	 *  			resource could be a method or the console
	 *  
	 *  
	 *  	Synchronized keyword: makes a method Thread sage... meaning only one thread can access it at a time 
	 *  
	 *  
	 *  	Life cycle of a Thread (states)
	 *  		- new
	 *  		- runnable (can be running)
	 *  		- timed waiting
	 *  		- waiting
	 *  		- terminated (dead)
	 *  
	 *  	
	 *  
	 */
	public static void main(String[] args) {
//		System.out.println("threads...");
		
		Thread t1 = new ChildThread(); // ChildThread actually had implementation for the run method
//		t1.run(); // when calling the run() I will execute it on the SAME thread... not a new one
		t1.setPriority(1); // 1 - 10, 10 is the highest priority, 1 is low but hardly makes a difference.
		t1.start(); // start() will call/invoke the run() when ready
		
		Runnable ehr = new EmailHr();
		Thread t2 = new Thread(ehr);
		t2.setPriority(10);
		t2.start();
		
//		Thread.sleep(millis, nanos);  // example of timed waiting
		for (int i = 0; i < 10; i++) {
			System.out.println("Current Thread " + Thread.currentThread() + " i:" + i);
		}
	}
}
