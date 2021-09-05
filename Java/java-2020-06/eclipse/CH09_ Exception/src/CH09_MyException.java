import java.util.Scanner;

public class CH09_MyException extends Exception {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		try {
			String str = kb.nextLine();
			StringTest(str);
		} catch (CH09_MyException e) {
			System.out.println("String should not include\nspecial character $.");
		}
		kb.close();
	}

	static void StringTest(String str) throws CH09_MyException {

		if (str.contains("$")) {
			throw new CH09_MyException();
		} else
			System.out.println("String :" + str);

	}
}