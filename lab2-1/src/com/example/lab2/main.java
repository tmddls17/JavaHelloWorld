package com.example.lab2;

import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Fruit> al = new ArrayList<Fruit>();
		System.out.println("Fruit List (ordered by name)");
		Fruit s1 = new Fruit(11, "Cherry", 6000);
		al.add(s1);	//adding Student class object
		Fruit s2 = new Fruit(12, "Grape", 5500);
		al.add(s2); //adding Student class object
		al.add(new Fruit(13, "Apple", 4900));
		al.add(new Fruit(14, "Orange", 6400));
		al.add(new Fruit(15, "Tangerine", 5800));
		al.add(new Fruit(16, "Pear", 5400));
		al.add(new Fruit(17, "Lime", 5100));
		al.add(new Fruit(18, "Fashion Fruits", 6900));
		al.add(new Fruit(19, "Mango", 7000));
		al.add(new Fruit(20, "Water Melon", 8300));
		
		Collections.sort(al);
		//Traverse elements of arraylist (ordered)
		for (Fruit s : al) {
			System.out.println(s.toString());
		}
		
		System.out.println("Fruit List (reverse ordered by name");
		
		Collections.sort(al, Collections.reverseOrder());
		//Traverse elements of arraylist (reverse ordered)
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i).toString());
		}

	}

}
