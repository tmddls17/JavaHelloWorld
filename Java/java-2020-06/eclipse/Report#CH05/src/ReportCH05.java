import java.util.*;
public class ReportCH05 {
	public static void main(String[] args) {
		Hangman game = new Hangman();
		game.getSecretWord("Happiness");
		System.out.println("Let's play a round of hangman.");
		game.Playgame();
		
		game.getSecretWord("I'll be back.");
		System.out.println("\nLet's play a second round of hangman.");
		game.Playgame();
	}
}
