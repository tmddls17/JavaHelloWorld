import java.util.*;
public class MyStringDemo {
	public static void main(String[] args) 
	{
		String sentence = "Jesus Christ Is My Savior";
		int position = sentence.indexOf("Savior");
		System.out.println(sentence);
		System.out.println("012345678901234567890123456");
		System.out.println("The word \"Savior\" starts at index " + position);
		sentence = sentence.substring(0, position) + "friend";
		System.out.println("The changed string is:");
		System.out.println(sentence);
		
		sentence = sentence.replace("friend", "joy");
		sentence = sentence.toUpperCase();
		System.out.println("The changed string is:");
		System.out.println(sentence);
	}
}
