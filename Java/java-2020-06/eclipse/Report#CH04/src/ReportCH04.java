import java.util.*;
public class ReportCH04 {
	public static void main(String[] args)	{
		int N = 0;
		int N2 = 0;
		int N3 = 0;
		int i = 0, j = 0;
		Scanner s = new Scanner(System.in);
		
		System.out.print("Input your number: ");
		N = s.nextInt();
		N2 = N;
		for(i = 1; i <= N; i++)	{
			for(j = 1; j < N2; j++)	{
				System.out.print("  ");
			}
			N2--;
			for(j = 1; j <= i; j++)	{
				System.out.print(j + " ");
			}
			N3 = i - 1;
			if(i >= 2)	{
				for(j = 1; j < i; j++)	{
					System.out.print(N3 + " ");
					N3--;
				}
			}
			
			System.out.println();
		}
	}
}
