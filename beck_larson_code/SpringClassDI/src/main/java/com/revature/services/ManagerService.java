package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.ManagerDao;
import com.revature.model.Employee;
import com.revature.model.Manager;

@Service
public class ManagerService {

	@Autowired
	private ManagerDao mdao;
	

	public Manager geManagerById(int id) {
		System.out.println("Manager Service - getting " + id);
		return mdao.getManagerById(id);
	}
	
	public List<Manager> getAllManagers(Employee emp){
		System.out.println("Employee Service - retreveing all Employees");
		return mdao.getAllManagers(emp);
	
    }
}
