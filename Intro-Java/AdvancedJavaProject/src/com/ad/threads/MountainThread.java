package com.ad.threads;

import java.io.IOException;

import com.ad.dao.DragonDao;
import com.ad.pojo.MountainDrake;
import com.ad.presentation.PresentationUtil;

public class MountainThread extends Thread{

	@Override
	public void run() {
		MountainDrake mtn = DragonDao.deserializeMountain();
		mtn = PresentationUtil.UpdateMtn(mtn);
		try {
			DragonDao.serializeMountain(mtn);
		} catch (IOException e) {
			PresentationUtil.errorView("File is corrupt");
		}
	}
}