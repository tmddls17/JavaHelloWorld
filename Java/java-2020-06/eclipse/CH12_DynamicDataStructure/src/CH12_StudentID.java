import java.util.*;

public class CH12_StudentID {
	private static HashMap<Integer, ArrayList<String>> students = new HashMap<Integer, ArrayList<String>>();

	public static void main(String[] args) {
		String data;
		int ID;
		int keep = 0;
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter data in the format: ID CourseNum");
		System.out.println("Enter -1 to end.");
		do {
			data = kb.nextLine();
			if (data.contains("-1"))
				keep = Integer.parseInt(data.substring(0, 2));
			if (keep != -1) {
				StringTokenizer tk = new StringTokenizer(data);
				String token = tk.nextToken(" ");
				ID = Integer.parseInt(token);
				String name = tk.nextToken("\n");
				ArrayList<String> Course = new ArrayList<String>();
				if (students.containsKey(ID)) {
	                Course = students.get(ID);
	                Course.add(name);                
	            }else {
	                Course.add(name);
	            }
	            students.put(ID,Course);
			}
		} while (keep != -1);
		for( Integer key : students.keySet() ){
		    ArrayList<String> value = students.get(key);
		    System.out.println( "Students: "+ key + "\n" + value);
		}
		
	}
}
