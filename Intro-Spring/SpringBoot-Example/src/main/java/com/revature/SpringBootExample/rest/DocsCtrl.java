package com.revature.SpringBootExample.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocsCtrl {

	@GetMapping("/docs")
	public String docs() {
		System.out.println("Docs Controller");
		return "forward:docs.html";
	}
}
