package com.revature.service;

import org.springframework.stereotype.Repository;

import com.revature.pojo.House;
@Repository
public class DaoImpl implements Dao {

	public void saveHouse(House house) {
		System.out.println("house is now persisted");
	}

}
