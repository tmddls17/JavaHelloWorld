import java.util.*;
public class MyFtoC {
	public static void main(String args[])
	{
	  	Scanner s = new Scanner(System.in);
	    System.out.print("Enter a temperature (integer number, no fractional part) in degrees Fahrenheit\n");
	    int f_degree = s.nextInt();
	    double c_degree = 5 * (f_degree-32) / 9.0;
	  	System.out.println(f_degree + " degrees Fahrenheit = " + c_degree + " degrees Celsius");
	}
}
