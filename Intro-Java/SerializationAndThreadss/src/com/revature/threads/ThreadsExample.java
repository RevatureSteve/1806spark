package com.revature.threads;

public class ThreadsExample {
	
	
	/*
	 * What is a thread?
	 *  -Individual task,process
	 *  
	 *  Each thread in Java gets it's own memory stack
	 * 			that all have access to the same HEAP
	 * 
	 * 
	 * 	Multithreading... multiple threads in a single application
	 * 
	 * 
	 *  How do we create threads in Java?
	 *  	
	 *  	2 Ways!
	 *  	- Create a class that 
	 *  		1. extends Thread class and then override the run();
	 *  				-Then create an instance of the childthread and call .start() method.
	 *  		2. OR Create a class that implements Runnable, then again override run() method
	 *  				-Then create an instance of the class that reference (datatype) runnable
	 *  				-Create an instance of Thread with a Runnable as the argument
	 *  	
	 *  
	 *  	- Use Runnable if you are only trying to provide code to run on a new thread
	 *  	  because you don't want to waste your only extends
	 *  
	 *  		Use Thread if you are changing Threads in general like the way they start up or terminate etc..
	 *  		which 
	 *  	2. important methods of a thread
	 *  			-run(); contains the code to execute...Never call/invoke the run() method 
	 *  			-start(); Creates the thread, invokes run on the new thread, terminates the thread
	 *  
	 *  
	 *  	Cannot control when a thread will execute over another thread in Java
	 *  			But I can try to request...  .setPriority(priorty #) method on thread object (1 through 10)
	 *  
	 *  	Starvation: when a thread is waiting for processing time (execute) and not getting it
	 *  		//Not usually an issue in Java
	 *  
	 *  	Deadlock: (Definitely an issue)
	 *  
	 *  		-Example...
	 *  													(A resource could be a method)
	 *  		2 Thread: A & B
	 *  			-A has resource X (locked or in use)
	 *  			-B has resource Y
	 *  
	 *  					-A also needs resource Y to finish
	 *  					-B also needs resource X to finish (so, neither can finish)
	 * 
	 * 
	 * 			Synchronized Key Word - makes a method thread safe... meaning 
	 * 			only one thread can access it at a time
	 * 
	 * 	
	 * 			Lifecycle of a Thread
	 * 					-new
	 * 					-runnable (can be running)
	 * 					-running
	 * 					-waiting
	 * 					- Timed waiting  exp. Thread.sleep(milliSeconds,nanoSeconds);
	 * 					-terminated
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static void main(String [] args) { //You cannot control when your threads will execute
		System.out.println("Threads...");
		
		Thread t1 = new ChildThread(); 
	//  t1.run(); If I call the run method I will execute it on the same thread...not a new one
		t1.start(); //start() creates the thread then invokes/calls run() when ready
		
		for(int i = 0; i < 10; i++) {
			System.out.println("Current Thread " + Thread.currentThread() + "i:" + i);
			
		}
		
		Runnable ehr = new EmailHr();
		Thread t2 = new Thread(ehr);
		
		t2.start();
	}

}
