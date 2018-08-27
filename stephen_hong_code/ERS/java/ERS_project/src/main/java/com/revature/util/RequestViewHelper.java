package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {
	
	private final String uri = "/ERS_project/";

	public String process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("[LOG] - Request sent to RequestViewHelper.process()");
		System.out.println(req.getRequestURI());
		switch(req.getRequestURI()) {
		case uri + "login.view":
			return "partials/login.html";
		case uri + "register.view":
			return "partials/register.html";
		case uri + "reimbursements.view":
			return "partials/reimbursements.html";
		case uri + "createReimbursement.view":
			return "partials/createReimbursement.html";
		case uri + "landing.view":
			return "partials/landing.html";
		default:
			return null;
		}
	}
}
