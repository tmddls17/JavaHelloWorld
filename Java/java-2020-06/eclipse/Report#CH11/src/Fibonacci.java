import java.util.Scanner;

public class Fibonacci {
	private static int Integer; // 출력할 피보나치 수열의 개수
	private static int Fibonacci; // 피보나치 수를 저장하는 변수
	private static float ratio; // 피보나치 수의 증가율을 저장하는 변수

	public static int setFibo(int a) {
		if (a <= 1) {
			return 0;
		} else if (a == 2) {
			return 1;
		} else
			return setFibo(a - 2) + setFibo(a - 1);
		// 점화식을 조건문으로 옮겨서 구현한 재귀 메서드
	}
	// 재귀를 통해서 피보나치 수를 출력한다.

	public static void main(String[] args) {
		char Again;	
		int i = 0;
		Scanner kb = new Scanner(System.in);
		do {
			System.out.println("How many Fibonacci numbers do you want to use?");
			System.out.println("Enter a positive integer: ");
			Integer = kb.nextInt();
			// 사용자에게 출력할 피보나치 수열의 개수를 입력 받는다.
			System.out.println("Here is the Fibonacci series and ratio of current\n" + "number to previous number for "
					+ Integer + " Fibonacci numbers:");
			for (i = 1; i <= Integer; i++) {
				Fibonacci = setFibo(i);
				// for반복문을 통하여 1부터 Integer까지의 피보나치 수를 구한다.
				if (i < 3) {
					System.out.println("Fibonacci #" + i + " = " + Fibonacci);
				}
				// 2번째 피보나치 수까지는 이전 수와의 비율을 구할 수가 없으므로 피보나치 수만 출력한다.
				if (i >= 3) {
					ratio = (float) setFibo(i) / (float) setFibo(i - 1);
					System.out.println("Fibonacci #" + i + " = " + Fibonacci + " and ratio = " + setFibo(i) + "/"
							+ setFibo(i - 1) + " = " + ratio);
				}
				// 3번째 피보나치 수부터 이전 수와의 비율을 구할 수 있기에 피보나치 수와 비율을 같이 출력한다.
			}
			System.out.println("Do again? Enter 'y' for yes.");
			Again = kb.next().charAt(0);
			// 사용자에게 전체 프로그램을 반복할지 여부를 묻는다. 이 때, charAt()을 통하여 입력받은 값을 char형으로 저장한다.
		} while (Again == 'y');
		// 입력받은 값이 'y'일 경우 반복한다.
	}
}
