package com.example.Calculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Calculator.UserController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CalculatorController {
	@Autowired
	private JdbcTemplate template;

	@GetMapping("/")
	public String index(HttpServletRequest req) {
		if(isLoggedIn(req)) {
			return "index.jsp";
		} else {
			return "login.jsp";
		}
	}
	
	@PostMapping("/calculate")
	public String calculate(Model model, @RequestParam("angle") int angle, @RequestParam("func") String func) {
		
		double result = 0.0;
		
		switch(func) {
			case "sin":
				result = Math.sin(Math.toRadians(angle));
				break;
			case "cos":
				result = Math.cos(Math.toRadians(angle));
				break;
			case "tan":
				result = Math.tan(Math.toRadians(angle));
				break;
			case "sec":
				result = 1 / (Math.cos(Math.toRadians(angle)));
				break;
			case "cosec":
				result = 1 / (Math.sin(Math.toRadians(angle)));
				break;
			case "cot":
				result = 1 / (Math.tan(Math.toRadians(angle)));
				break;
		}
		
		String sql = "insert into trig (angle, func, result) values (?,?,?)";
		template.update(sql, angle, func, result);
		
		model.addAttribute("angle", angle);
		model.addAttribute("func", func);
		model.addAttribute("result", result);
		return "result.jsp";
	}
	
	@GetMapping("records")
	public String records(Model model, HttpServletRequest req) {
		if(isLoggedIn(req)) {
			String sql = "select * from trig";
			
			List<Calculator> records = template.query(
					sql, 
					(rs, rowNum) -> new Calculator(
							rs.getInt("id"),
							rs.getInt("angle"),
							rs.getString("func"),
							rs.getDouble("result")
					)				
			);
			
			model.addAttribute("records", records);
			return "records.jsp";
		} else {
			return "login.jsp";
		}
		
	}
	
	@PostMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		String sql = "DELETE from trig where id = ?";
		int status =  template.update(sql, id);
		
		if(status>0) {
			return "redirect:/records";
		}
		else {
			return "error.jsp";
		}
	}
	
	@GetMapping("edit")
	public String edit(int id, Model model) {
		@SuppressWarnings("deprecation")
		Calculator record = template.queryForObject("select * from trig where id = ?", 
				new Object[]{id},
				(rs, rowNum) -> new Calculator(
						rs.getInt("id"),
						rs.getInt("angle"),
						rs.getString("func"),
						rs.getDouble("result")
				)
		);
		
		model.addAttribute("obj",record);
		
		return "edit.jsp";
	}
	
	@PostMapping("update")
	public String update(@ModelAttribute Calculator calc) {
		String sql = "UPDATE trig set angle = ?, func = ?, result = ? where id = ?";
		template.update(sql, calc.getAngle(), calc.getFunc(), calc.getResult(), calc.getId());
		
		return "redirect:/records";
	}
	
	@GetMapping("sort")
	public String sort(Model model, @RequestParam("sortBy") String sortValue) {
		String sql;
		
		if(sortValue.equals("asc")) {
			sql = "select * from trig order by angle";
		} else {
			sql = "select * from trig order by angle desc";
		}
		
		List<Calculator> records = template.query(
				sql, 
				(rs, rowNum) -> new Calculator(
						rs.getInt("id"),
						rs.getInt("angle"),
						rs.getString("func"),
						rs.getDouble("result")
				)				
		);
		
		model.addAttribute("records", records);
		return "records.jsp";	
	}
	
	@GetMapping("search")
	public String search(Model model, @RequestParam("searchValue") String value) {
		@SuppressWarnings("deprecation")
		List<Calculator> records = template.query(
				"select * from trig where func like ?", 
				new String[] {"%" + value + "%"},
				(rs, rowNum) -> new Calculator(
						rs.getInt("id"),
						rs.getInt("angle"),
						rs.getString("func"),
						rs.getDouble("result")
				)				
		);
		model.addAttribute("records", records);
		return "records.jsp";
	}
	
	@GetMapping("login")
	public String showLoginForm() { 
		return "login.jsp";
	}
	
	@PostMapping("login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest req) {
//		check if user is registered or nor 
		if(isValidUser(email, password)) {
			req.getSession().setAttribute("email", email);
			return "redirect:/records";
		} else {
			return "register.jsp";
		}
	}

	private boolean isValidUser(String email, String password) {
		String sql = "select count(*) from users where email = ? and password = ?";
		int count = template.queryForObject(sql, Integer.class, email, password);
		
		return count > 0;
	}
	
	private boolean isLoggedIn(HttpServletRequest req) {
		String status = (String) req.getSession().getAttribute("email");
		
		return status != null;
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String status = (String) session.getAttribute("email");
		
		if(status != null) {
			session.invalidate();
			return "login.jsp";
		} else {
			return "error.jsp";
		}
		
	}
	
	
	
}
