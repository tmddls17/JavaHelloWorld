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
		
		String title, desc, category, due_date;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[�׸��߰�]\n" + "���� > ");
		
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.printf("������ �ߺ� �˴ϴ�.");
			return;
		}
		System.out.println("ī�װ� > ");
		category = sc.next().trim();
		
		System.out.println("�������� > ");
		due_date = sc.next().trim();
		
		System.out.println("���� > ");
		sc.nextLine();
		desc = sc.nextLine();
		
		
		TodoItem t = new TodoItem(title, desc, category, due_date);
		list.addItem(t);
		System.out.println("�߰��Ǿ����ϴ�.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[�׸� ����]\n" + "������ �׸��� ��ȣ�� �Է��Ͻÿ� > ");
		int number = sc.nextInt();
		
		for (TodoItem item : l.getList()) {
			if ((number - 1) == l.indexOf(item)) {
				System.out.println(item.toString());
				System.out.println("�� �׸��� �����Ͻðڽ��ϱ�? (y/n) > ");
				String answer = sc.next().trim();
				if(answer.contains("y")) {
					l.deleteItem(item);
					System.out.println("�����Ǿ����ϴ�.");
				}
				else
					System.out.println("������ ��ҵǾ����ϴ�.");
				break;
			}
		}
	}


	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[�׸� ����]\n" + "������ �׸��� ��ȣ�� �Է��Ͻÿ� > ");
		int number = sc.nextInt();
		int value = 0;
		for (TodoItem item : l.getList()) {
			if((number - 1) == l.indexOf(item)) {
				value += 1;
				break;
			}
		}
		
		if (value == 0) {
			System.out.println("���� ��ȣ�Դϴ�!");
			return;
		}
		System.out.println("�� ���� > ");
		String new_title = sc.next().trim();
		
		if (l.isDuplicate(new_title)) {
			System.out.println("������ �ߺ��˴ϴ�!");
			return;
		}
		System.out.println("�� ī�װ� > ");
		String new_category = sc.next().trim();
		System.out.println("�� �������� > ");
		String new_due_date = sc.next().trim();
		System.out.println("�� ���� > ");
		sc.nextLine();
		String new_description = sc.nextLine();
		for (TodoItem item : l.getList()) {
			if ((number - 1) == l.indexOf(item)) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description, new_category, new_due_date);
				l.addItem(t);
				System.out.println("�����Ǿ����ϴ�.");
			}
		}

	}
	
	public static void findItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("[�׸� �˻�]\n" + "�˻��� Ű���带 �Է��Ͻÿ�. > ");
		String key = sc.next().trim();
		int number = 0;
		
		for (TodoItem item : l.getList()) {
			if (item.toString().contains(key)) {
				System.out.println(item.toString());
				number++;
			}
		}
		if (number == 0)
			System.out.println("�˻��� ����� �����ϴ�.");
		
	}
	
	public static void findCate(TodoList l) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[ī�װ� �˻�]\n" + "�˻��� ī�װ��� �Է��Ͻÿ�. > ");
		String key = sc.next().trim();
		int number = 0;
		
		for (TodoItem item : l.getList()) {
			if(item.getCategory().contains(key)) {
				System.out.println(item.toString());
				number++;
			}
		}
		if (number == 0)
			System.out.println("�˻��� ī�װ��� �����ϴ�.");
	}
	
	public static void lsCate(TodoList l) {
		String[] cate;
		int i = 0;
		for (TodoItem item : l.getList()) {
			i++;
		}
		cate = new String[i];
		i = 0;
		for (TodoItem item : l.getList()) {
			cate[i] = item.getCategory();
			i++;
		}
		
		HashSet<String> HashCate = new HashSet<>(Arrays.asList(cate));
		
		String[] result = HashCate.toArray(new String[0]);
		
		for (int j = 0; j < result.length; j++) {
			if (j < (result.length - 1))
				System.out.print(result[j] + " / ");
			else
				System.out.println(result[j]);
		}
		System.out.println("�� " + result.length + "���� ī�װ��� ��ϵǾ� �ֽ��ϴ�.");
	}

	public static void listAll(TodoList l) {
		System.out.println("[��ü ���, �� " + l.getList().size() + "��]");
		
		int i = 1;
		for (TodoItem item : l.getList()) {
			System.out.println(i + ". " + item.toString());
			i++;
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
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
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
				t.setCategory(tk.nextToken());
				t.setTitle(tk.nextToken());
				t.setDesc(tk.nextToken());
				t.setDueDate(tk.nextToken());
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