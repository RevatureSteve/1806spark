package com.ad.threads;

import java.io.IOException;

import com.ad.Driver;
import com.ad.dao.DragonDao;
import com.ad.pojo.MysticDrake;
import com.ad.presentation.PresentationUtil;

public class MysticThread extends Thread{
	String MysticPath = "src/com/ad/MysticDrake.txt";
	@Override
	public void run() {
		MysticDrake mys = Driver.readMys(MysticPath);
		mys = PresentationUtil.UpdateMys(mys);
		Driver.writeMystic(MysticPath, mys);
	}
}