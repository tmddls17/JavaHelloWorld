package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		boolean isList = false;
		boolean quit = false;
		
		TodoUtil.loadList(l, "C:\\Users\\82109\\eclipse\\real_project1\\TodoListApp\\todolist.txt");
		
		Menu.displaymenu();
		do {
			Menu.prompt();
			isList = false;
			String choice = sc.next();
			switch (choice) {

			case "add":
				TodoUtil.createItem(l);
				break;
			
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;

			case "ls_name_asc":
				l.sortByName();
				System.out.println("��������� �����Ͽ����ϴ�.");
				isList = true;
				break;

			case "ls_name_desc":
				l.sortByName();
				l.reverseList();
				System.out.println("���񿪼����� �����Ͽ����ϴ�.");
				isList = true;
				break;
				
			case "ls_date":
				l.sortByDate();
				System.out.println("��¥������ �����Ͽ����ϴ�.");
				isList = true;
				break;
				
			case "ls_date_desc":
				l.sortByDateReverse();
				System.out.println("��¥�������� �����Ͽ����ϴ�.");
				isList = true;
				break;
				
			case "ls_cate":
				TodoUtil.lsCate(l);
				break;
				
			case "find":
				TodoUtil.findItem(l);
				break;
				
			case "find_cate":
				TodoUtil.findCate(l);
				break;
				
			case "help":
				TodoUtil.showHelp(l);
				break;
				
			case "exit":
				quit = true;
				break;

			default:
				System.out.println("��Ȯ�� ��ɾ �Է��ϼ���. (���� - help)");
				break;
			}
			
			if(isList) TodoUtil.listAll(l);
		} while (!quit);
		TodoUtil.saveList(l, "C:\\Users\\82109\\eclipse\\real_project1\\TodoListApp\\todolist.txt");
		return;
	}
}
