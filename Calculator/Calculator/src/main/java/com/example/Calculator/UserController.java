package com.example.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@Autowired
	private JdbcTemplate template;
	
	@GetMapping("register")
	public String showRegisterForm() { 
		return "register.jsp";
	}
	
	@PostMapping("register")
	public String register(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password) {
		String sql = "insert into users (name, email, password) values (?,?,?)";
		int status = template.update(sql, name, email, password);
		
		if (status > 0) {
			return "redirect:/records";
		}
		else {
			return "Registeration failed!";
		}
	}
}
