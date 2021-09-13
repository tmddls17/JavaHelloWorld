package com.example.lab2;

import java.util.*;

public class Fruit implements Comparable<Fruit>{
	int no; 		// number
	String name;	// name
	int price;		// age
	
	public Fruit() {
		no = 0;
		name = "";
		price = 0;
	}
	public Fruit(int n1, String word, int n2)
	{
		no = n1;
		name = word;
		price = n2;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price){
		this.price = price;
	}

	@Override
	public int compareTo(Fruit o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.name);
	}
	
	@Override
	public String toString() {
		String n1 = "Fruit [no=";
		n1 = n1.concat(Integer.toString(no) + ", name=" + name + ", price=" + Integer.toString(price) + "]");
		return n1;
	}
	

}