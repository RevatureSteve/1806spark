package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pojo.House;

@Service(value="as")
public class AppService {

	//DI through Reflection, an API in java to inspect and manipulate the class at Runtime -heavy used with frameworks 
	@Autowired(required=true)
	private Dao dao; //new daoImpl
	
	public void saveHouse(){
		//save a house using the dao
		System.out.println("service is calling the dao to save the house");
		dao.saveHouse(new House());
	}
	//no constructor or setter?
	
}
