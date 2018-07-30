package com.revature.threads;

import java.io.IOException;

import com.revature.Driver;
import com.revature.dao.DrinksDao;
import com.revature.pojo.Bottle;



public class JuicePersistThread extends Thread {

	Bottle juice = Driver.juice;
	
	@Override
	public void run() {
		try {
			DrinksDao.serializeDrinks(juice);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DrinksDao.writeDrinks(juice);
	}

	
}
