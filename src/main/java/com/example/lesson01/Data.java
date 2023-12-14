package com.example.lesson01;

// 일반 java bean이 되도록 @Controller 어노테이션 생략
public class Data {
	// field
	private int id;
	private String name;
	

	// method
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
	
}
