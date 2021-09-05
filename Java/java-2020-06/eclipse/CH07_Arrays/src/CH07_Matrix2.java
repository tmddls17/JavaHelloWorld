public class CH07_Matrix2 {
	private static int input = 0;
	private static int i = 0, j = 0, k = 0;

	public static void makeMatrix2(int[][] a) {
		input = 1;
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < a[i].length; j++) {
				a[i][j] = input;
				input++;
			}
		}
	}

	public static void addition(int[][] a, int[][] b) {
		int column = a.length;
		int low = a[0].length;
		int[][] N = new int[column][low];
		System.out.println("Matrix addition is ..");
		for (i = 0; i < column; i++) {
			for (j = 0; j < low; j++) {
				N[i][j] = a[i][j] + b[i][j];
				System.out.print(N[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void subtraction(int[][] a, int[][] b) {
		int column = a.length;
		int low = a[0].length;
		int[][] N = new int[column][low];
		System.out.println("Matrix subtraction is ..");
		for (i = 0; i < column; i++) {
			for (j = 0; j < low; j++) {
				N[i][j] = a[i][j] - b[i][j];
				System.out.print(N[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void multiplication(int[][] a, int[][] b) {
		int column = a.length;
		int low = a[0].length;
		int[][] N = new int[column][low];
		System.out.println("Matrix multiplication is ..");
		for (i = 0; i < column; i++) {
			for (j = 0; j < low; j++) {
				N[i][j] = 0;
				for (k = 0; k < low; k++) {
					N[i][j] += (a[i][k] * b[j][k]);
				}
				System.out.print(N[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] A = new int[3][3];
		int[][] B = new int[3][3];
		CH07_Matrix2.makeMatrix2(A);
		CH07_Matrix.makeMatrix(B);
// Print A, B, C
		System.out.println("\nMatrix A is ..");
		CH07_Matrix.printMatrix(A);
		System.out.println("\nMatrix B is ..");
		CH07_Matrix.printMatrix(B);
		CH07_Matrix2.addition(A, B);
		CH07_Matrix2.subtraction(A, B);
		CH07_Matrix2.multiplication(A, B);
	}
}