package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.Manager;
import com.revature.dao.ManagerDao;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerDao mdd;
	
	public Manager getManagerById(int id) {
		System.out.println("MangerService - get Manager: " + id);
		return mdd.getManagerById(id);
	}
	
	public List<Manager> getAllManagers() {
		System.out.println("ManagerService - get all managers");
		return mdd.getAllManagers();
	}

}
