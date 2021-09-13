package com.example.lab2;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private int no;
	private String name;
	private int age;
	
	
	public Student() {
		no = 0;
		name = "";
		age = 0;
	}
	public Student(int no, String name, int age)
	{
		this.no = no;
		this.name = name;
		this.age = age;
	}
	public int getNo() {
		return no;		
	}
	public void setNo(int no){
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	

}