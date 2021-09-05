import java.util.Scanner;
public class TemperatureTest {
	private double degree;
	private char scale;

	TemperatureTest() {
		degree = 0.0;
		scale = 'C';
	}

	TemperatureTest(double inputdegree) {
		degree = inputdegree;
		scale = 'C';
	}

	TemperatureTest(char inputscale) {
		degree = 0.0;
		scale = inputscale;
	}

	TemperatureTest(double inputdegree, char inputscale) {
		degree = inputdegree;
		scale = inputscale;
	}

	public void writeOutput() {
		if (scale == 'C' || scale == 'c') {
			System.out.println(degree + " degrees Celsius");
		} else if (scale == 'F' || scale == 'f') {
			System.out.println(degree + " degrees Fahrenheit");
		}
	}

	public void readInput() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("input the degree");
		degree = keyboard.nextDouble();
		System.out.println("input the scale");
		scale = keyboard.next().charAt(0);
	}

	public void writeC() {
		String num;
		double changedegree = 0.0;
		if (scale == 'F' || scale == 'f') {
			changedegree = 5 * (degree - 32) / 9.0;
		} else if (scale == 'C' || scale == 'c')
			changedegree = degree;
		num = String.format("%.1f", changedegree);
		System.out.println(num + " degrees Celsius");
	}

	public void writeF() {
		String num;
		double changedegree = 0.0;
		if (scale == 'C' || scale == 'c') {
			changedegree = (degree * (5 / 9)) + 32;
		} else if (scale == 'F' || scale == 'f')
			changedegree = degree;
		num = String.format("%.1f", changedegree);
		System.out.println(num + " degrees Fahrenheit");
	}

	public String getF() {
		double F = 0;
		String num;
		if (scale == 'C' || scale == 'c') {
			F = (degree * (5 / 9)) + 32;
		} else if (scale == 'F' || scale == 'f')
			F = degree;
		num = String.format("%.1f", F);
		return num;
	}

	public String getC() {
		double C = 0;
		String num;
		if (scale == 'F' || scale == 'f') {
			C = 5 * (degree - 32) / 9.0;
		} else if (scale == 'C' || scale == 'c')
			C = degree;
		num = String.format("%.1f", C);
		return num;
	}

	public void set(double inputdegree) {
		degree = inputdegree;
	}

	public void set(char inputscale) {
		scale = inputscale;
	}

	public void set(double inputdegree, char inputscale) {
		degree = inputdegree;
		scale = inputscale;
	}

	public boolean isGreaterThan(TemperatureTest T) {
		if ((scale == 'C' || scale == 'c') && (T.scale == 'F' || T.scale == 'f')) {
			T.degree = 5 * (T.degree - 32) / 9.0;
		} else if ((scale == 'F' || scale == 'f') && (T.scale == 'C' || T.scale == 'c')) {
			T.degree = (T.degree * (5 / 9)) + 32;
		}
		if (degree > T.degree)
			return true;
		return false;

	}

	public boolean isLessThan(TemperatureTest T) {
		if ((scale == 'C' || scale == 'c') && (T.scale == 'F' || T.scale == 'f')) {
			T.degree = 5 * (T.degree - 32) / 9.0;
		} else if ((scale == 'F' || scale == 'f') && (T.scale == 'C' || T.scale == 'c')) {
			T.degree = (T.degree * (5 / 9)) + 32;
		}
		if (degree < T.degree)
			return true;
		return false;

	}

	public boolean equals(TemperatureTest T) {
		if ((scale == 'C' || scale == 'c') && (T.scale == 'F' || T.scale == 'f')) {
			T.degree = 5 * (T.degree - 32) / 9.0;
		} else if ((scale == 'F' || scale == 'f') && (T.scale == 'C' || T.scale == 'c')) {
			T.degree = (T.degree * (5 / 9)) + 32;
		}
		if (degree == T.degree)
			return true;

		return false;
	}

	public static void main(String[] args) {
		System.out.println();
		System.out.println("Test case 1: default constructor and");
		System.out.println("writeOutput() method.");
		System.out.println();
		TemperatureTest t1 = new TemperatureTest();
		System.out.println("Results of default constructor:");
		System.out.println("Verify 0 degrees C.");
		System.out.println();
		t1.writeOutput();
		System.out.println();
		System.out.println("==========================================");

		System.out.println("Test case 2: readInput() method.");
		t1.readInput();
		System.out.println();
		System.out.println("Verify temperature and units:");
		System.out.println("Should be whatever you just entered.");
		System.out.println();
		t1.writeOutput();
		System.out.println();
		System.out.println("==========================================");

		System.out.println("Test case 3: constructor with just temperature.");
		TemperatureTest t2 = new TemperatureTest(20.5);
		System.out.println();
		System.out.println("Verify 20.5 degrees C.");
		System.out.println();
		t2.writeOutput();
		System.out.println();
		System.out.println("==========================================");

		System.out.println("Test case 4: constructor with just units, f.");
		System.out.println();
		System.out.println("Verify 0 degrees f.");
		System.out.println();
		TemperatureTest t3 = new TemperatureTest('f');
		t3.writeOutput();
		System.out.println();
		System.out.println("==========================================");

		System.out.println("Test case 5: constructor with just units, c.");
		System.out.println();
		System.out.println("Verify 0 degrees c.");
		System.out.println();
		TemperatureTest t4 = new TemperatureTest('c');
		t4.writeOutput();
		System.out.println();
		System.out.println("==========================================");

		System.out.println("Test case 6: constructor with temperature and units.");
		System.out.println();
		System.out.println("Verify -51.2 degrees F.");
		System.out.println();
		TemperatureTest t5 = new TemperatureTest(-51.2, 'F');
		t5.writeOutput();
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 7: read degrees C, original in F.");
		System.out.println();
		System.out.println("Verify -46.2 degrees Celsius.");
		System.out.println();
		t5.writeC();
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 8: read degrees C, original in C.");
		System.out.println();
		System.out.println("Verify 0 degrees Celsius.");
		System.out.println();
		t4.writeC();
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 9: read degrees F, oringinal in C.");
		System.out.println();
		System.out.println("Verify 32 degrees Fahrenheit");
		System.out.println();
		t4.writeF();
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 10: read degrees F, oringinal in F.");
		System.out.println();
		System.out.println("Verify -51.2 degrees Fahrenheit");
		System.out.println();
		t5.writeF();
		System.out.println();
		System.out.println("Hit enter to continue.");
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 11: getF method with original temperature in F.");
		System.out.println();
		System.out.println("Verify -51.2");
		System.out.println();
		System.out.println(t5.getF());
		System.out.println();
		System.out.println("Hit enter to continue.");
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 12: getF method with original temperature in C.");
		System.out.println("Verify 32");
		System.out.println();
		System.out.println(t4.getF());
		System.out.println();
		System.out.println("Hit enter to continue.");
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 13: getC method with original temperature in F.");
		System.out.println("Verify -46.2");
		System.out.println();
		System.out.println(t5.getC());
		System.out.println();
		System.out.println("Hit enter to continue.");
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 14: getC method with original temperature in C.");
		System.out.println("Verify 0");
		System.out.println();
		System.out.println(t4.getC());
		System.out.println();
		System.out.println("Hit enter to continue.");
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 15: set method for both parameters.");
		System.out.println("t5 before:");
		t5.writeOutput();
		t5.set(72.8, 'C');
		System.out.println("After set: verify 72.8 degrees C.");
		System.out.println();
		t5.writeOutput();
		System.out.println();
		System.out.println("Hit enter to continue.");
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 16: set method for just temperature.");
		System.out.println("t5 before:");
		t5.writeOutput();
		t5.set(100, 'C');
		System.out.println("After set: verify 100 degrees C.");
		System.out.println();
		t5.writeOutput();
		System.out.println();
		System.out.println("Hit enter to continue.");
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 17: set method for just units.");
		System.out.println("t5 before:");
		t5.writeOutput();
		t5.set('F');
		System.out.println("After set: verify 100 degrees F.");
		System.out.println();
		t5.writeOutput();
		System.out.println();
		System.out.println("Hit enter to continue.");
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 18: equals test 1.");
		System.out.println();
		t1.set(100, 'C');
		t2.set(212, 'F');
		System.out.println("T1 = 100 degrees C.");
		System.out.println("T2 = 212 degrees F.");
		System.out.println();
		System.out.println("Here are the two temperatures converted to degrees C:");
		t1.writeC();
		t2.writeC();
		System.out.println();
		System.out.println("Verify results: should be true.");
		System.out.println();
		System.out.println(t1.equals(t2));
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 19: equals test 2.");
		System.out.println();
		t1.set(100.1);
		System.out.println("T1 changed to 100.1 degrees C.");
		System.out.println("T2 = 212 degrees F.");
		System.out.println();
		System.out.println("Here are the two temperatures in degrees C:");
		t1.writeC();
		t2.writeC();
		System.out.println();
		System.out.println("Verify results: should be false.");
		System.out.println();
		System.out.println(t1.equals(t2));
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 20: equals test 3.");
		System.out.println();
		t1.set(100);
		t2.set(212.1);
		System.out.println("T1 changed back to 100 degrees C.");
		System.out.println("T2 = 212.1 degrees F.");
		System.out.println();
		System.out.println("Here are the two temperatures in degrees C:");
		t1.writeC();
		t2.writeC();
		System.out.println();
		System.out.println("Verify results: should be false.");
		System.out.println();
		System.out.println(t1.equals(t2));
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 21: isGreaterThan test 1.");
		System.out.println();
		t1.set(100, 'C');
		t2.set(212, 'F');
		System.out.println("T1 = 100 degrees C.");
		System.out.println("T2 = 212 degrees F.");
		System.out.println();
		System.out.println("Here are the two temperatures converted to degrees C:");
		t1.writeC();
		t2.writeC();
		System.out.println();
		System.out.println("Verify results: should be false.");
		System.out.println();
		System.out.println(t1.isGreaterThan(t2));
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 22: isGreaterThan test 2.");
		System.out.println();
		t1.set(100.1);
		System.out.println("T1 changed to 100.1 degrees C.");
		System.out.println("T2 = 212 degrees F.");
		System.out.println();
		System.out.println("Here are the two temperatures in degrees C:");
		t1.writeC();
		t2.writeC();
		System.out.println();
		System.out.println("Verify results: should be true.");
		System.out.println();
		System.out.println(t1.isGreaterThan(t2));
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 23: isGreaterThan test 3.");
		System.out.println();
		t1.set(100);
		t2.set(212.1);
		System.out.println("T1 changed back to 100 degrees C.");
		System.out.println("T2 = 212.1 degrees F.");
		System.out.println();
		System.out.println("Here are the two temperatures in degrees C:");
		t1.writeC();
		t2.writeC();
		System.out.println();
		System.out.println("Verify results: should be false.");
		System.out.println();
		System.out.println(t1.isGreaterThan(t2));
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 24: isLessThan test 1.");
		System.out.println();
		t1.set(100, 'C');
		t2.set(212, 'F');
		System.out.println("T1 = 100 degrees C.");
		System.out.println("T2 = 212 degrees F.");
		System.out.println();
		System.out.println("Here are the two temperatures converted to degrees C:");
		t1.writeC();
		t2.writeC();
		System.out.println();
		System.out.println("Verify results: should be false.");
		System.out.println();
		System.out.println(t1.isLessThan(t2));
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 25: isLessThan test 2.");
		System.out.println();
		t1.set(100.1);
		System.out.println("T1 changed to 100.1 degrees C.");
		System.out.println("T2 = 212 degrees F.");
		System.out.println();
		System.out.println("Here are the two temperatures in degrees C:");
		t1.writeC();
		t2.writeC();
		System.out.println();
		System.out.println("Verify results: should be false.");
		System.out.println();
		System.out.println(t1.isLessThan(t2));
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test case 26: isLessThan test 3.");
		System.out.println();
		t1.set(100);
		t2.set(212.1);
		System.out.println("T1 changed back to 100 degrees C.");
		System.out.println("T2 = 212.1 degrees F.");
		System.out.println();
		System.out.println("Here are the two temperatures in degrees C:");
		t1.writeC();
		t2.writeC();
		System.out.println();
		System.out.println("Verify results: should be true.");
		System.out.println();
		System.out.println(t1.isLessThan(t2));
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test Case 27: is 0 degrees C = 32 degrees F?");
		System.out.println();
		t1.set(0, 'C');
		t2.set(32, 'F');
		System.out.println("Here are the two temperatures:");
		System.out.println();
		t1.writeOutput();
		t2.writeOutput();
		System.out.println();
		System.out.println("Verify results: should be true.");
		System.out.println();
		System.out.println(t1.equals(t2));
		System.out.println();
		System.out.println("==========================================");

		System.out.println();
		System.out.println("Test Case 28: is -40 degrees C = -40 degrees F?");
		System.out.println();
		t1.set(-40, 'C');
		t2.set(-40, 'F');
		System.out.println("Here are the two temperatures:");
		System.out.println();
		t1.writeOutput();
		t2.writeOutput();
		System.out.println();
		System.out.println("Verify results: should be true.");
		System.out.println();
		System.out.println(t1.equals(t2));
		System.out.println();
	}
}
