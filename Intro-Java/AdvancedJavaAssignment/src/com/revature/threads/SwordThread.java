package com.revature.threads;

import java.io.IOException;

import com.revature.part23.InventoryUtil;
import com.revature.part23.WeaponsDao;
import com.revature.weapons.Sword;

public class SwordThread extends Thread{

	@Override
	public void run() {
		Sword s = WeaponsDao.deserializeSword();
		s = InventoryUtil.usingNewSword();
		try {
			WeaponsDao.serializeSword(s);
		} catch (IOException e){
			InventoryUtil.errorView("File is corrupt");
		}
	}
}