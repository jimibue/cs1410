package assign3;

import java.util.Scanner;

public class LoopPatterns2 {
	
	public static void main(String[] args) {
		
		//////////////// sum TESTING///////////
	
		
		if (sum(new Scanner("1.0 2.0 3.0"))!= 6.0){
			System.out.println("TEST FAILED: sum(new Scanner(\"1.0 2.0 3.0\"))");
		}
		if (sum(new Scanner(""))!= 0.0){
			System.out.println("TEST FAILED: sum(new Scanner(\"\"))");
		}
		if (sum(new Scanner("-1.0 -2.0 -3.0"))!= -6.0){
			System.out.println("TEST FAILED: sum(new Scanner(\"-1.0 -2.0 -3.0\"))");
		}
		if (sum(new Scanner("-1.0 -2.0-3.0"))!= -1.0){
			System.out.println("TEST FAILED: sum(new Scanner(\"-1.0 -2.0-3.0\"))");
		}	
		
		
		///////////// countWord testing///////////////////////
		
		
		if (  (countWord(new Scanner("apple bee cat bee cat dog"), "cat")) != 2){
			System.out.println("Testing Failed: countWord(new Scanner(\"apple bee cat bee cat dog\"), \"cat\"))");
		}
		if( (countWord(new Scanner(""), "cat")) != 0){
			System.out.println("Testing Failed at (countWord(new Scanner(\"\"), \"cat\")) != 0)");
		}
		if( countWord(new Scanner("John john JHON JOHN"),"John") != 3){
			System.out.println("Testing Failed at:  countWord(new Scanner(\"John john JHON JOHN\"),\"John\")");
		}
		if(countWord(new Scanner("apple bee cat bee cat dog"), "cot") != 0)
			System.out.println("countWord(new Scanner(\"apple bee cat bee cat dog\"), \"cot\") != 0)");
		
		
		////////// average Testing/////////
		
		
		if(average(new Scanner("32 9 -7 104 47 -2"))!= 30.5){
			System.out.println("Testing Failed at: average(new Scanner(\"32 9 -7 104 47 -2\"))");
		}
		if(average(new Scanner("32"))!= 32){
			System.out.println("Testing Failed at: average(new Scanner(\"32\"))");
		}
		if(average(new Scanner("-32 0 -21 4"))!= -12.25){
			System.out.println("Testing Failed at: average(new Scanner(\"32\"))");
		}
		
						//////// moreWordsOfOddLength testing /////////
		
		if(moreWordsOfOddLength(new Scanner("I love Java")) != false){
			System.out.println("Testing Failed at: moreWordsOfOddLength(new Scanner(\"I love Java\")");
		}
		if(moreWordsOfOddLength(new Scanner("")) != false){
			System.out.println("Testing Failed at: moreWordsOfOddLength(new Scanner(\"\")");
		}
		if(moreWordsOfOddLength(new Scanner("this that his hat")) != false){
			System.out.println("Testing Failed at: moreWordsOfOddLength(new Scanner(\"this that his hat\")");
		}
		if(moreWordsOfOddLength(new Scanner("t at her here hairy")) != true){
			System.out.println("Testing Failed at: moreWordsOfOddLength(new Scanner(\"t at her here hairy\")");
		}
		
							///// secondLetters Testing ///////
		
		if(secondLetters(new Scanner("Let me Google that for you")).equals("eeohoo") != true){
			System.out.println("Testing Failed At: secondLetters(new Scanner(\"Let me Google that for you\")) " );
		}
		if(secondLetters(new Scanner("")).equals("") != true){
			System.out.println("Testing Failed At: secondLetters(new Scanner(\"\")) " );
		}if (secondLetters(new Scanner("L a d sD jo s InESasda ae a s!asd !!")).equals("Done!!") != true){
			System.out.println("Testing Failed At: secondLetters(new Scanner(\"L a d sD jo s InESasda ae a s!asd !!\"))");
		}
		
		
		/////// countDivBy5 testing
		
		
		if(countDivBy5(new Scanner("2 -30 9 55 -10 46")) != 3){
			System.out.println("Testing Failed At: countDivBy5(new Scanner(\"2 -30 9 55 -10 46\"))");
		}
		if(countDivBy5(new Scanner("")) != 0){
			System.out.println("Testing Failed At: countDivBy5(new Scanner(\"\"))");
		}
		if(countDivBy5(new Scanner("234 234 543 2343445323 445")) != 0){
			System.out.println("Testing Failed At: countDivBy5(new Scanner(\"234 234 543 2343445323 445\"))");
		}
		if(countDivBy5(new Scanner("5 10 15 100 40000 45")) != 6){
			System.out.println("Testing Failed At: countDivBy5(new Scanner(\"5 10 15 100 40000 45\"))");
		}
		
		/////lastWord Testing/////////
		
		if( lastWord(new Scanner("one two three four")).equals("two") != true ){
			System.out.println("Failed At: lastWord(new Scanner(\"one two three four\")).equals(\"two\") != true )");
		}
		if( lastWord(new Scanner("one")).equals("one") != true ){
			System.out.println("Failed At: lastWord(new Scanner(\"one\")).equals(\"one\") != true )");
		}
		if( lastWord(new Scanner("zebra goat apple")).equals("zebra") != true ){
			System.out.println("Failed At: lastWord(new Scanner(\"zebra goat apple\")).equals(\"zebra\") != true )");
		}
		if( lastWord(new Scanner("abe ace")).equals("ace") != true ){
			System.out.println("Failed At: lastWord(new Scanner(\"abe ace\")).equals(\"ace\") != true )");
		}
		if( lastWord(new Scanner("abe abea")).equals("abea") != true ){
			System.out.println("Failed At: lastWord(new Scanner(\"abe abea\")).equals(\"abea\") != true )");
		}
		if( lastWord(new Scanner("zebra goat apple zzebra")).equals("zzebra") != true ){
			System.out.println("Failed At: lastWord(new Scanner(\"zebra goat apple\")).equals(\"zebra\") != true )");
		
		}
		
		
		
		//////////////// shortestWord Testing///////////////////
		
		if( shortestWord(new Scanner("zero one two three four")).equals("one") != true){
			System.out.println("Failed At: shortestWord(new Scanner(\"zero one two three four\")).equals(\"one\") != true ");
		}
		if( shortestWord(new Scanner("a zero one two three four")).equals("a") != true){
			System.out.println("Failed At: shortestWord(new Scanner(\"a zero one two three four\")).equals(\"a\") != true ");
		}
		if( shortestWord(new Scanner(" zero one two three four at")).equals("at") != true){
			System.out.println("Failed At: shortestWord(new Scanner(\" zero one two three four at\")).equals(\"at\") != true ");
		}
		if( shortestWord(new Scanner("zero")).equals("zero") != true){
			System.out.println("Failed At: shortestWord(new Scanner(\"zero\")).equals(\"zero\") != true ");
		}
		
		
		/////// countInRange Testing  ////////////////////////
		
		
		
		
		if( (countInRange(new Scanner("1.8 -2.0 9.25 3.0 5.0"), -2, 5)) != 2 ){
			System.out.println("Testing Failed At: countInRange(new Scanner(\"1.8 -2.0 9.25 3.0 5.0\"), -2, 5)) != 2");
		}
		if( (countInRange(new Scanner("1.8 -2.0 9.25 3.0 5.0"), 5, -2)) != 2 ){
			System.out.println("Testing Failed At: countInRange(new Scanner(\"1.8 -2.0 9.25 3.0 5.0\"), 5, -2)) != 2");
		}
		if( (countInRange(new Scanner(""), -2, 5)) != 0 ){
			System.out.println("Testing Failed At: countInRange(new Scanner(\"\"), -2, 5)) != 0");
		}
		if( (countInRange(new Scanner("-11 1 12"), -10, 1)) != 0 ){
			System.out.println("Testing Failed At: countInRange(new Scanner(\"-11 1 12\"), -2, 5)) != 0");
		}
		
		
		////////// sumOfLogs Testing///////////////
		
		
		System.out.println("Testing sumOfLogs(new Scanner(\"4.3 6.5 8.7\") should equl approx 5.4937: "+
					sumOfLogs(new Scanner("4.3 6.5 8.7")));
		if(Math.round(sumOfLogs(new Scanner("2.728 2.728 2.728"))) != 3){
			System.out.println("Testing Failed At: Math.round(sumOfLogs(new Scanner(\"2.728 2.728 2.728\"))) != 3");
		}
		
		
		
	
		
		
		
		
		
		System.out.println("Testing Done");
		
		
		
		
		
		
		
	}//End of Main
	
