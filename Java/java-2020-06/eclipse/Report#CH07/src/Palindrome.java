import java.util.*;

public class Palindrome {
	public static final int MAX_CHARS = 80;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("This program will test whatever text");
		System.out.println("you enter to see if is a palindrome");
		System.out.println("(reads the same backwards and forwards).");
		System.out.println();
		System.out.println("Enter text (just leters and blanks, please.");
		String phrase = keyboard.nextLine();
		System.out.println();
		if (phrase.length() > MAX_CHARS)// Exit: too many characters.
		{
			System.out.println();
			System.out.println("Too many characters: maximum is 50.");
		} else // Not too many characters: test for palindrome.
		{
			if (palindrome(phrase))
				System.out.println("YES, the phrase is a palindrome!");
			else
				System.out.println("NO, the phrase is NOT a palindrome.");
		}
	}
	public static boolean palindrome(String text) {
		int i = 0;
		int length = 0;
		int TorF = 0;
		char[] SaveText = new char[80];
		char[] CheckText = new char[80];
		text = text.toLowerCase();
		text = text.replaceAll(" ", "");
		SaveText = text.toCharArray();
		length = text.length();
		for (i = 0; i < length; i++) {
			CheckText[i] = SaveText[length - i - 1];
		}
		for (i = 0; i < length; i++) {
			if (SaveText[i] == CheckText[i])
				TorF++;
		}
		if (TorF == length)
			return true;
		else
			return false;
	}
}