package com.revature.dao;

import java.sql.Blob;
import java.util.List;

import com.revature.pojo.TranstarReims;

public interface TranstarReimDao {
	

//CREATE
public int submitReimbursment(int emp_id, int amount, String desc, int rq_type);

	
//READ
public TranstarReims getUserRequests(int userId);


public List<TranstarReims> getAllPendingRequests();


}