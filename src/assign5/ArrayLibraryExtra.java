package assign5;

/**
 * This class deals with vector matrix multiplication
 * 
 * @author James Yeates
 * 
 */
public class ArrayLibraryExtra {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix1 = { { 1, 2, 3 } };
		int[][] matrix2 = { { 1, 2, 3 }, { -4, -5, -6 }, { 7, 8, 9 },
				{ 2, 3, 4 } };
		int[][] matrix3 = { { 1, 2, 3 }, { -4, -5, -6 }, { 7, 8, 9, 11 },
				{ 2, 3, 4 } };
		int[] vector = { 1, 2, 3 };
		int[] vector2 = { 0, 0, 0 };
		int[] vector1 = { 1, 2, 3, 4 };

		if (!toString(matrixVectorMultiply(matrix2, vector)).equals(
				"{14, -32, 50, 20}"))
			System.out.println("failed at 1a");
		if (!toString(matrixVectorMultiply(matrix, vector)).equals(
				"{14, 32, 50}"))
			System.out.println("failed at 1b");
		if (!toString(matrixVectorMultiply(matrix1, vector2)).equals("{0}"))
			System.out.println("failed at 1c");

		// uncomment to throw exception
		// System.out.println(toString(matrixVectorMultiply(matrix2, vector1)));
		// uncomment to throw exception
		// System.out.println(toString(matrixVectorMultiply(matrix3, vector)));

		System.out.println("Testing Done");

	}

	/**
	 * This class performs matrix-vector Multiplication. To properly work the
	 * length of each inner array of the Multi dimensional array 'array' must be
	 * the same size as as the length of 'vector'. If not a runtime exception
	 * will be thrown.
	 * 
	 * 
	 * @param array
	 *            a two dimensional array containing integers
	 * @param vector
	 *            a one dimensional array containing integers
	 * @return an array with the result of matrix-vector Multiplication
	 */

	public static int[] matrixVectorMultiply(int[][] array, int[] vector) {

		// create a new one dimensional array assign it to how many
		// objects(arrays) it points to
		int[] newArray = new int[array.length];

		int intermediate;
		int next;

		for (int i = 0; i < array.length; i++) {

			// check for correct size
			if (array[i].length != vector.length)
				throw new RuntimeException(
						"incompatable array sizes for vetor multipliction.");

			// reset next and intermediate
			next = 0;
			intermediate = 0;

			// do the math
			for (int j = 0; j < vector.length; j++) {
				intermediate = array[i][j] * vector[j];
				next += intermediate;
			}
			newArray[i] = next;

		}
		return newArray;

	}

	/**
	 * This method takes an array of integers and returns a string
	 * representation of the array
	 * 
	 * @param array
	 *            an array of integers
	 * @return a string representation of a array of integers
	 */

	public static String toString(int[] array) {

		String arrayString = "{";

		// add each element plus ", " to String, excluding the last element
		for (int i = 0; i < array.length - 1; i++)
			arrayString += array[i] + ", ";

		// get the last element of the array (if it exists), don't add ", "
		if (array.length > 0)
			arrayString += array[array.length - 1];

		arrayString += "}";

		return arrayString;

	}

}
