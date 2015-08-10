package assign4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import assign3.LoopPatterns;

public class TextAnalysisBackup {

	static String word1;

	public static void main(String[] args) {

		// get the file Path
		File file = getFilePath();

		// get the word
		String word = getWord();

		// determine how many times word was in the text file
		int wordCount = countWord(file, word);

		// determine the average length of the words in text file
		double avgLength = averageLength(file);

		// determine the word that comes before the word enter by the user in
		// lexicographical order
		String wordBefore = beforeWord(file, word);

		// determine the word that comes after the word enter by the user in
		// lexicographical order
		String wordAfter = WordAfter(file, word);

		int wordTotal = count(file);
		
		int charCount = findMostCommonLetter(file, word);
		
		//Show the final Results
		JOptionPane.showMessageDialog(null,
				word + " was found in " + file.getName() + " " + wordCount
						+ " times.\n" + " The average length of words was "
						+ avgLength + "\n" + "the word before " + word
						+ " is '" + wordBefore + "'.\n" + " the word after "
						+ word + " is '" + wordAfter + "'.\n" + "There are "
						+ wordTotal + " Words in this file\n" + "the letter " + word.charAt(0)+ " was found "+
						charCount+ " times");

	}//END OF MAIN METHOD

	/**
	 * This subroutine searches a scanner object containing words for a
	 * particular word and returns how many times it was found. This subroutine
	 * is not case sensitive.
	 * 
	 * @param s
	 *            a scanner object containing words
	 * @param word
	 *            the word to be searched for
	 * @return the amount of times word was found
	 * 
	 */

	public static int countWord(File file, String word) {

		Scanner s = createScanner(file);

		int count = 0;

		while (s.hasNext()) {

			String next = s.next().toLowerCase();
			//next.toLowerCase();

			// checks to see if next token equals word if so increment count
			if (next.equals(word)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * This method gets a a string entered by the user, If an invalid entry is
	 * selected the program will be exited
	 * 
	 * @return the string entered by the user
	 */

	public static String getWord() {

		JOptionPane pane = new JOptionPane();

		// check to see if user made a valid selection, if not exit program.
		try {
			String word = pane.showInputDialog("enter a word");

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
	 * This method gets the file path for a file which is used later in the program 
	 * for creating a scanner object that scan files. If an invalid entry is made program will close.
	 * 
	 * @return the canonical file?
	 */

	public static File getFilePath() {

		File file = new File("");

		//Open a new window for user to choose a file
		JFileChooser fileChooser = new JFileChooser();

		int returnValue = fileChooser.showOpenDialog(null);
		
		//check to see if user selected a file, and if it was a valid file.  If not program closes
		if (returnValue == fileChooser.APPROVE_OPTION) {
			try {
				file = fileChooser.getSelectedFile().getCanonicalFile();
			} catch (IOException e) {
				System.out.println("An IOException occurred");
				System.exit(0);
			}

		} else {
			System.exit(0);
		}
		return file;

	}
	/**
	 * This method determines the average length of words in a text file
	 * 
	 * @param file the file to be scanned
	 * @return average length of words in a text file
	 */

	public static double averageLength(File file) {

		Scanner s = createScanner(file);

		int count = 0;
		int sum = 0;

		while (s.hasNext()) {

			String next = s.next();
			next.toLowerCase();

			sum += next.length();
			count++;

		}
		return sum / (double) count;

	}
	/**
	 * This method determines the word that come before the string given in its parameter based 
	 * on lexicographical order
	 * 
	 * @param file the file to be searched
	 * @param word to be compared to see which comes before it
	 * @return the word that comes before 'word'
	 */

	public static String beforeWord(File file, String word) {

		Scanner s = createScanner(file);
		
		// Assume that there is no word before, 
		String wordBefore = word;
		boolean wordBeforeFound = false;

		while (s.hasNext()) {

			String next = s.next();
			next.toLowerCase();
			
			//check to see if there is a word that comes before 'word'
			if (!wordBeforeFound) {
				if (next.compareTo(word) < 0) {
					wordBefore = next;
					wordBeforeFound = true;
					System.out.println(wordBefore);
				}
			}
			// If a word before has been found this will execute
			// Checks to see if the next word comes after 'wordBefore' and before 'word'.
			else {
				if ((next.compareTo(word) < 0)
						&& (next.compareTo(wordBefore) > 0)
						&& !next.equalsIgnoreCase(word)) {
					wordBefore = next;
					System.out.println(wordBefore);
				}
			}

		}
		s.close();
		return wordBefore;
	}
	/**
	 * This method determines the word that come after the string given in its parameter based 
	 * on lexicographical order
	 * 
	 * @param file the file to be searched
	 * @param word to be compared to see which comes before it
	 * @return the word that comes after 'word'
	 */

	public static String WordAfter(File file, String word) {

		Scanner s = createScanner(file);
		
		// To start assume no word comes after 'word'
		String wordAfter = word;
		boolean wordAfterFound = false;

		while (s.hasNext()) {

			String next = s.next();
			next.toLowerCase();

			//check to see if there is a word that comes after 'word'
			if (!wordAfterFound) {
				if (next.compareTo(word) > 0) {
					wordAfter = next;
					wordAfterFound = true;
					System.out.println(wordAfter);
				}
			} 
			// If a word after has been found this will execute
			// Checks to see if the next word comes before 'wordAfter' and after 'word'.
			else {
				if ((next.compareTo(word) > 0)
						&& (next.compareTo(wordAfter) < 0)
						&& !next.equalsIgnoreCase(word)) {
					wordAfter = next;
					System.out.println(wordAfter);
				}
			}

		}
		s.close();
		return wordAfter;
	}

	/**++++++++++++++++++++++++++NOT DONE+++++++++++++++++++++++++
	 * This method creates a scanner object containing a file
	 * 
	 * @param file to be scanned
	 * @return a
	 */

	public static Scanner createScanner(File file) {

		try {
			Scanner s = new Scanner(file);
			return s;
		} catch (FileNotFoundException e) {
			System.out.println(file + " was not found");
			System.exit(0);
		}
		// if user didn't pick a valid entry Program will exit, this won't be
		// returned.
		return null;

	}
	
	public static int findMostCommonLetter(File file, String word){
		
		char firstCharacter = word.charAt(0);
		int count = 0;
		
		Scanner s = createScanner(file);
		
		while (s.hasNext()){
			String tempWord = s.next().toLowerCase();
			
			char [] wordArray = new char [tempWord.length()];
			
			for(int i = 0; i< wordArray.length; i++){
				wordArray[i]= tempWord.charAt(i);
				
				
				if(wordArray[i]== firstCharacter){
					
					count++;
				}
			}
		}
		return count;
	}
	
	
	
	
	
	public static int count(File file) {

		int count = 0;

		Scanner s = createScanner(file);
		while (s.hasNext()) {
			s.next();
			count++;
		}
		return count;
	}

}
