package com.revature.threads;

import com.revature.Launcher;
import com.revature.exceptions.CheckedException;
import com.revature.part23.InventoryUtil;
import com.revature.weapons.Staff;

public class StaffThread implements Runnable{
	String staffPath = "src/com/revature/staff.txt";
	public void run() {
		Staff f;
		try {
			f = Launcher.readStaff(staffPath);
		} catch (CheckedException e) {
			e.printStackTrace();
		}
		f = InventoryUtil.usingNewStaff();
		Launcher.writeStaff(staffPath, f);
		System.out.println(f);
	}
}
