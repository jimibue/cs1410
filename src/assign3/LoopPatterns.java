package assign3;

import java.util.Scanner;

/** 
 * @author James Yeates
 */

public class LoopPatterns {
	
	public static void main(String[] args) {
		
		Integer x= 67687;
		String s;
		
		
		//TESTING......................
		
		
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
		
		
		////////// secondLetters Testing ///////
		
		
		if(secondLetters(new Scanner("Let me Google that for you")).equals("eeohoo") != true){
			System.out.println("Testing Failed At: secondLetters(new Scanner(\"Let me Google that for you\")) " );
		}
		if(secondLetters(new Scanner("")).equals("") != true){
			System.out.println("Testing Failed At: secondLetters(new Scanner(\"\")) " );
		}if (secondLetters(new Scanner("L a d sD jo s InESasda ae a s!asd !!")).equals("Done!!") != true){
			System.out.println("Testing Failed At: secondLetters(new Scanner(\"L a d sD jo s InESasda ae a s!asd !!\"))");
		}
		
		
		/////// countDivBy5 testing ////////
		
		
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
		
		
		if(Math.round(sumOfLogs(new Scanner("2.728 2.728 2.728"))) != 3){
			System.out.println("Testing Failed At: Math.round(sumOfLogs(new Scanner(\"2.728 2.728 2.728\"))) != 3");
		}
		if(sumOfLogs(new Scanner("4.3 6.5 8.7"))!= 5.493740225261646){
			System.out.println("Testing Failed At: sumOfLogs(new Scanner(\"4.3 6.5 8.7\"))!= 5.493740225261646 ");
		}
		
		//If test were successful this is the only thing that should be displayed to the consul
		System.out.println("Testing Done");
		
	}//End of Main
	
	
	//METHODS...............................
	
	
	//////////////// 1 SUM METHOD//////////////////////
	
	/**
	 * This subroutine  adds up all of the doubles from the scanner object 
	 * 
	 * @param s a scanner object containing  doubles
	 * @return the sum 
	 */

	public static double sum (Scanner s){
		
		double sum = 0.0;
		
		while(s.hasNextDouble()){

			sum = sum + s.nextDouble();
		}
		return sum;
	}
	
	////////////////COUNTWORD METHOD//////////////////////

	/**
	 * This subroutine searches a scanner object containing words for a particular word
	 * and returns how many times it was found.  This subroutine is not case sensitive.
	 * 
	 * @param s a scanner object containing words
	 * @param word the word to be searched for
	 * @return the amount of times word was found
	 */
	
    
	
	public static int countWord(Scanner s, String word){
		
		int count = 0;
		
		while(s.hasNext()){
			
			//checks to see if next token equals word if so increment count
			if(s.next().equalsIgnoreCase(word)){
				count++;
			}
		}
		return count;
	}
	
	////////////////AVERAGE METHOD//////////////////////
	
	/**
	 * This subroutine takes a scanner object containing integers and returns the average
	 * 
	 * @param s a scanner object containing  integers
	 * @return the average value
	 */
	
	public static double average(Scanner s){
		
		int count = 0;
		int sum = 0;
		
		while(s.hasNextInt()){
			
			sum += s.nextInt();
			count++;
		} 
		
		return sum/(double)count; //type cast count to double to avoid integer division

	}
	
	////////////////MOREWORDSofODDLENGTH  METHOD//////////////////////
	
	/**
	 * this subroutine takes a scanner object containing words and determines if there are more odd length words than even
	 * 
	 * @param s a scanner object containing  words
	 * @return true if more odd words, false otherwise
	 */
	
	public static boolean moreWordsOfOddLength(Scanner s){
		
		int oddWordCount = 0;
		int evenWordCount = 0;
		
		while(s.hasNext()){
			
			String tempString = s.next();
			
			//check to see if tempString is even or odd and keep track of totals
			if(tempString.length() % 2 == 0){
				evenWordCount++;
			}
			else{
				oddWordCount++;
			}
		}
		
		//check to see the amount of even words is greater or equal to odd words
		if(evenWordCount >= oddWordCount){
			return false;
		}
		else{
			return true;
		}
		
	}
    
