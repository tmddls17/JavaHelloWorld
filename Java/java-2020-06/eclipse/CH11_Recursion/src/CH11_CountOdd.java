import java.io.*;
import java.util.*;

public class CH11_CountOdd {
	private static long count = 0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer value: ");
		long number = input.nextLong();
		System.out.println("The number of odd digits in the number is " + countOdd(number));
	}

public static long countOdd(long number){
	String longData;
	int checkOdd;
	long new_number;
	longData = String.valueOf(number);
	checkOdd = Integer.parseInt(longData.substring(0,1));
	if(checkOdd != 0 && checkOdd%2 != 0) {
		count++;
	}
	longData = longData.substring(1,longData.length());
	new_number = Long.parseLong(longData);
	if(longData.length() == 1) {
		checkOdd = Integer.parseInt(longData.substring(0,1));
		if(checkOdd != 0 && checkOdd%2 != 0) {
			count++;
		}
		return count;
	}
	else
		return countOdd(new_number);
}
}