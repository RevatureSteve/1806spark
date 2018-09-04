package com.revature.dao;

import java.util.List;

public interface ManagerDao {
	
	Manager getManagerById(int id);
	List<Manager> getAllManagers();

}
