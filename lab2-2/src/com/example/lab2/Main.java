package com.example.lab2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		
		Student s = new Student();
		s.setAge(1);
		s.setName("홍길동");
		s.setAge(20);
		list.add(s);
		list.add(new Student(2, "철수", 22));
		
		//list 데이터 출력
		for(int i = 0; i < 2; i++)
		{
			System.out.println(list.get(i).toString());
		}
		
		list.remove(1);
	}

}
