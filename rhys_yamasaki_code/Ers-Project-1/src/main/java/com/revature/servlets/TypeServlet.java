package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Type;
import com.revature.service.ReimbursementService;

/**
 *  /type
 */
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ReimbursementService rs = new ReimbursementService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Type> status = rs.getStatus();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(status);
		
		response.setContentType("application/json");
		response.getWriter().write(json);
		
	}

}
