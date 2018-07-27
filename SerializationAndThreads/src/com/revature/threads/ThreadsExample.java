package com.revature.threads;

/**
 * @author sidhu
 *
 */
public class ThreadsExample {
	/*
	 * what is a thread?
	 * 		individual task
	 * each thread in java gets its own memory stack
	 * 		that all have access to the same HEAP
	 * 
	 * Multithreading. . .multiple threads in a single application 
	 * 
	 * how do we create threads in java?
	 * 		2 ways
	 * 		create a class that:
	 * 			1. extends thread class then override the run()
	 * 				Then create an instance of the child thread and call .start()
	 * 			2. implements runnable the overrides the class implements runnable
	 * 				and create an instance of thread w/ the runnable 
	 * 
	 * 			which is better and why?
	 * 				use runnable if you are only trying to provide code to run on a new thread
	 * 					because you don't want to waste your only extends
	 * 
	 * 				use thread if you are changing threads in general like the way they start up 
	 * 					or terminate ect which you probably won't ever do
	 * 
	 * 2 important methods of a thread
	 * 		1. run() run method contains the code to execute; never call/ invoke the run method
	 * 		2. start() creates the thread, invoke run() on the new thread, terminates the thread
	 * 
	 * you cannot control when your threads will execute over another thread in java
	 * starvation: when a thread is waiting for processing time to execute and not getting to do that 
	 * 		not usually an issue in java
	 * 
	 * deadlock:
	 * 		e.g 2 threads A and B
	 * 		A has resource x locked (in use)
	 * 		B has resource y
	 * 
	 * 		A also needs resource Y to finish
	 * 		B also needs resource X to finish...one waiting on the other to execute
	 * 
	 * synchronized keywords: makes a method thread safe. . . meaning only one thread can access it at a time
	 * 
	 * lifecycle of a thread	
	 * 		-new
	 * 		-running (can be running)
	 * 		-waiting 
	 * 		-timed waiting 
	 * 		-terminating
	 * 		
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("threads presented");
		
		Thread t1 = new ChildThread();//childThread actually had implementation for the run method
		//t1.run();//when calling the run() i will execute it on the same thread, not a new one 
		t1.setPriority(10); //1-10 is the highest priority, 1 is low but hardly makes a difference
		t1.start();// start() will call/invoke the run() when ready
		
		Runnable eHr = new EmailHr();
		Thread t2 = new Thread(eHr);
		t2.start();
		
		//Thread.sleep(millis, nanos); //ex of timed waiting 
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println("ParentThread" + "i: " + i);
		}
	}
}
