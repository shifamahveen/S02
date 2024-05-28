package com.example.Calculator;

public class Calculator {
	private int id;
	private int angle;
	private String func;
	private double result;
	
//	parameterized constructor
	public Calculator(int id, int angle, String func, double result) {
		super();
		this.id = id;
		this.angle = angle;
		this.func = func;
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
}
