package com.revature.service;

import java.util.List;

import com.revature.dao.ManagerDao;
import com.revature.model.Manager;

public class ManagerService {
	
	private ManagerDao mdao;
	
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
