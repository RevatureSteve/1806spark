package com.kingsgame.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kingsgame.dao.Dao;
import com.kingsgame.pojo.Reimbursement;

public class MineServlet extends HttpServlet{
Dao dao = new Dao();
List <Reimbursement> reList = null;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//if(dao.getAllReimbursement() != null) {
	int u_id = 0;
	ObjectMapper mapper = new ObjectMapper();
	ServletInputStream data = req.getInputStream();
	ObjectNode n = mapper.readValue(data,ObjectNode.class);
	if(n.has("emp_u_id")) {
		u_id = n.get("emp_u_id").asInt();
		List<Reimbursement> reList = dao.getMineReimbursement(u_id);
	

	String json = mapper.writeValueAsString(reList);
	resp.setContentType("application/json");
	resp.getWriter().write(json);	
	}
	
//}
//else {
//resp.setStatus(401);
//resp.getWriter().write("");


	


}
}