package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	
	@RequestMapping("form")
	public String form() {
		return "index.jsp";
	}
	
	@RequestMapping("submitForm")
	public String submit(Model model, @RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("opr") String opr) {

		int result = 0;
		
		switch(opr) {
		case "add":
			result = a+b;
			break;
		case "sub":
			result = a-b;
			break;
		case "mul":
			result = a*b;
			break;
		case "div":
			result = a/b;
			break;
		default:
			System.out.println("invalid case");
		}
		
		model.addAttribute("result", result);
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("opr", opr);

		return "home.jsp";
	}
}
