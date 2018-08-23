package com.kingsgame.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingsgame.dao.Dao;
import com.kingsgame.pojo.Reimbursement;

public class MReServlet extends HttpServlet{
Dao dao = new Dao();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	int mgr_u_id = Integer.parseInt(req.getParameter("mgr_u_id"));
	int emp_u_id = Integer.parseInt(req.getParameter("emp_u_id"));
	
List<Reimbursement> reim = dao.getMReimbursement(mgr_u_id, emp_u_id);

ObjectMapper mapper = new ObjectMapper();

String json = mapper.writeValueAsString(reim);
resp.setContentType("application/json");
resp.getWriter().write(json);	
	
}
}
