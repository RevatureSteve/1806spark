package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.ManagerDao;
import com.revature.model.Manager;

//Don't use @Component because this is not just a class, it is a service
@Service //it is a Component but better readability & works better for Spring ORM / Data
public class ManagerService {
	
	@Autowired
	private ManagerDao mdao;
	/*
	 * 	Above could be using Reflection API
	 * 		Reflection API: inspects and manipulates a class at runtime
	 * 			A very powerful API that allows you to modify classes
	 * 			like adding or removing fields of a class even PRIVATE DATA
	 * 
	 * 		Reflection is required to build most frameworks
	 */
	
	public ManagerService(ManagerDao mdao) {
		super();
		this.mdao = mdao;
	}

	//	Get a manager by Id
	public Manager getManagerById(int id) {
		System.out.println("Manager Service - getting " + id);
		return mdao.getManagerById(id);
	}
	
	//	Get all managers
	public List<Manager> getAllManagers() {
		System.out.println("Manager Service - retrieveing all Managers");
		return mdao.getAllManagers();
	}

}
