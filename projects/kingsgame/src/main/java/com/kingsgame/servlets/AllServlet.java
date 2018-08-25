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
import com.kingsgame.pojo.Reimbursement;

public class AllServlet extends HttpServlet{
Dao dao = new Dao();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//if(dao.getAllReimbursement() != null) {
	List<Reimbursement> reList = dao.getAllReimbursement();
	ObjectMapper mapper = new ObjectMapper();

	String json = mapper.writeValueAsString(reList);
	resp.setContentType("application/json");
	resp.getWriter().write(json);	
	
//}
//else {
//resp.setStatus(401);
//resp.getWriter().write("");


	


}
}
//}