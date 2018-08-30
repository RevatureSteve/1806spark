package com.revature.dao;

import java.util.List;

import com.revature.model.Manager;

public interface ManagerDao {
	
	//CREATE
	
	//READ
	public Manager getManagerByID(int id);
	public List<Manager> getAllManagers();
	//Update
	
	//DELETE

}
