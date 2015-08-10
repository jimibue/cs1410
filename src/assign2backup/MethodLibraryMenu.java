package assign2backup;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class MethodLibraryMenu {
	/**
	 * This subroutine converts kilometers to miles
	 * @param kilometers  the distance to be converted to miles
	 * @return distance in miles
	 */

	public static double convertKilometersToMiles(int kilometers) {
	
		return kilometers*.621371;
	}
	
	/**
	 * This subroutine converts liters to gallons
	 * @param liters  the amount of liters to be converted into gallons 
	 * @return the amount of gallons
	 */

	public static double convertLitersToGallons(int liters){
		
		return liters * .264172;
	}
	
	/**
	 * This subroutine determines if a number is even
	 * @param number the integer to be tested if even
	 * @return true if number entered is even, false if not
	 */

	public static boolean isEven(int number){

		return (number%2 == 0);
	}
	
	/**
	 * this subroutine determines if a number is negative
	 * 
	 * @param number the number to be tested if negative
	 * @return true if number entered is negative, false if not
	 */

	public static boolean isNegative(int number){
		
		return (number <0 );
	}
	
	public static void main(String [] args){
		
		
		
		
		
		//Shows menu and gets input from user for which method to perform.
		
		String intialInput = JOptionPane.showInputDialog("1: Convert kilometers to miles\n"+
		"2: Convert liters to gallons\n3: Check for even\n4: Check for negative\nEnter your selection: ");
		
		//check that user enter a integer, if not exit program
		
		int methodChoice = -1;
		
		try{
			 methodChoice = Integer.parseInt(intialInput);
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "You did not make a valid selction." );	
			System.exit(0);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "An unknown error occurred." );	
			System.exit(0);
			
		}
			
		
		
		// if, if else statements below determine which of the four methods to perform based on user input
		
		if(methodChoice ==1){
			
			// get user input
			
			String kilometerInput = JOptionPane.showInputDialog("Enter number of kilometers: ");
			int kilometers = Integer.parseInt(kilometerInput);
			
			//check to see if user entered a negative number, if so exit program. if not program proceeds.
			
			
			if (kilometers <0 ){
				JOptionPane.showMessageDialog(null, "You entered a negative number, please enter a positive number next time.");
				System.exit(0);
			}
			else{
				double miles = convertKilometersToMiles(kilometers);
				JOptionPane.showMessageDialog(null, kilometers+ " kilometers is " + miles + " miles.");
			}
		}
		
		else if(methodChoice == 2){
			
			//get user input
			
			String literInput = JOptionPane.showInputDialog("Enter number of liters: ");
			int liters = Integer.parseInt(literInput);
			
			//check to see if user entered a negative number, if so exit program. if not program proceeds.
			
			if (liters <0 ){
				JOptionPane.showMessageDialog(null, "You entered a negative number, please enter a positive number next time.");
				System.exit(0);
			}
			else{
				double gallons = convertLitersToGallons(liters);
				JOptionPane.showMessageDialog(null, liters + " liters is " + gallons + " gallons.");
			
			}
		}
		
		else if (methodChoice == 3){
			
			//get user input
			
			String numberInput = JOptionPane.showInputDialog("Enter a integer: ");
			int number = Integer.parseInt(numberInput);
			
			if(isEven(number)){
				JOptionPane.showMessageDialog(null, number + " is even.");
			}
			else{
				JOptionPane.showMessageDialog(null, number + " is odd.");
			}
				
		}
		
		else if(methodChoice == 4){
			
			//get user input
			
			String numberInput1 = JOptionPane.showInputDialog("Enter a integer: ");
			int number1 = Integer.parseInt(numberInput1);
			
			if(isNegative(number1)){
				JOptionPane.showMessageDialog(null, number1 + " is negative.");
			}
			else{
				JOptionPane.showMessageDialog(null, number1 + " is not negative.");
			}
					
		}
		
		// if user does not enter a number other than 1,2,3,4, this will execute
		
		else
			JOptionPane.showMessageDialog(null, "You did not make a valid selction." );	
			System.exit(0);
	
	
	
	}//end main
	

}// end MethodLibraryMethod class
