package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.*;

@Controller
public class IndexController {
	
	@RequestMapping("home")
	public String index(HttpServletRequest req) {
//		get the parameter value from url
		String username = req.getParameter("name");	
		String batch = req.getParameter("batch");
		
//		to pass the value from controller to view file
		HttpSession session = req.getSession();
		session.setAttribute("name", username);
		session.setAttribute("batch", batch);
		return "home.jsp";
	}

}
