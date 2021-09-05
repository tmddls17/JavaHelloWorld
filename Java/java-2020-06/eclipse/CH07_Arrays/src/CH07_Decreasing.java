public class CH07_Decreasing {
	public static boolean isStrictlyDecreasing(int[] dc) {
		int length = dc.length;
		int TorF = 0;
		for (int i = 0; i < length; i++) {
			if (i <= length - 2) {
				if (dc[i] <= dc[i + 1])
					TorF += 1;
			}
		}
		if (TorF == 0)
			return true;

		return false;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 4, 5, 7 };
		int[] arr2 = { 5, 2, 3, 9, 9 };
		int[] arr3 = { 15, 13, 12, 9, 4 };
		int[] arr4 = { 28, 23, 13, 12, 2 };
		int[] arr5 = { 33, 44, 22, 55, 11 };
		System.out.println(
				"Array1 (1,2,4,5,7) is not in decreasing order, should be FALSE:" + isStrictlyDecreasing(arr1));
		System.out.println("Array2 (5,2,3,9,9) is not decreasing, should beFALSE: " + isStrictlyDecreasing(arr2));
		System.out.println("Array3 (15,13,12,9,4) is decreasing, should beTRUE: " + isStrictlyDecreasing(arr3));
		System.out.println("Array4 (28,23,13,12,2) is decreasing, should beTRUE: " + isStrictlyDecreasing(arr4));
		System.out.println("Array5 (33,44,22,55,11) is not decreasing,should be FALSE: " + isStrictlyDecreasing(arr5));
	}
}