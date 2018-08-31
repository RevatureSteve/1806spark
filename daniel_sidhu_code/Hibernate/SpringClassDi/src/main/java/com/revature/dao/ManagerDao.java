package com.revature.dao;

import java.util.List;

import com.revature.domain.Manager;

public interface ManagerDao {
	
	//CREATE 
	
	//READ
	public Manager getMangerbyId(int id);
	public List<Manager> getAllManagers();
	
	//UPDATE
	
	//DELETE

}
