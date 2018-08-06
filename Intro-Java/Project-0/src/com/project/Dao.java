package com.project;

import java.util.List;

public interface Dao {

	
	//create
		public int create(Object obj);
	//read
		public List<Object> read();
	//update
		public int update(Object obj);
	//Delete
		
}
