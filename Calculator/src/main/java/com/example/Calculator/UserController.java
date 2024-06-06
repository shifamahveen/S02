package com.example.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@Autowired
	private JdbcTemplate template;
	
	@GetMapping("register")
	public String showRegisterForm() { 
		return "register.jsp";
	}
	
	@PostMapping("register")
	public String register(Model model, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password) {
		String checkUser = "select count(*) from users where email = ?";
		Integer isUserRegistered = template.queryForObject(checkUser, Integer.class, email);
		
		if(isUserRegistered > 0) {
			model.addAttribute("error", "User already registered");
			return "error.jsp";	
		} else {
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
	
	
}
