package com.revature.threads;

public class ThreadsExample {
	/*
	 * What is a thread? Individual task, process Each thread in java gets its own
	 * Memory Stack
	 * 
	 * Multithreading... multiple threads in a single application
	 * 
	 * How do we create threads in Java? 2 Ways! Create a class that 
	 * 1. extends Thread class 
	 * 2. implements Runnable
	 * 
	 * Which is the better way and why?
	 * use runnable if you are only trying to provide code to run on a new thread, because you don;t want to waste your only Extends
	 * use thread if you are changing threads in general like the way they start up or terminate etc which you probably won't ever do
	 * 
	 * 2 important methods of a thread run() contains the code to execute, *never
	 * call the run()* start() creates the thread, invokes run() on the new thread,
	 * terminates the thread
	 * 
	 * in Java cannot control when a thread will execute
	 * but i can try...
	 * 
	 * Starvation: when a thread is waiting for processing time and not getting it, not usually an issue in Java
	 * Deadlock:
	 * e.g. 2 Threads A and B
	 * A has resource X
	 * B has resource Y
	 * 
	 * A also needs Y to finish
	 * B also needs X to finish... neither can finish because both are waiting for other
	 * 
	 * Threads have 5 states
	 * -new
	 * -runnable (can be running)
	 * -waiting
	 * -terminated
	 */

	public static void main(String[] args) {
		System.out.println("threads...");

		Thread t1 = new ChildThread();
		t1.setPriority(10);
		t1.start();
		EmailHr hr = new EmailHr();		
		Thread t2 = new Thread(hr);
		t2.start();
		for(int i = 0; i<10; i++) {
			System.out.println(Thread.currentThread() + " i" + i);
		}
	}
}
