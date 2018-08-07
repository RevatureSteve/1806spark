package com.revature.interfaces;

import java.util.List;

public interface DataAccess {

		//Create
		public int create(Object obj);
		
		//Read
		public List<Object> read();
		
		//Update
		public int update(Object obj);
		
		//Delete

	
}
