package com.revature.threads;

import java.io.IOException;

import com.revature.Driver;
import com.revature.dao.AttractionDao;
import com.revature.pojo.NationalParks;



public class NationalParkPersistThread extends Thread {

	NationalParks park = Driver.park;
	
	@Override
	public void run() {
		try {
			AttractionDao.serializeAttraction(park);
		} catch (IOException e) {
			e.printStackTrace();
		}
		AttractionDao.writeAttraction(park);
	}

	
}
