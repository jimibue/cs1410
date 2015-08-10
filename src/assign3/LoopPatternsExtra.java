package assign3;

/**
 * @author James Yeates
 */

public class LoopPatternsExtra {
	
	
	public static void main(String[] args) {
		
		//Testing removeLetters
		
		if(removeLetters("Mississippi River", "is").equals("Mpp Rver") != true){
			System.out.println("Failed at: removeLetters(\"Mississippi River\", \"is\").equals(\"Mpp Rver\") != true");
		}
		if(removeLetters("Mississippi River", "").equals("Mississippi River") != true){
			System.out.println("Failed at: removeLetters(\"Mississippi River\", \"\").equals(\"Mississippi River\") != true");
		}
		if(removeLetters("", "").equals("") != true){
			System.out.println("Failed at: removeLetters(\"\", \"\").equals(\"\") != true");
		}
		if(removeLetters("", "is").equals("") != true){
			System.out.println("Failed at: removeLetters(\"\", \"is\").equals(\"\") != true");
		}
		if(removeLetters("apple", "pie").equals("al") != true){
			System.out.println("Failed at: removeLetters(\"apple\", \"pie\").equals(\"al\") != true");
		}
		
		//If testing was successful this is all that should be displayed to the console.
		System.out.println("Testing done");
		
	}//End main
	

/**
 * This subroutine takes a string and removes the letters in it  that are in found in a second string
 * example: removeLetters("apple" "pie") returns "al".
 * 
 * @param s1 string to be manipulated 
 * @param s2 string that provides the letters to remove from s1
 * @return String s1 with all letters from s2 removed
 */

	public static String removeLetters (String s1, String s2){
		
		boolean flag;
		
		// String to be returned. Is initially empty and will add characters as needed.
		String finalString= "";
		
		// loop to iterate through the s1
		for(int i = 0; i< s1.length(); i++){
			
			flag = false;
			
			// inner loop to iterate through s2 and compare each char with charAt.s1[i]
			for(int j = 0; j< s2.length(); j++){
				
				if(s1.charAt(i) == s2.charAt(j)){
					flag = true;
					break;  
				}
			}
			
			// this executes if the current character in s1 is not found in s2, and will add that character to finalString
			if (!flag){
				finalString += s1.charAt(i);
			}
		}
		
		return finalString;
	}

}// end LoopPatternsExtra Class
