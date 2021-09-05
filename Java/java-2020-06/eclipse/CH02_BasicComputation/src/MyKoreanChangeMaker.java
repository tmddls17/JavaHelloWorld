import java.util.*;
public class MyKoreanChangeMaker {
	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	System.out.println("Enter a whole number from 1 to 10000.");
	int won = s.nextInt();
	System.out.println(won + " won in coins can be given as: ");
	
	int won_500 = won/500;
	won = won%500;
	int won_100 = won/100;
	won = won%100;
	int won_10 = won/10;
	won =won%10;
	int won_5 = won/5;
	won = won%5;
	int won_1 = won;
	
	System.out.println(won_500 + " 500 won\n" + won_100 + " 100 won\n" + won_10 + " 10 won\n" + won_5 + " 5 won\n" + won_1 + " 1 won");
	}
}
