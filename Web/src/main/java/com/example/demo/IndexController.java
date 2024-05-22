package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.*;

@Controller
public class IndexController {
	
	@RequestMapping("home")
	public String home(HttpServletRequest req) {
//		get the parameter value from url
		String username = req.getParameter("name");	
		String batch = req.getParameter("batch");
		
//		to pass the value from controller to view file
		HttpSession session = req.getSession();
		session.setAttribute("name", username);
		session.setAttribute("batch", batch);
		return "home.jsp";
	}
	
	@RequestMapping("index")
	public String index(Model model, @RequestParam("name") String username, @RequestParam("batch") String batch) {
		model.addAttribute("name", username);
		model.addAttribute("batch", batch);
		
		System.out.println("Name: "+username+"\nBatch: "+batch);
		return "home.jsp";
	}

}
