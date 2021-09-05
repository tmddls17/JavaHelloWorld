import java.util.ArrayList;
import java.util.Scanner;

public class CH12_ClassList {
	private static ArrayList<String> classes = new ArrayList<String>();
	
	private static void add(String s) {
		classes.add(s);
	}
	public static void Print() {
		int j = 0;
		System.out.println("\nList of classes");
		for(String i : classes) { //for문을 통한 전체출력
			j++;
		    System.out.println("class" + j + ": " + i);
		}
	}
	public static void main(String[] args) {
		CH12_ClassList myclasses = new CH12_ClassList();
		Scanner kb = new Scanner(System.in);
		String s = "";
		System.out.println("Enter the list of classes.");
		boolean isActive = true;
		while (isActive) {
			System.out.print("Class name: ");
			s = kb.nextLine();
			if (s.equalsIgnoreCase("exit")) {
				myclasses.Print();
				isActive = false;
			} else
				myclasses.add(s);
		}
		kb.close();
	}
	
}