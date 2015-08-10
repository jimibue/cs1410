package assign4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author James Yeates
 *
 */

public class TestAnalysis{
	

	public static void main(String[] args) {
		
		// gets a file selected by user and create a scanner object using the file.
		Scanner fileScanner = getFileScanner();
		
		// get word from the user
		String word = getWord();
		
	
		
		// Do the rest of the work
		searchFile(fileScanner, word);

	}// END OF MAIN METHOD

	/**
	 * This method finds the average length of words in a file, the amount of times
	 * 'word' appears in the file, the word that comes before and after 'word' in lexicographical
	 *  order and the amount of times the first character of 'word' appears in the text.  This method does
	 *  this in one pass of the scanner object and returns the results to a JOptionPane panel.
	 * 
	 * @param fileScanner scanner object to be scanned
	 * @param word string used to perform required tasks
	 *  
	 */
	public static void searchFile(Scanner fileScanner, String word) {
		
	
		//Variables //
		
		int totalWords = 0; //keep track of total words in file
		int countWord = 0;  //keep track of 'word'
		int totalChars = 0; // keep track of total characters
		double averageLength = 0.0; //keep track of average length
		String wordBefore = word;	//keep track word before, assume it is 'word' at first
		String wordAfter = word;	//keep track word after, assume it is 'word' at first
		char firstCharacter = word.charAt(0);  //get the first character of 'word
		int firstLetterCount = 0;	//keep track of first character of 'word count
		boolean wordBeforeFound = false; //flag to see if word before 'word' has been found
		boolean wordAfterFound = false; //flag to see if word after 'word' has been found
		
	
		//this loop Scans all tokens of the file once and does all the parts of this assignment.
		while (fileScanner.hasNext()) {

			// get total words in the file
			totalWords++;

			// get the next token in the file and convert to a lower case String
			String next = fileScanner.next().toLowerCase();

			// check to see how many times 'word' appears
			if (next.equals(word)) {
				countWord++;
			}

			// keep track of total amount of characters in file
			totalChars += next.length();
			
			//checks to see if there is a word that occurs before 'word'.
			if (!wordBeforeFound) {
				if (next.compareTo(word) < 0) {
					wordBefore = next;
					wordBeforeFound = true;

				}
			}
			// If a word before has been found this will execute
			// Checks to see if the next word comes after 'wordBefore' and
			// before 'word'.
			else {
				if ((next.compareTo(word) < 0)
						&& (next.compareTo(wordBefore) > 0)
						&& !next.equalsIgnoreCase(word)) {
					wordBefore = next;

				}
			}

			// check to see if there is a word that comes after 'word'
			if (!wordAfterFound) {
				if (next.compareTo(word) > 0) {
					wordAfter = next;
					wordAfterFound = true;

				}
			}
			// If a word after has been found this will execute
			// Checks to see if the next word comes before 'wordAfter' and after
			// 'word'.
			else {
				if ((next.compareTo(word) > 0)
						&& (next.compareTo(wordAfter) < 0)
						&& !next.equalsIgnoreCase(word)) {
					wordAfter = next;

				}
			}
			//Extra part!!
			// determines how many time the first character of 'word' is in the file.
			// Iterates through each character in text and checks for equality
			for (int i = 0; i < next.length(); i++) {
				if (next.charAt(i) == firstCharacter) {
					firstLetterCount++;
				}
			}

		}
		averageLength = totalChars / (double) totalWords;

		// Show results using a JOptionPane panel
		JOptionPane.showMessageDialog(null, "'"+word+"'" + " was found in the file " + countWord
				+ " times.\n" + "The average length of the words in the file is "
				+ averageLength + ".\n" + "The word before " + "'"+ word+"'" + " in the file is '"
				+ wordBefore + "'.\n" + "The word after " + "'"+word+"'" + " in the file is '"
				+ wordAfter + "'.\n" + "The  first letter of '" +word+ "' is " + "'"+ word.charAt(0)+"'"
				+ " and was found " + firstLetterCount + " times in the File.");

	}

	/**
	 * This method gets a a string entered by the user, If an invalid entry is
	 * selected the program will be exited
	 * 
	 * @return the string entered by the user
	 */

	public static String getWord() {

		JOptionPane pane = new JOptionPane();

		// check to see if user entered a a word, if not exit program.
		try {
			String word = pane.showInputDialog(null, "enter a word");

			word = word.toLowerCase();

			return word;
		} catch (NullPointerException e) {
			System.exit(0);
		}
		// if user didn't enter a valid entry Program will exit, this won't be
		// returned.
		return null;

	}

	/**
	 * This Method opens a JFileChooser and creates a scanner object from the file
	 * selected by the user.  This method will simply close if user
	 * does not choose a file or if a file not found exception occurs
	 * 
	 * @return a scanner object containing a file
	 */

	public static Scanner getFileScanner() {

		// Open a new window for user to choose a file
		JFileChooser fileChooser = new JFileChooser();

		int returnValue = fileChooser.showOpenDialog(null);

		// check to see if user selected a file, and if it was a valid file. If
		// not program closes
		if (returnValue == fileChooser.APPROVE_OPTION) {

			File file = fileChooser.getSelectedFile();

			// create the scanner object, exit if file not found 
			try {
				Scanner s = new Scanner(file);
				return s;
			} catch (FileNotFoundException e) {

				System.exit(0);
			}

		} 
		//exit if user did not select a file
		else {
			System.exit(0);
		}
		//execution won't get here, but is needed to prevent a compiler error
		return null;

	}
}//end
