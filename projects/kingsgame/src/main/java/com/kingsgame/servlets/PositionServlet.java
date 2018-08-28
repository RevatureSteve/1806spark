package com.kingsgame.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingsgame.dao.Dao;
import com.kingsgame.pojo.Position;
import com.kingsgame.pojo.Reimbursement;
import com.kingsgame.pojo.Type;

public class PositionServlet extends HttpServlet{
Dao dao = new Dao();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//if(dao.getAllReimbursement() != null) {
	Dao dao = new Dao();
	List<Position> reList = dao.getAllPositions();
	ObjectMapper mapper = new ObjectMapper();
	
	String json = mapper.writeValueAsString(reList);
	System.out.println("USER POSITION GRAB: " + json);
	resp.setContentType("application/json");
	resp.getWriter().write(json);	


}
}