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
import com.kingsgame.pojo.User;

public class MineUserServlet extends HttpServlet{
Dao dao = new Dao();
User user = null;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//if(dao.getAllReimbursement() != null) {
	int u_id = 0;
	ObjectMapper mapper = new ObjectMapper();
	ServletInputStream data = req.getInputStream();
	ObjectNode n = mapper.readValue(data,ObjectNode.class);
	if(n.has("u_id")) {
		u_id = n.get("u_id").asInt();
		User user = dao.getMineUser(u_id);
	

	String json = mapper.writeValueAsString(user);
	resp.setContentType("application/json");
	resp.getWriter().write(json);	
	}
	
//}
//else {
//resp.setStatus(401);
//resp.getWriter().write("");


	


}
}