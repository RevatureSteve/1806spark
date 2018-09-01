package com.revature.service;


import com.revature.dao.ManagerDao;
import com.revature.model.Manager;

public class ManagerService {
	private ManagerDao mDao;

	public ManagerService(ManagerDao mDao) {
		super();
		this.mDao = mDao;
	}

	// Get an employee by Id
	public Manager getManagerById(int id) {
		System.out.println("Manager Service - getting " + id);
		return mDao.getManagerById(id);
	}
}
