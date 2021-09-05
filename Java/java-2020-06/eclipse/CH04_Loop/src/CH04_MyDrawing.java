import java.util.Scanner;
public class CH04_MyDrawing {
	public static void main(String[] args)	{
		int size = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("Please input a number:");
		size = s.nextInt();
		for(int i = 0; i < size; i++)	{
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = size; i > 0;i--){
			for(int j = 0; j < i; j++)	{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
