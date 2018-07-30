package com.revature.threads;

import java.io.IOException;

import com.revature.Driver;
import com.revature.dao.DrinksDao;
import com.revature.pojo.Can;

public class SodaPersistThread extends Thread{

	@Override
	public void run() {
		Can soda = Driver.soda;
		
		try {
			DrinksDao.serializeDrinks(soda);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DrinksDao.writeDrinks(soda);
	}

	
}
