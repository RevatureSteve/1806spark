package com.revature.threads;

import java.io.IOException;

import com.revature.Driver;
import com.revature.dao.AttractionDao;
import com.revature.pojo.Lighthouse;

public class LighthousePersistThread extends Thread{

	@Override
	public void run() {
		
		Lighthouse light = Driver.light;
		
		try {
			AttractionDao.serializeAttraction(light);
		} catch (IOException e) {
			e.printStackTrace();
		}
		AttractionDao.writeAttraction(light);
	}

	
}
