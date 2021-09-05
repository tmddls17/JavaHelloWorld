import java.util.*;

public class Hangman {
	private String secretWord;
	private String disguisedWord;
	private int guess = 0;
	private int wrong = 0;
	private int TorF;
	private char[] Word;
	private char[] Dis;

	public String getSecretWord(String s) {
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		s = s.replaceAll(match, "");
		s = s.replaceAll(" ", "");
		return secretWord = s;
	}

	public String getDisguisedWord() {
		disguisedWord = secretWord.replaceAll(".", "?");
		return disguisedWord;
	}

	public void makeGuess(char C) {
		int i = 0;
		int length = secretWord.length();
		for (i = 0; i < length; i++) {
			if (C == Word[i]) {
				Dis[i] = C;
				TorF = 1;
			} else if (TorF == 0)
				TorF = -1;
		}
	}

	public int getGuessCount(int a) {
		if (a == 1)
			return guess++;
		else if (a == -1)
			return wrong++;
		return a;
	}

	public boolean isFound(int a) {
		if (a == 1)
			return TorF == 1;
		else if (a == -1)
			return TorF == -1;
		return false;
	}

	public void Playgame() {
		int i = 0;
		int length = secretWord.length();
		Word = new char[length];
		Dis = new char[length];
		getDisguisedWord();
		for (i = 0; i < length; i++) {
			Word[i] = (secretWord.charAt(i));
			Word[i] = Character.toLowerCase(Word[i]);
			Dis[i] = (disguisedWord.charAt(i));
		}
		System.out.println("We are playing hangman\n");
		guess = 0;
		wrong = 0;
		do {
			TorF = 0;
			Scanner keyboard = new Scanner(System.in);
			System.out.println("The disguised word is <" + disguisedWord + ">\nGuess a letter");
			String A = keyboard.nextLine();
			char G = A.charAt(0);
			makeGuess(G);
			if (isFound(TorF))
				getGuessCount(TorF);
			else if (isFound(TorF))
				getGuessCount(TorF);
			System.out.println("Guesses made " + guess + " with " + wrong + " wrong\n");
			disguisedWord = String.valueOf(Dis);
		} while (disguisedWord.contains("?"));
		System.out.println("Congratulation, you found the secret word");
	}
}
