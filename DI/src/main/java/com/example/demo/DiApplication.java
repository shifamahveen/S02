package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(DiApplication.class, args);
		
		Dept dept = app.getBean(Dept.class);
		
		dept.setDeptno(10);
		dept.setDname("Research");
		dept.setLoc("India");
		
//		Inject into Emp class
		Emp e = new Emp(dept);
		e.setId(1);
		e.setName("Alex");
		
		e.show();
	}

}
