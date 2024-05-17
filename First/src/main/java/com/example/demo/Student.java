package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
// singleton scope - creates bean instance even if not called, exactly one instance
public class Student {
	private int id;
	private String name;
	private String batch;
	
	public Student() {
		super();
		System.out.println("Student Object Created");
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	
	public void display() {
		System.out.println("Display method..");
	}
	
}
