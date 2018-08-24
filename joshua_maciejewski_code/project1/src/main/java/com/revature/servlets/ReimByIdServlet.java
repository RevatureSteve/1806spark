package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.Reimbursement;
import com.revature.service.ReimbursementBL;

/**
 * Servlet implementation class ReimByIdServlet
 */
public class ReimByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReimByIdServlet() {
        super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementBL bl = new ReimbursementBL();
		
		int u_id;
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = request.getInputStream();
		ObjectNode node = mapper.readValue(data,  ObjectNode.class);
		
		u_id = node.get("u_id").intValue();
		
		List<Reimbursement> reims = bl.viewSingleEmployee(u_id);
		
		String json = mapper.writeValueAsString(reims);
		response.setContentType("application/json");
		response.getWriter().write(json);
		
		
	}

//	public List<Reimbursement> viewSingleEmployee(int id){
//		return dao.getReimbursementForSingle(id);
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementBL bl = new ReimbursementBL();
		
		int u_id;
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = request.getInputStream();
		ObjectNode node = mapper.readValue(data,  ObjectNode.class);
		
		u_id = node.get("u_id").intValue();
		
		List<Reimbursement> reims = bl.viewSingleEmployee(u_id);
		
		String json = mapper.writeValueAsString(reims);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

}
