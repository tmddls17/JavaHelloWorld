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
		if (str.length() <= 1) { // 길이가 1인 단어이거나 길이가 1이 되기까지 false가 return 되지 않았으므로 true
			return true;
		}
		else if (str1.contentEquals(str2) == false) { // 첫 글자와 마지막 글자가 다른 값을 가지면 false
			return false;
		} else
			return checkPalindrome(middleString(str)); // 단어 길이가 1이 아니므로 재귀
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
