import java.util.*;
public class CH05_MyCalculator2 {
	private int a = 0;
	private int b = 0;
	public void getinput()	{
		printmenu();
		Scanner s = new Scanner(System.in);
		System.out.println("Type 1st Num: ");
		a = s.nextInt();
		System.out.println("Type 2st Num: ");
		b = s.nextInt();
	}
	public void printresult()	{
		System.out.println("a + b =  " + addition());
		System.out.println("a - b =  " + subtraction());
		System.out.println("a * b =  " + multiplication());
		System.out.println("a / b =  " + division());
	}
	private void printmenu()	{
		System.out.println("*** CH05_MyCalculator2 ***");
	}
	private double addition()	{
		double add;
		add = a + b;
		return add;
	}
	private double subtraction() {
		double sub;
		sub = a - b;
		return sub;
	}
	private double multiplication() {
		double multi;
		multi = a * b;
		return multi;
	}
	private double division()	{
		double div;
		div = a / b;
		return div;
	}
public static void main(String[] args) {
CH05_MyCalculator2 myCal2 = new CH05_MyCalculator2();
myCal2.getinput();
myCal2.printresult();
}
}