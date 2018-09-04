package com.revature.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Manager;

@Repository
public class ManagerDaoImpl implements ManagerDao{

	@Override
	public Manager getManagerById(int id) {
		return new Manager("John", 30, "HR manager");
	}

	@Override
	public List<Manager> getAllManagers() {
		Manager[] managers = new Manager[] {
				new Manager("Gavin", 40, "Chief Innovation Officer"),
				new Manager("Peter", 48, "VC"),
				new Manager("Sam", 45, "Managing Partner")
		};
		return Arrays.asList(managers);
	}

}