	//////////////// 1 SUM METHOD//////////////////////
	
	/**
	 * This subroutine uses a Scanner to add up all of the doubles from the scanner object 
	 * 
	 * @param s a scanner object containing  doubles
	 * @return the sum of the string of double
	 */

	public static double sum (Scanner s){
		
		double sum = 0;
		
		while(s.hasNextDouble()){

			sum = sum + s.nextDouble();
		}
		return sum;
	}
	
	////////////////COUNTWORD METHOD//////////////////////

	/**
	 * This subroutine searches a String of words for a particular word
	 * and returns how many times it was found.  This subroutine is not case sensitive.
	 * 
	 * @param stringOfWords a scanner object containing a string of words
	 * @param word the word to be searched for
	 * @return the amount of times word was found
	 */
	
    
	
	public static int countWord(Scanner stringOfWords, String word){
		
		int count = 0;
		
		while(stringOfWords.hasNext()){
			
			if(stringOfWords.next().equalsIgnoreCase(word)){
				count++;
			}
		}
		return count;
	}
	
	////////////////AVERAGE METHOD//////////////////////
	
	/**
	 * This subroutine takes a string of integers and returns the average
	 * 
	 * @param stringOfIntegers a scanner object containing a string of integers
	 * @return the average value
	 */
	
