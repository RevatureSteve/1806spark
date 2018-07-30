package com.revature.monday;

public class ChildThread extends Thread{
	
	@Override
	public void run() {
		for (int a = 0; a< 10; a++) {
			System.out.println("\t\t" + "DancingTh" + "a " + a);
		}
	}

}
