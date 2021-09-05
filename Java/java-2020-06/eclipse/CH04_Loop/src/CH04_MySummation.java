import java.util.Scanner;
public class CH04_MySummation {
	public static void main(String[] args)	{
		int sum = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("Please input a number:");
		int input = s.nextInt();
		for(int i = 1; i <= input; i++)	{
			sum+=i;
		}
		System.out.println("The summation from 1 to " + input + " is " + sum);
	}

}