	////////////////SECONDLETTERS  METHOD//////////////////////
	
	/**
	 * This subroutine takes a scanner object containing words and returns a string built from the second letter of each word 
	 * 
	 * 
	 * @param s a scanner object containing words
	 * @return  a string built from the second letter of each word in
	 * the string of words
	 */
	
	public static String secondLetters( Scanner s){
		
		String tempString; 
		String finalString = "";
		
		while(s.hasNext()){
			
			tempString = s.next();
			
			//check to make sure that tempString is at least two letter before adding letter
			if(tempString.length() >= 2 ){
				finalString += tempString.charAt(1);
			}
		}
		
		return finalString;
	
	}
	
	////////////////COUNTDIVby5 METHOD//////////////////////
	
	/**
	 * This subroutine determines the amount of numbers divisible by 5 from a scanner object containing integers
	 * 
	 * @param s a scanner object containing integers
	 * @return number of integers divisible by 5
	 */
	
	public static int countDivBy5(Scanner s){
		
		int count = 0;
		
		while(s.hasNextInt()){
			
			//check to see if the next is divisible by 5 if so increment count
			if(s.nextInt() %5 == 0){
				count ++;
			}
		}
		return count;
	}
	
	////////////////LASTWORD METHOD//////////////////////
	
	/**
	 *  This subroutine returns the last word from a list of words based on lexicographical order
	 * 
	 * @param s a scanner object containing a words
	 * @return last word based on lexicographical order
	 */
	
	public static String lastWord(Scanner s){
		
		//assume the first string in list is the last word to be returned.
		String lastString = s.next();
		
		while(s.hasNext()){
			
			String temp = s.next();
			
			//Check to see if if this words come after the current last word if so store that string in lastString
			if(temp.compareToIgnoreCase(lastString) >= 1){
				lastString = temp;
			}
			
		}
		
		return lastString;
	}
	
	////////////////SHORTESTWORD METHOD//////////////////////
	
	/** 
	 * This subroutine takes a scanner object containing words and return the shortest word, if two
	 * or more words of the same length are in the list the first found is returned
	 * 
	 * @param s a scanner object containing words
	 * @return the shortest word in the list
	 */
	
	public static String shortestWord(Scanner s){
		
		//assume the first word is shortest
		String shortest = s.next();
		
		while(s.hasNext()){
			
			String temp = s.next();
			
			//check to see if 'temp' is shorter than the current shortest string
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
	 * @param s a scanner object containing doubles
	 * @param start the staring point of the range of numbers(exclusive)
	 * @param end the ending point of the range of number (exclusive)
	 * @return the total amount of double in between start and end (exclusive)
	 */
	
	public static int countInRange(Scanner s, int start, int end ){
		
		//make sure 'start' and 'end' values are in the right order, switch if not
		if (start > end){
			int temp = start;
			start = end;
			end = temp;
		}
		
		int count = 0;
		
		while(s.hasNextDouble()){
			
			double nextDouble = s.nextDouble();
			
			// count the number in between the two values (exclusive)
			if( nextDouble > start && nextDouble < end){
				count++;
			}
		}
		
		return count;
	}
	
	///////////// SUMofLOGS METHOD//////////////////

	/**
	 * This subroutine take a scanner object containing double and returns the sum of their natural logarithms
	 * 
	 * @param s a scanner object containing doubles
	 * @return the sum of the natural logarithms
	 */
	public static double sumOfLogs(Scanner s){
		
		double sum = 0.0;
		
		while(s.hasNextDouble()){
			
			sum += Math.log(s.nextDouble());
		}
		return sum;
	}
	
}//end LoopPatterns Class






