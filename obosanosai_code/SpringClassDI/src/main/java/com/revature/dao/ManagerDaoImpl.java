package com.revature.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Manager;

@Repository // aka Dao annotation; also makrs as a Component 
public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager getManagerByID(int id) {
		return new Manager("Yewie", 33, "CMG");
	}

	@Override
	public List<Manager> getAllManagers() {
		Manager[] managers = new Manager[] {
				new Manager("Obosa", 23, "CEO"),
				new Manager("Yewie", 33, "CMG"),
				new Manager("Arit", 53, "LMG"),
				
		};
		return Arrays.asList(managers);
	}

	
}
