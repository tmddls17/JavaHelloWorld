package com.todo.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;
import com.todo.menu.Menu;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[�׸��߰�]\n" + "���� > ");
		
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.printf("������ �ߺ� �˴ϴ�.");
			return;
		}
		
		System.out.println("���� > ");
		sc.nextLine();
		desc = sc.nextLine();
		
		TodoItem t = new TodoItem(title, desc);
		list.addItem(t);
		System.out.println("�߰��Ǿ����ϴ�.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		String title = sc.next();
		
		System.out.println("[�׸� ����]\n" + "������ �׸��� ������ �Է��Ͻÿ� > ");
		
		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				System.out.println("�����Ǿ����ϴ�.");
				break;
			}
		}
	}


	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[�׸� ����]\n" + "������ �׸��� ������ �Է��Ͻÿ� > ");
		String title = sc.next().trim();
		if (!l.isDuplicate(title)) {
			System.out.println("���� �����Դϴ�!");
			return;
		}

		System.out.println("�� ���� > ");
		String new_title = sc.next().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("������ �ߺ��˴ϴ�!");
			return;
		}
		
		System.out.println("�� ���� > ");
		sc.nextLine();
		String new_description = sc.nextLine();
		for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title)) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description);
				l.addItem(t);
				System.out.println("�����Ǿ����ϴ�.");
			}
		}

	}

	public static void listAll(TodoList l) {
		System.out.println("[��ü ���]");
		for (TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
	}
	
	public static void showHelp(TodoList l) {
		System.out.println("[����]");
		Menu.displaymenu();
	}
	
	public static void saveList(TodoList l, String filename) {
		try {
			Writer w = new FileWriter(filename);
			
			List<TodoItem> list = l.getList();
			for(int i = 0; i < list.size(); i++) {
				w.write(list.get(i).toSaveString());
			}
			w.close();
			
			System.out.println("[������ �Ϸ�Ǿ����ϴ�.]");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadList(TodoList l, String filename) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date current_date;
		int i = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));

			String buf;
			StringTokenizer tk;
			
			System.out.println("[�о�� ����Ÿ �Դϴ�.]");
			while((buf = reader.readLine()) != null) {
				TodoItem t = new TodoItem();
				tk = new StringTokenizer(buf, "##");
				t.setTitle(tk.nextToken());
				t.setDesc(tk.nextToken());
				current_date = date.parse(tk.nextToken());
				t.setCurrent_date(current_date);
				System.out.println(t.toString());
				l.addItem(t);
				i++;
			}

			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}