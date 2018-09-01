package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Manager;



public interface ManagerDao {

	
	//READ
	public Manager getManagerById(int id);
	List<Manager> getAllManagers(Employee emp);
}
