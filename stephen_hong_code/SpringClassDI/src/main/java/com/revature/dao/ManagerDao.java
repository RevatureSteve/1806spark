package com.revature.dao;

import java.util.List;

import com.revature.model.Manager;

public interface ManagerDao {
	
	//CREATE
	
	//READ
	public Manager getManagerById(int id);
	public List<Manager> getAllManagers();
	
	//UPDATE
	
	//DELETE

}
