package assign1;

import javax.swing.JOptionPane;

/*This program determines the minimum collection of coins that makes up the number of cents given by the user. 
In this program input and output is achieved by using the JOptionPane class
* 
* Author James Yeates
*/

public class MakeChange {
	
	public static void main(String[] args) {
		
		//Initialize variables, 
		int quarters = 0;
		int dimes = 0;
		int nickles = 0;
		int pennies = 0;
		
		
		// Get input from user, which is of type String... This program assumes that user inputs a number greater or equal to zero
		String changeInput= JOptionPane.showInputDialog("Please enter number of cents");
		
		// Converts the input from the user from a String to an integer. 
		// The variable change represents the amount of cents
		int change = Integer.parseInt(changeInput);
		
		
		//Determine the minimum collection of coins that makes up the number of cents given by the user.
			
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
			
		
		
		
		//Show the results
		JOptionPane.showMessageDialog(null,"Number of quarters:  " + quarters + "\nNumber of dimes:  "
		+ dimes	+ "\nNumber of nickles:  " + nickles + "\nNumber of pennies:  " + pennies 	);
	
	}//end main

}//end class MakeChange