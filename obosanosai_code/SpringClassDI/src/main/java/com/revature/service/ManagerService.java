package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.dao.ManagerDao;
import com.revature.model.Manager;

//@Component // not going to use this isn't just a class it is a service
@Service //it is a component but better readability & works better for Spring ORM/Data
public class ManagerService {

@Autowired
private ManagerDao mdao;
/*
 * Above could be using Reflection ApI
 *       Refelection ApI: inspects and manipulates a class at RUNTIME
 *            A very powerfull Api that allows you to modify classes 
 *            like adding or removing feilds of a class even pRIVATE DATA!
 *            
 *     Reflection is required to build most frameworks
 */
//	public ManagerService(ManagerDao mdao) {
//		this.mdao = mdao;
//	}

	// Get a manager by Id
	public Manager getManagerById(int id) {
		System.out.println("Manager Service - getting " + id);
		return mdao.getManagerByID(id);
	}
	
	// Get all Managers
	public List<Manager> getAllManagers(){
		System.out.println("Manager Service - retrieving all Employees");
		return mdao.getAllManagers();
	}
}
