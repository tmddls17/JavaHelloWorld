package com.example.lab2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		
		Student s = new Student();
		s.setAge(1);
		s.setName("ȫ�浿");
		s.setAge(20);
		list.add(s);
		list.add(new Student(2, "ö��", 22));
		
		//list ������ ���
		for(int i = 0; i < 2; i++)
		{
			System.out.println(list.get(i).toString());
		}
		
		list.remove(1);
	}

}
