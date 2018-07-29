package com.revature.threads;

public class ChildThread extends Thread{
	@Override
	public void run() {
		for(int j = 0; j<10; j++) {
			System.out.println("\t" + Thread.currentThread() + " j" + j);
		}
	}
}
