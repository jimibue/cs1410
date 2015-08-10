package assign5;

import java.util.Arrays;

/**
 * This class contains ten static methods that perform a variety of operations
 * on arrays
 * 
 * @author James Yeates
 * 
 */

public class ArrayLibrary {

	public static void main(String[] args) {

		int[] integers = { 2, -9, 87, 6, 0, 12, -3 };
		int[] integersBackup = { 2, -9, 87, 6, 0, 12, -3 };
		int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 };
		double[] numbers = { 32.5, 9.88, -7.0, 104.85, 47.91, -2.23 };
		double[] largeNumbers = { 5000.8, 4233.0, 3010.2, 9099.9, 1022.8 };
		int[] duplicates = { 4, 2, 3, 5, 4, 4, 3, 2, 9, 87, 3, 4, 5, 2, 30 };
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] vector = { 1, 2, 3 };
		int[] empty = {};
		int[] oneElement = { 1 };
		double[] oneElementD = { 1.0 };
		int[] mode1 = { 1, 1, 1, 2, 2, 3, 3 };
		int[] mode2 = { -3, 1, 1, 1, 2, 2, -3, -3, -3, -3 };

		// //////testing///////////

		// testing sum
		if (sum(integers) != 95)
			System.out.println("Failed 1a");

		if (sum(empty) != 0)
			System.out.println("Failed 1b");

		if (sum(oneElement) != 1)
			System.out.println("Failed 1ba");

		if (!Arrays.equals(integers, integersBackup))
			System.out.println("Failed 1c");

		// testing toString
		int[] testarr1 = { 1, 2, 334534345, 234, -234, 0 };

		if (!toString(integers).equals("{2, -9, 87, 6, 0, 12, -3}"))
			System.out.println("Failed 2a");

		if (!toString(empty).equals("{}"))
			System.out.println("Failed 2b");

		if (!toString(testarr1).equals("{1, 2, 334534345, 234, -234, 0}"))
			System.out.println("Failed 2c");

		if (!Arrays.equals(integers, integersBackup))
			System.out.println("Failed 2d");

		// testing decrement

		decrement(integers);
		if (!toString(integers).equals("{1, -10, 86, 5, -1, 11, -4}"))
			System.out.println("Failed 3a");

		decrement(empty);
		if (!toString(empty).equals("{}"))
			System.out.println("Failed 3b");

		decrement(oneElement);
		if (!toString(oneElement).equals("{0}"))
			System.out.println("Failed 3ba");

		if (Arrays.equals(integers, integersBackup))
			System.out.println("Failed 3c");

		// testing contains

		if (contains(primes, 13, 4) != true)
			System.out.println("Failed 4a");

		if (contains(primes, 13, 8) != false)
			System.out.println("Failed 4b");

		if (contains(primes, 2, 0) != true)
			System.out.println("Failed 4c");

		if (contains(primes, 2, 1) != false)
			System.out.println("Failed 4d");

		if (contains(primes, 47, primes.length - 1) != true)
			System.out.println("Failed 4e");

		if (contains(empty, 13, 0) != false)
			System.out.println("Failed 4f");

		// testing reverse
		int[] testArr2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] testArr3 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

		reverse(primes, 4, 13);
		if (!toString(primes).equals(
				"{2, 3, 5, 7, 43, 41, 37, 31, 29, 23, 19, 17, 13, 11, 47}"))
			System.out.println("Failed at 5aa");

		reverse(empty, 0, 0);

		reverse(testArr2, 0, 9);
		if (!toString(testArr2).equals("{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}"))
			System.out.println("Failed 5a");

		reverse(testArr2, 0, 9);
		if (!toString(testArr2).equals("{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}"))
			System.out.println("Failed 5b");

		reverse(testArr3, 0, 8);
		if (!toString(testArr3).equals("{8, 7, 6, 5, 4, 3, 2, 1, 0}"))
			System.out.println("Failed 5c");

		reverse(testArr3, 0, 0);
		if (!toString(testArr3).equals("{8, 7, 6, 5, 4, 3, 2, 1, 0}"))
			System.out.println("Failed 5d");

		reverse(testArr2, 4, 5);
		if (!toString(testArr2).equals("{0, 1, 2, 3, 5, 4, 6, 7, 8, 9}"))
			System.out.println("Falied 5e");

		// testing average
		double[] avgTest = { 1.0, -1.0, 2.0, -2.0, 0.0 };
		double[] avgTest1 = { -1.0, -2.0, -3.0, -4.0 };

		if (average(numbers) != 30.985)
			System.out.println("Failed  6a");

		if (average(avgTest) != 0.0)
			System.out.println("Failed 6b");

		if (average(avgTest1) != -2.5)
			System.out.println("Failed 6c");

		if (average(oneElementD) != 1.0)
			System.out.println("Failed at 6d");

		// testing median
		if (median(largeNumbers) != 4233.0)
			System.out.println("Failed 7a");

		if (median(numbers) != 21.19)
			System.out.println("Failed 7b");

		if (median(avgTest1) != -2.5)
			System.out.println("Failed 7c ");

		// testing mode

		if (mode(duplicates) != 4)
			System.out.println("Failed 8a");

		if (mode(mode1) != 1)
			System.out.println("Failed 8b");

		if (mode(mode2) != -3)
			System.out.println("Failed 8c");

		if (mode(vector) != 3 && mode(vector) != 2 && mode(vector) != 1)
			System.out.println("Failed 8d " + mode(vector));

		// testing rowCopy

		if (!toString(rowCopy(matrix, 1)).equals("{4, 5, 6}"))
			System.out.println("Failed 9a");

		if (!toString(rowCopy(matrix, 0)).equals("{1, 2, 3}"))
			System.out.println("Failed 9b");

		if (!toString(rowCopy(matrix, 2)).equals("{7, 8, 9}"))
			System.out.println("Failed 9c");

		// testing linearize

		if (!toString(linearize(matrix)).equals("{1, 2, 3, 4, 5, 6, 7, 8, 9}"))
			System.out.println("Failed 10a");

		System.out.println("Testing Done");

	}

	/**
	 * This method returns the sum of an array of integers
	 * 
	 * @param array
	 *            an array of integers
	 * @return the sum of the array
	 */

	public static int sum(int[] array) {

		int sum = 0;

		// add all the integers in the array
		for (int i = 0; i < array.length; i++)
			sum += array[i];

		return sum;
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

	/**
	 * This method takes an array of integers and decrements each element in the
	 * array by 1
	 * 
	 * @param array
	 *            an array of integers
	 */

	public static void decrement(int[] array) {

		for (int i = 0; i < array.length; i++)
			array[i] = array[i] - 1;

	}

	/**
	 * This method searches an array of integers for a certain value and start
	 * at a certain index
	 * 
	 * @param array
	 *            an array of integers
	 * @param item
	 *            the integer that is being searched for
	 * @param index
	 *            the starting index to be searched
	 * @return a boolean expression whether or not item was in the array
	 */

	public static boolean contains(int[] array, int item, int index) {

		// start search at 'index value' check the rest of the array
		for (int i = index; i < array.length; i++) {
			if (array[i] == item)
				return true;
		}

		return false;

	}

	/**
	 * This method reverses the order of an array from indexes i to j inclusive
	 * 
	 * @param array
	 *            an array of integers
	 * @param i
	 *            starting location to reverse array
	 * @param j
	 *            end location to reverse array
	 */

	public static void reverse(int[] array, int i, int j) {

		int loopControl = (j - i + 1) / 2;// Determines how many times to swap
											// values
		int counter = 0;// used to increment and decrement array indexes
		int temp;

		while (loopControl != 0) {

			// swap
			temp = array[i + counter];
			array[i + counter] = array[j - counter];
			array[j - counter] = temp;

			counter++;
			loopControl--;
		}

	}

	/**
	 * This method determines the average value of an array of doubles
	 * 
	 * @param array
	 *            an array of doubles
	 * @return the average value of the array
	 */

	public static double average(double[] array) {

		double sum = 0.0;

		for (int i = 0; i < array.length; i++)
			sum += array[i];

		return sum / array.length;
	}

	/**
	 * This method returns the median from an array of doubles, if the array is
	 * of even size it returns the average of the two middle values
	 * 
	 * @param array
	 *            an array of doubles
	 * @return the median (middle
	 */

	public static double median(double[] array) {

		double[] tempArr = array;

		// sort the Temporary Array
		Arrays.sort(tempArr);

		// check if array is even
		if (array.length % 2 != 0)
			return tempArr[array.length / 2];
		else
			// return the average of the two middle values.
			return (tempArr[array.length / 2] + tempArr[array.length / 2 - 1]) / 2;

	}

	public static int mode(int[] array) {

		int highestCount = 0;// keep track of most common integer
		int index = 0;// keep track of index
		int best = array[0];// assume the first element is the mode

		// This 'while' loop goes through every item of the array.
		// The 'for' loop then checks how many times that element is in the
		// array.
		// This is highly inefficient.
		while (index < array.length) {
			int counter = 0;

			for (int i = 0; i < array.length; i++) {
				if (array[index] == array[i])
					counter++;
			}
			if (counter >= highestCount) {
				best = array[index];
				highestCount = counter;
			}

			index++;

		}
		return best;
	}

	/**
	 * This method returns a copy of a specified row from two dimensional array
	 * 
	 * @param array
	 *            a two dimensional array containing integers
	 * @param index
	 *            integer specifying the row to be copied
	 * @return a one dimensional array from the specified row
	 */

	public static int[] rowCopy(int[][] array, int index) {

		// create an array the length of the column of the row
		int[] copy = new int[array[index].length];

		// fill in the values
		for (int i = 0; i < array[index].length; i++)
			copy[i] = array[index][i];

		return copy;
	}

	/**
	 * This method take a two dimensional array and converts it to a one
	 * dimensional array
	 * 
	 * @param array
	 *            a two dimensional array containing integers
	 * @return a one dimensional array containing integers
	 */

	public static int[] linearize(int[][] array) {

		// used to keep track of position in the new array
		int index = 0;

		// create a array with size of array row length * array column length
		int[] newArray = new int[array.length * array[0].length];

		// assign values from array to newArray
		for (int i = 0; i < array.length; i++) {
			for (int k = 0; k < array[i].length; k++) {
				newArray[index] = array[i][k];
				index++;
			}
		}

		return newArray;

	}

}
