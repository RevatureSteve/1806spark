package com.revature.threads;

public class ClothesThread extends Threads {
	
	
	@Override
	public void run() {
		// this is the code that will execute when creating a new thread
		for(int j = 0; j < 10; j++) {
		System.out.println(" ClothesThread" + "j:" + j);
	}

}

	public void start() {
		// TODO Auto-generated method stub
		
	}

	public void setPriority(int i) {
		// TODO Auto-generated method stub
		
	}

	
}