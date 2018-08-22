package com.revature.dao;

import java.util.List;

import com.revature.pojo.TranstarReims;

public interface TranstarReimDao {
//READ
public TranstarReims getUserRequests(int userId);


public List<TranstarReims> getAllPendingRequests();


}