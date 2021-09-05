import java.util.Scanner;

public class Fibonacci {
	private static int Integer; // ����� �Ǻ���ġ ������ ����
	private static int Fibonacci; // �Ǻ���ġ ���� �����ϴ� ����
	private static float ratio; // �Ǻ���ġ ���� �������� �����ϴ� ����

	public static int setFibo(int a) {
		if (a <= 1) {
			return 0;
		} else if (a == 2) {
			return 1;
		} else
			return setFibo(a - 2) + setFibo(a - 1);
		// ��ȭ���� ���ǹ����� �Űܼ� ������ ��� �޼���
	}
	// ��͸� ���ؼ� �Ǻ���ġ ���� ����Ѵ�.

	public static void main(String[] args) {
		char Again;	
		int i = 0;
		Scanner kb = new Scanner(System.in);
		do {
			System.out.println("How many Fibonacci numbers do you want to use?");
			System.out.println("Enter a positive integer: ");
			Integer = kb.nextInt();
			// ����ڿ��� ����� �Ǻ���ġ ������ ������ �Է� �޴´�.
			System.out.println("Here is the Fibonacci series and ratio of current\n" + "number to previous number for "
					+ Integer + " Fibonacci numbers:");
			for (i = 1; i <= Integer; i++) {
				Fibonacci = setFibo(i);
				// for�ݺ����� ���Ͽ� 1���� Integer������ �Ǻ���ġ ���� ���Ѵ�.
				if (i < 3) {
					System.out.println("Fibonacci #" + i + " = " + Fibonacci);
				}
				// 2��° �Ǻ���ġ �������� ���� ������ ������ ���� ���� �����Ƿ� �Ǻ���ġ ���� ����Ѵ�.
				if (i >= 3) {
					ratio = (float) setFibo(i) / (float) setFibo(i - 1);
					System.out.println("Fibonacci #" + i + " = " + Fibonacci + " and ratio = " + setFibo(i) + "/"
							+ setFibo(i - 1) + " = " + ratio);
				}
				// 3��° �Ǻ���ġ ������ ���� ������ ������ ���� �� �ֱ⿡ �Ǻ���ġ ���� ������ ���� ����Ѵ�.
			}
			System.out.println("Do again? Enter 'y' for yes.");
			Again = kb.next().charAt(0);
			// ����ڿ��� ��ü ���α׷��� �ݺ����� ���θ� ���´�. �� ��, charAt()�� ���Ͽ� �Է¹��� ���� char������ �����Ѵ�.
		} while (Again == 'y');
		// �Է¹��� ���� 'y'�� ��� �ݺ��Ѵ�.
	}
}