	public static double average(Scanner stringOfIntegers){
		
		int count = 0;
		double sum = 0.0;
		
		while(stringOfIntegers.hasNextInt()){
			
			sum += stringOfIntegers.nextInt();
			count++;
		} 
		
		return sum/count;

	}
	
	////////////////MOREWORDSofODDLENGTH  METHOD//////////////////////
	
	/**
	 * this subroutine takes a string of words and determines if there are more odd length words than even
	 * 
	 * @param stringOfWords a scanner object containing a string of words
	 * @return true if more odd words in string, false otherwise
	 */
	
	public static boolean moreWordsOfOddLength(Scanner stringOfWords){
		
		int oddWordCount = 0;
		int evenWordCount = 0;
		
		while(stringOfWords.hasNext()){
			
			String tempString = stringOfWords.next();
			
			if(tempString.length() % 2 == 0){
				evenWordCount++;
			}
			else{
				oddWordCount++;
			}
		}
		
		if(evenWordCount >= oddWordCount){
			return false;
		}
		else{
			return true;
		}
		
	}
    
	////////////////SECONDLETTERS  METHOD//////////////////////
	
	/**
	 * This subroutine takes a string of words and returns a string built from the second letter of each word in
	 * the string of words
	 * 
	 * @param stringOfWords a scanner object containing a string of words
	 * @return  a string built from the second letter of each word in
	 * the string of words
	 */
	
	public static String secondLetters( Scanner stringOfWords){
		
		String tempString; 
		String finalString = "";
		
		while(stringOfWords.hasNext()){
			
			tempString = stringOfWords.next();
			
			if(tempString.length() >= 2 ){
				finalString += tempString.charAt(1);
			}
		}
		
		return finalString;
	
	}
	
	////////////////COUNTDIVby5 METHOD//////////////////////
	
	/**
	 * This subroutine determines the amount of numbers divisible by 5 in a string of integers
	 * 
	 * @param stringOfIntegers a scanner object containing a string of integers
	 * @return number of integers divisible by 5
	 */
	
	public static int countDivBy5(Scanner stringOfIntegers){
		
		int count = 0;
		
		while(stringOfIntegers.hasNextInt()){
			
			if(stringOfIntegers.nextInt() %5 == 0){
				count ++;
			}
		}
		return count;
	}
	
	////////////////LASTWORD METHOD//////////////////////
	
	/**
	 *  This subroutine returns the last word from a list of words based on lexicographical order
	 * 
	 * @param stringOfWords a scanner object containing a string of words
	 * @return last word from stringOfWords based on lexicographical order
	 */
	
	public static String lastWord(Scanner stringOfWords){
		
		String lastString = stringOfWords.next();
		
		while(stringOfWords.hasNext()){
			
			String temp = stringOfWords.next();
			
		
			
			if(temp.compareToIgnoreCase(lastString) >= 1){
				lastString = temp;
			}
			
		}
		
		return lastString;
	}
	
	////////////////SHORTESTWORD METHOD//////////////////////
	
	/** 
	 * This subroutine takes a string of words and return the shortest word, if two
	 * or more words of the same length are in the list the first found is returned
	 * 
	 * @param stringOfWords a scanner object containing a string of words
	 * @return the shortest word in the list
	 */
	
	public static String shortestWord(Scanner stringOfWords){
		
		String shortest = stringOfWords.next();
		
		while(stringOfWords.hasNext()){
			
			String temp = stringOfWords.next();
			
			if ( temp.length()< shortest.length()){
				shortest = temp;
			}
			
		}
		
		return shortest;
	}
	
      ////////////////COUNTinRANGE METHOD//////////////////////
	
	/**
	 * This subroutines determines the number of values in between two numbers(exclusive).
	 * 
	 * @param stringOfDoubles a scanner object containing a string of doubles
	 * @param start the staring point of the range of numbers(exclusive)
	 * @param end the ending point of the range of number (exclusive)
	 * @return the total amount of double in between start and end (exclusive)
	 */
	
	public static int countInRange(Scanner stringOfDoubles, int start, int end ){
		
		//make sure 'start' and 'end' values are in the right order, switch if not
		if (start > end){
			int temp = start;
			start = end;
			end = temp;
		}
		
		int count = 0;
		
		while(stringOfDoubles.hasNextDouble()){
			
			double nextDouble = stringOfDoubles.nextDouble();
			
			if( nextDouble > start && nextDouble < end){
				count++;
			}
		}
		
		return count;
	}
	
