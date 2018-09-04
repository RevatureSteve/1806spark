package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.ManagerDao;
import com.revature.model.Manager;

//@Component // not going to use this isn't just a class it is a Service
@Service // it is a Component but better readability & works better for Spring ORM/Data
public class ManagerService {

	@Autowired
	private ManagerDao managerDao;
	/*
	 * 	Above could be using Reflection API
	 * 		Reflection API: inspects and manipulates a class at RUNTIME
	 * 			A very powerful API that allows you to modify classes
	 * 			like adding or remove fields of a class even PRIVATE DATA!
	 * 
	 * 		Reflection is required to build most frameworks
	 */
	public Manager getManagerById(int id) {
		System.out.println("ManagerService - get Manager: " + id);
		return managerDao.getManagerById(id);
	}
	
	public List<Manager> getAllManagers(){
		System.out.println("ManagerService - get Managers");
		return managerDao.getAllManagers();
	}
	
}
