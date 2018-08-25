package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.logic.ReqLogic;
import com.revature.logic.UserLogic;
import com.revature.pojo.TranstarUsers;

/**
 * Servlet implementation class NewReqServlet
 */
public class NewReqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReqLogic req = new ReqLogic();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewReqServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int amount = 0;
		int userId = 0;
		int reqType = 0;
		String desc = null;
		
		System.out.println("POST- Login");
		int newReq = 0;
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream body = request.getInputStream();
		ObjectNode n = mapper.readValue(body, ObjectNode.class);
		
		if(n.has("amt")) {
			amount = n.get("amt").intValue();
		}
		
		if(n.has("req_type")) {
			reqType = n.get("req_type").intValue();
		}
		
		if(n.has("desc")) {
			desc = n.get("desc").textValue();
		}
		if(n.has("u_id")) {
			userId = n.get("u_id").intValue();
		}
		System.out.println(amount + " " + reqType + " " + desc + " " + userId);
		newReq = new ReqLogic().createRequest(userId, amount, desc, reqType);
		
		
		
		
		String json = mapper.writeValueAsString(newReq);
		
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

}
