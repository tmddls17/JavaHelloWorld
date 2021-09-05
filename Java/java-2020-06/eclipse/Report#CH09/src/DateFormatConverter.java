import java.util.Scanner;
import java.util.StringTokenizer;

public class DateFormatConverter {
	private static int month; // '월'의 값을 저장할 int 변수
	private static int day; // '일'의 값을 저장할 int 변수
	private static String dateformat; // 사용자에게 입력 받을 'mm/dd'형태의 String 변수
	private static String[] Month = { "January", "Febuary", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" }; // 각 월의 해당 영어 이름을 저장하고 있는 String Array

	public static class MonthException extends Exception {
		public MonthException() {
		}

		public MonthException(String message) {
			super(message); // Exception 클래스의 message를 가져와 사용
		}
	} // 사용자 정의 Exception인 MonthException 클래스

	public static class DayException extends Exception {
		public DayException() {
		}

		public DayException(String message) {
			super(message); // Exception 클래스의 message를 가져와 사용
		}
	} // 사용자 정의 Exception인 DayException 클래스

	public static void Runprogram() {
		//사용자에게 입력받은 값의 범위가 적절하면 형태를 변환하여 출력, 아니라면 각 상황에 맞게 사용자정의 Exception을 발생
		try {
			if (month > 12) {
				throw new MonthException(); // month의 값이 12를 초과할 경우 MonthException을 발생
			} else if (month >= 1 && month <= 12) {
				try {
					if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
							|| month == 12) {
						if (day >= 1 && day <= 31) {
							System.out.println(dateformat + " is " + Month[month - 1] + " " + day + "\n");
							// 알맞은 범위 내애 값을 입력 받았다면 지정된 형식에 맞게 값을 변환하여 출력
						} else {
							throw new DayException("1 through 31 only, please.\n");
						} // month의 값이 1, 3, 5, 7, 8, 10 일 때 day 값이 지정된 범위를 벗어나면 DayException 발생
					} else if (month == 2) {
						if (day >= 1 && day <= 28) {
							System.out.println(dateformat + " is " + Month[month - 1] + " " + day + "\n");
							// 알맞은 범위 내애 값을 입력 받았다면 지정된 형식에 맞게 값을 변환하여 출력
						} else {
							throw new DayException("1 through 28 only, please.\n");
						} // month의 값이 2 일 때 day 값이 지정된 범위를 벗어나면 DayException 발생
					} else if (month == 4 || month == 6 || month == 9 || month == 11) {
						if (day >= 1 && day <= 30) {
							System.out.println(dateformat + " is " + Month[month - 1] + " " + day + "\n");
							// 알맞은 범위 내애 값을 입력 받았다면 지정된 형식에 맞게 값을 변환하여 출력
						} else {
							throw new DayException("1 through 30 only, please.\n");
						} // month의 값이 4, 6, 9, 11 일 때 day 값이 지정된 범위를 벗어나면 DayException 발생
					}
				} catch (DayException e) {
					System.out.println("You have entered invalid day for month number " + month + "\n");
				} // DayException이 발생한 경우 프로그램이 계속적으로 구동되도록 catch 함
			}
		} catch (MonthException e) {
			System.out.println(month + " is invalid: month number must be 1 to 12.\n");
		} // MonthException이 발생한 경우 프로그램이 계속적으로 구동되도록 catch 함
	}

	public static void main(String[] args) {

		String YorN; // 사용자에게 입력받아 프로그램 반복여부를 결정하는 변수 
		char keep; // 사용자에게 입력받은 YorN값을 char 형태로 저장하는 변수

		Scanner kb = new Scanner(System.in);
		do {
			System.out.println("Enter a date in numerical month/day format:");
			dateformat = kb.nextLine();
			// 사용자에게 형태를 변환시킬 초기 값을 입력 받는 단계
			StringTokenizer tk = new StringTokenizer(dateformat, "/");
			// 사용자에게 입력받은 dateformat을 /을 기준으로 나누는 단계
			month = Integer.parseInt(tk.nextToken());
			day = Integer.parseInt(tk.nextToken());
			// Tokenizer를 통해 나뉜 각 토큰을 month와 day에 저장
			Runprogram();
			// 사용자에게 입력받은 값이 알맞은 범위에 해당하는지 확인하는 단계
			System.out.println("Again?(y/n)");
			YorN = kb.next();
			kb.nextLine();
			// 사용자에게 프로그램의 반복 여부를 묻는 단계
			keep = YorN.charAt(0);
		} while (keep == 'y');
	}

}
