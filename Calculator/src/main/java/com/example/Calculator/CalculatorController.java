package com.example.Calculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
	@Autowired
	private JdbcTemplate template;

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/calculate")
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
	
	@RequestMapping("records")
	public String records(Model model) {
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
	}
		
}
