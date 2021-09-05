import java.util.Scanner;

public class CH11_Palindrome_main {
	private static String userInput;

	public static void main(String[] args) {
		String testWord;
		Scanner kb = new Scanner(System.in);

		System.out.println("Enter a string: ");
		userInput = kb.nextLine();
		testWord = userInput.replaceAll(" ", "");
		testWord = testWord.toLowerCase();
		if (checkPalindrome(testWord)) {
			System.out.println(userInput + " is a palindrome.");
		} else
			System.out.println(userInput + " is not a palindrome.");
	}

	public static boolean checkPalindrome(String str) {
		String str1 = firstCharacter(str);
		String str2 = lastCharacter(str);
		if (str.length() <= 1) { // ���̰� 1�� �ܾ��̰ų� ���̰� 1�� �Ǳ���� false�� return ���� �ʾ����Ƿ� true
			return true;
		}
		else if (str1.contentEquals(str2) == false) { // ù ���ڿ� ������ ���ڰ� �ٸ� ���� ������ false
			return false;
		} else
			return checkPalindrome(middleString(str)); // �ܾ� ���̰� 1�� �ƴϹǷ� ���
	}

	public static String middleString(String str) {
		str = str.substring(1, str.length() - 1);
		return str;
	}

	public static String firstCharacter(String str) {
		str = str.substring(0, 1);
		return str;
	}

	public static String lastCharacter(String str) {
		str = str.substring(str.length() - 1,str.length());
		return str;
	}
}
