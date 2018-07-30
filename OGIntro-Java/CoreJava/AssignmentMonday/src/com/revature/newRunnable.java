package com.revature;

public class newRunnable implements Runnable {

	@Override
	public void run() { // has to be implemented 
		Grouper g = FishDao.deserialize();
		System.out.println(g);
		
		System.out.println("Thread");
	}
	
	

}
