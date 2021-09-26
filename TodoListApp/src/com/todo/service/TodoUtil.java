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
		
		System.out.println("[항목추가]\n" + "제목 > ");
		
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.printf("제목이 중복 됩니다.");
			return;
		}
		System.out.println("카테고리 > ");
		category = sc.next().trim();
		
		System.out.println("마감일자 > ");
		due_date = sc.next().trim();
		
		System.out.println("내용 > ");
		sc.nextLine();
		desc = sc.nextLine();
		
		
		TodoItem t = new TodoItem(title, desc, category, due_date);
		list.addItem(t);
		System.out.println("추가되었습니다.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[항목 삭제]\n" + "삭제할 항목의 번호를 입력하시오 > ");
		int number = sc.nextInt();
		
		for (TodoItem item : l.getList()) {
			if ((number - 1) == l.indexOf(item)) {
				System.out.println(item.toString());
				System.out.println("위 항목을 삭제하시겠습니까? (y/n) > ");
				String answer = sc.next().trim();
				if(answer.contains("y")) {
					l.deleteItem(item);
					System.out.println("삭제되었습니다.");
				}
				else
					System.out.println("삭제가 취소되었습니다.");
				break;
			}
		}
	}


	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[항목 수정]\n" + "수정할 항목의 번호를 입력하시오 > ");
		int number = sc.nextInt();
		int value = 0;
		for (TodoItem item : l.getList()) {
			if((number - 1) == l.indexOf(item)) {
				value += 1;
				break;
			}
		}
		
		if (value == 0) {
			System.out.println("없는 번호입니다!");
			return;
		}
		System.out.println("새 제목 > ");
		String new_title = sc.next().trim();
		
		if (l.isDuplicate(new_title)) {
			System.out.println("제목이 중복됩니다!");
			return;
		}
		System.out.println("새 카테고리 > ");
		String new_category = sc.next().trim();
		System.out.println("새 마감일자 > ");
		String new_due_date = sc.next().trim();
		System.out.println("새 내용 > ");
		sc.nextLine();
		String new_description = sc.nextLine();
		for (TodoItem item : l.getList()) {
			if ((number - 1) == l.indexOf(item)) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description, new_category, new_due_date);
				l.addItem(t);
				System.out.println("수정되었습니다.");
			}
		}

	}
	
	public static void findItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("[항목 검색]\n" + "검색할 키워드를 입력하시오. > ");
		String key = sc.next().trim();
		int number = 0;
		
		for (TodoItem item : l.getList()) {
			if (item.toString().contains(key)) {
				System.out.println(item.toString());
				number++;
			}
		}
		if (number == 0)
			System.out.println("검색된 결과가 없습니다.");
		
	}
	
	public static void findCate(TodoList l) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[카테고리 검색]\n" + "검색할 카테고리를 입력하시오. > ");
		String key = sc.next().trim();
		int number = 0;
		
		for (TodoItem item : l.getList()) {
			if(item.getCategory().contains(key)) {
				System.out.println(item.toString());
				number++;
			}
		}
		if (number == 0)
			System.out.println("검색된 카테고리가 없습니다.");
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
		System.out.println("총 " + result.length + "개의 카테고리가 등록되어 있습니다.");
	}

	public static void listAll(TodoList l) {
		System.out.println("[전체 목록, 총 " + l.getList().size() + "개]");
		
		int i = 1;
		for (TodoItem item : l.getList()) {
			System.out.println(i + ". " + item.toString());
			i++;
		}
	}
	
	public static void showHelp(TodoList l) {
		System.out.println("[도움말]");
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
			
			System.out.println("[저장이 완료되었습니다.]");
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
			
			System.out.println("[읽어온 데이타 입니다.]");
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