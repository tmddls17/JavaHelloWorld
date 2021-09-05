public class CH07_Matrix {
	public static void makeMatrix(int[][] a)	{
		int i = 0, j = 0;
		int input = 0;
		
		for(i = 0; i < a.length; i++) {
			input = i;
			for(j = 0; j < a[i].length; j++) {
				a[i][j] = input;
				input++;
			}
		}
	}
	public static void printMatrix(int[][] a) {
		int i = 0, j = 0;
		
		for(i = 0; i < a.length; i++) {
			for(j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();			
		}
	}
	public static void main(String[] args) {
		int[][] A = new int[3][5];
		int[][] B = new int[5][3];
		int[][] C = new int[3][3];
		CH07_Matrix.makeMatrix(A);
		CH07_Matrix.makeMatrix(B);
		CH07_Matrix.makeMatrix(C);
// Print A, B, C
		System.out.println("\nMatrix A is ..");
		CH07_Matrix.printMatrix(A);
		System.out.println("\nMatrix B is ..");
		CH07_Matrix.printMatrix(B);
		System.out.println("\nMatrix C is ..");
		CH07_Matrix.printMatrix(C);
	}
}