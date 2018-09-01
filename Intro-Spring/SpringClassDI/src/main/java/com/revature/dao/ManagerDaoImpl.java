package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Manager;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager getManagerById(int id) {
		return new Manager(1, "Bobbert");
	}

	@Override
	public List<Manager> getAllManagers() {
		ArrayList<Manager> mgrs = new ArrayList<Manager>();
		mgrs.add(new Manager(2, "Bob"));
		mgrs.add(new Manager(3, "Rob"));
		return mgrs;
	}

}
