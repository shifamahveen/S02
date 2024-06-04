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

@Controller
public class CalculatorController {
	@Autowired
	private JdbcTemplate template;

	@GetMapping("/")
	public String index() {
		return "index.jsp";
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
	
}
