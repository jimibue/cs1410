package assign1;

import java.util.InputMismatchException;
import java.util.Scanner;

/*This program determines the minimum collection of coins that makes up the number of cents given by the user. 
  In this program input and output is achieved by using the console.  This program also deals with incorrect input.
 
  Author James Yeates
*/

public class MakeChangeConsole {
	
	//declare static variable change
	 static int change;

	 
	public static void main(String[] args) {
	
		//Initialize variables, set initial values to 0	
		int quarters = 0;
		int dimes = 0;
		int nickles = 0;
		int pennies = 0;
		 
		
		//Create a Scanner object "input", this will be used to get input from the user
		Scanner input = new Scanner(System.in);
		
		//prompt user for input, which  will be displayed on the console
		System.out.println("Please enter an amount of cents  as a positive integer");
	
		// try-catch block to check for proper input, and  handle a input mismatch exception
		try{
		
			//assign "change" to the value entered by the user, must be an integer.
			change = input.nextInt();
		}
	
		// if user did not enter an a value of type int this code will execute.
		catch(InputMismatchException e){
			String incorrectChange = input.next();
			System.out.println("'"  +incorrectChange+"' was not a valid entry.");
			System.out.println("Please enter a integer between 0 and 2147483647 next time.");
		
			//Exit program
			System.exit(0);
		}
		//checks to see if user entered a  negative number.
		if(change <0){
			System.out.println( change + " was not a valid entry.");
			System.out.println("Please enter a integer between 0 and 2147483647 next time.");
	
			//Exit Program
			System.exit(0);
		}
	
		/* These 4 'if statements' determine the minimum collection of coins that makes up the 
		/  number of cents given by the user.
		 */

		if (change >=25){
			quarters = change/25;
			change = change%25;
		}
	
		if (change >=10){
			dimes = change/10;
			change = change%10;
		}
	
		if (change >= 5){
			nickles = change/5;
			change = change%5;
		}
	
		if ( change <5 ){
			pennies = change/1;
		}
	
		// Print out results to the console
		System.out.println("Number of quarters: " + quarters);
		System.out.println("Number of dimes: " + dimes);
		System.out.println("Number of nickles: " + nickles);
		System.out.println("Number of pennies: " + pennies);
	
	}//End main

}//End MakeChangeConsule class
