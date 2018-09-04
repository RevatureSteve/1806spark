package com.revature.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ManagerDatabaseDao implements ManagerDao {

	public Manager getManagerById(int id) {
		return new Manager(id,"Little Bo Peep");
	}

	public List<Manager> getAllManagers() {
		Manager[] managers = new Manager[] {new Manager(1,"Little Bo Peep")};
		
		return Arrays.asList(managers);
	}

}
