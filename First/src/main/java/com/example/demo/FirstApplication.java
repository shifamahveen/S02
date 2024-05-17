package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext project = SpringApplication.run(FirstApplication.class, args);
		
		Student s1 = project.getBean(Student.class);
		Student s2 = project.getBean(Student.class);
//		s1.display();
//		System.out.println("Hello World!");
//		POJO - PLAIN OLD JAVA OBJECT
//		CACHE
	}

}
