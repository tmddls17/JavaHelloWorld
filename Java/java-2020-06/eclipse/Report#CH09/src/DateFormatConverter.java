import java.util.Scanner;
import java.util.StringTokenizer;

public class DateFormatConverter {
	private static int month; // '��'�� ���� ������ int ����
	private static int day; // '��'�� ���� ������ int ����
	private static String dateformat; // ����ڿ��� �Է� ���� 'mm/dd'������ String ����
	private static String[] Month = { "January", "Febuary", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" }; // �� ���� �ش� ���� �̸��� �����ϰ� �ִ� String Array

	public static class MonthException extends Exception {
		public MonthException() {
		}

		public MonthException(String message) {
			super(message); // Exception Ŭ������ message�� ������ ���
		}
	} // ����� ���� Exception�� MonthException Ŭ����

	public static class DayException extends Exception {
		public DayException() {
		}

		public DayException(String message) {
			super(message); // Exception Ŭ������ message�� ������ ���
		}
	} // ����� ���� Exception�� DayException Ŭ����

	public static void Runprogram() {
		//����ڿ��� �Է¹��� ���� ������ �����ϸ� ���¸� ��ȯ�Ͽ� ���, �ƴ϶�� �� ��Ȳ�� �°� ��������� Exception�� �߻�
		try {
			if (month > 12) {
				throw new MonthException(); // month�� ���� 12�� �ʰ��� ��� MonthException�� �߻�
			} else if (month >= 1 && month <= 12) {
				try {
					if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
							|| month == 12) {
						if (day >= 1 && day <= 31) {
							System.out.println(dateformat + " is " + Month[month - 1] + " " + day + "\n");
							// �˸��� ���� ���� ���� �Է� �޾Ҵٸ� ������ ���Ŀ� �°� ���� ��ȯ�Ͽ� ���
						} else {
							throw new DayException("1 through 31 only, please.\n");
						} // month�� ���� 1, 3, 5, 7, 8, 10 �� �� day ���� ������ ������ ����� DayException �߻�
					} else if (month == 2) {
						if (day >= 1 && day <= 28) {
							System.out.println(dateformat + " is " + Month[month - 1] + " " + day + "\n");
							// �˸��� ���� ���� ���� �Է� �޾Ҵٸ� ������ ���Ŀ� �°� ���� ��ȯ�Ͽ� ���
						} else {
							throw new DayException("1 through 28 only, please.\n");
						} // month�� ���� 2 �� �� day ���� ������ ������ ����� DayException �߻�
					} else if (month == 4 || month == 6 || month == 9 || month == 11) {
						if (day >= 1 && day <= 30) {
							System.out.println(dateformat + " is " + Month[month - 1] + " " + day + "\n");
							// �˸��� ���� ���� ���� �Է� �޾Ҵٸ� ������ ���Ŀ� �°� ���� ��ȯ�Ͽ� ���
						} else {
							throw new DayException("1 through 30 only, please.\n");
						} // month�� ���� 4, 6, 9, 11 �� �� day ���� ������ ������ ����� DayException �߻�
					}
				} catch (DayException e) {
					System.out.println("You have entered invalid day for month number " + month + "\n");
				} // DayException�� �߻��� ��� ���α׷��� ��������� �����ǵ��� catch ��
			}
		} catch (MonthException e) {
			System.out.println(month + " is invalid: month number must be 1 to 12.\n");
		} // MonthException�� �߻��� ��� ���α׷��� ��������� �����ǵ��� catch ��
	}

	public static void main(String[] args) {

		String YorN; // ����ڿ��� �Է¹޾� ���α׷� �ݺ����θ� �����ϴ� ���� 
		char keep; // ����ڿ��� �Է¹��� YorN���� char ���·� �����ϴ� ����

		Scanner kb = new Scanner(System.in);
		do {
			System.out.println("Enter a date in numerical month/day format:");
			dateformat = kb.nextLine();
			// ����ڿ��� ���¸� ��ȯ��ų �ʱ� ���� �Է� �޴� �ܰ�
			StringTokenizer tk = new StringTokenizer(dateformat, "/");
			// ����ڿ��� �Է¹��� dateformat�� /�� �������� ������ �ܰ�
			month = Integer.parseInt(tk.nextToken());
			day = Integer.parseInt(tk.nextToken());
			// Tokenizer�� ���� ���� �� ��ū�� month�� day�� ����
			Runprogram();
			// ����ڿ��� �Է¹��� ���� �˸��� ������ �ش��ϴ��� Ȯ���ϴ� �ܰ�
			System.out.println("Again?(y/n)");
			YorN = kb.next();
			kb.nextLine();
			// ����ڿ��� ���α׷��� �ݺ� ���θ� ���� �ܰ�
			keep = YorN.charAt(0);
		} while (keep == 'y');
	}

}