	///////////// SUMofLOGS METHOD//////////////////

	
	public static double sumOfLogs(Scanner stringOfDoubles){
		
		double sum = 0.0;
		
		while(stringOfDoubles.hasNextDouble()){
			sum += Math.log(stringOfDoubles.nextDouble());
		}
		return sum;
	}
	
	

}//end LoopPatterns Class




/*
 * 
LoopPatterns static methods

Method name: sum
Parameter: a Scanner object containing double values
Return value: the sum of all values
Example: sum(new Scanner("1.5 2.5 3.5 4.5 5.5")) should return 17.5
Note: Your method should work even if the Scanner object contains no values.

Method name: countWord
Parameters (in order): a Scanner object containing words, a word
Return value: the number of times that the word occurs
Example: countWord(new Scanner("apple bee cat bee cat dog"), "cat") should return 2
Notes: Your method should work even if the Scanner object contains no words. Recall that because String is a special data type, we should not compare for equality using ==.

Method name: average
Parameter: a Scanner object containing integers
Return value: the average value
Example: average(new Scanner("32 9 -7 104 47 -2")) should return 30.5
Note: You may assume that the Scanner object contains at least one integer.

Method name: moreWordsOfOddLength
Parameter: a Scanner object containing words
Return value: true if there are more words of odd length than words of even length, false otherwise
Example: moreWordsOfOddLength(new Scanner("I love Java")) should return false
Note: Your method should work even if the Scanner object contains no words.

Method name: secondLetters
Parameter: a Scanner object containing words
Return value: a String made from the second letter of every word (in order)
Example: secondLetters(new Scanner("Let me Google that for you")) should return "eeohoo"
Notes: Your method should work even if the Scanner object contains no words. If a word contains less than two letters, it should not contribute anything to the return value.

Method name: countDivBy5
Parameter: a Scanner object containing integers
Return value: the number of integers that are evenly divisible by 5
Example: countDivBy5(new Scanner("2 -30 9 55 -10 46")) should return 3
Note: Your method should work even if the Scanner object contains no integers.

Method name: lastWord
Parameter: a Scanner object containing words
Return value: the word that comes last in lexicographical order
Example: lastWord(new Scanner("one two three four")) should return "two"
Notes: You may assume that the Scanner object contains at least one word. Use the compareTo method of String for comparing two words. Read the API as needed to learn about its parameters and return value.

Method name: shortestWord
Parameter: a Scanner object containing words
Return value: the word that has the fewest characters (the first such word, in the case of a tie)
Example: shortestWord(new Scanner("zero one two three four")) should return "one"
Note: You may assume that the Scanner object contains at least one word.

Method name: countInRange
Parameters (in order): a Scanner object containing double values, an integer A, an integer B
Return value: the number of values that are between A and B (exclusive)
Example: countInRange(new Scanner("1.8 -2.0 9.25 3.0 5.0"), -2, 5) should return 2
Note: Your method should work even if the Scanner object contains no values.

Method name: sumOfLogs
Parameter: a Scanner object containing double values
Return value: the sum of the natural logarithms of the values
Example: sumOfLogs(new Scanner("4.3 6.5 8.7")) should return about 5.493740
Note: You may assume that the Scanner object contains at least one value.
NOTE: The base assignment does not get input from or give output to the user. The course staff will grade the programs of all CS 1410 students with the same set of calls to each of the ten methods. Therefore, it is critical that your program contains all method names, return types, and parameter lists exactly as instructed. Otherwise, some or all of the method calls written by the course staff will fail for your program, even if the code contained in the bodies of your methods is correct.

EXTRA CHALLENGE: A correct and complete program that meets the specifications above and has good programming style will receive 95% of the credit for this programming assignment. The last 5% of credit depends on completion of an extra challenge, which gives interested and motivated students the opportunity to go above and beyond the basic requirements. Note that the amount of work / time / intellect required to complete the extra challenge is more than for the base assignment, yet is worth much less credit.

Create a new class called LoopPatternsExtra in package assign3.
Add one static method to LoopPatternsExtra, as specified below. Of course, you should use the main method for testing. Do not add any other methods to this class.

Method name: removeLetters
Parameters (in order): a String S1, a String S2
Return value: a String the same as S1 but with all of the letters in S2 removed
Example: removeLetters("Mississippi River", "is") should return "Mpp Rver"
Notes: Your method should work even if S1, S2, or both are empty. You are to remove each of the letters contained in S2 from S1, not just the entire substring S2. (E.g., the letter i and the letter s are removed in the example, even if "is" does not appear together).

As always, make certain that your program has good style, and test it thoroughly.
Export your LoopPatternsExtra.java file and submit it using the button below.

*/


