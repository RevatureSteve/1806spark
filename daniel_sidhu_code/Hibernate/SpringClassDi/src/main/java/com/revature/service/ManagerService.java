package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.ManagerDao;
import com.revature.domain.Manager;

//@Component is a service
@Service //it is a component but better readability @ works better for Spring ORM/Data
public class ManagerService {
	
	@Autowired
	private ManagerDao mdao;
	/*
	 * Above could be using Reflection API
	 * 		reflection API: inspects and manipulates a class at RUNTIME
	 * 			a very powerful API that allows you to modify classes 
	 * 			like adding or removing fields of a class even PRIVATE DATA!!
	 * 
	 * 	reflection id required to build most frameworks
	 */
	
	//getting managers by id
	public Manager getManagerById(int id) {
		System.out.println("Manager Service - getting: " + id);
		return mdao.getMangerbyId(id);
	}
	
	public List<Manager> getAllManagers() {
		System.out.println("Manager Service - getting all managers");
		return mdao.getAllManagers();
	}
	
}
