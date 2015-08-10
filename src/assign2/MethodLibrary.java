package assign2;

/**
 * 
 * @author James Yeates
 * @version 1.0
 */


public class MethodLibrary {

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
	 * This subroutine converts a given amount of coins to dollars
	 * @param quaters the number of quarters
	 * @param nickels the number of nickels
	 * @param dimes the number of dimes
	 * @param pennies the number of pennies
	 * @return the amount of money in dollars
	 */

	public static double convertCoinsToDollars(int quarters, int dimes, int nickels, int pennies){
		
		return (( quarters*25  + dimes*10 + nickels*5 + pennies)/100.0);
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
	 *  @param number the number to be tested if negative
	 * @return true if number entered is negative, false if not
	 */

	public static boolean isNegative(int number){
		
		return (number <0 );
	}

	/**
	 *This subroutine determines if a game is over
	 *@param playerScore current score of the player
	 *@param numberOfLives number of lives player has
	 *@param gameLevel current level of the game
	 *@return true if game should be end, false otherwise 
	 */
	
	public static boolean isGameOver(int playerScore, int numberOfLives, int gameLevel){
		return ((numberOfLives == 0)|| (gameLevel==1 && playerScore<100)||(gameLevel ==2 && playerScore<200)|| (gameLevel>2 && (playerScore < 300)));
	}

	public static void main(String[] args) {

	

		System.out.println(convertLitersToGallons(4));
		// should be 1.056688

		System.out.println(convertCoinsToDollars(2, 13, 6, 2));
		// should be 2.12
	
		System.out.println(isNegative(7));
		// should be false

		System.out.println(isGameOver(150, 1, 2));
		// should be true

		// Extra Testing........
		
		//Test convertKilometersToMiles
		
		System.out.println("\n-----convertKilometersToMiles(int kilometers) testing-------\n");
		System.out.println("testing input value 0 should return 0.0:  " +convertKilometersToMiles(0));
		System.out.println("testing input value 1 should return 0.621371:  " +convertKilometersToMiles(1));
		System.out.println("testing input value -2 should return -1.242742:  " +convertKilometersToMiles(-2));
		System.out.println("testing input value 32890 should return 20436.89219:  "+convertKilometersToMiles(32890));
		
		//test convertLitersToGallons 
		
		System.out.println("\n-----convertLitersToGallons testing(int liters) -------\n");
		System.out.println("testing input value 0 should return 0.0:  " + convertLitersToGallons(0));
		System.out.println("testing input value 1 should return .264172:  " + convertLitersToGallons(1));
		System.out.println("testing input value -2 should return -0.528344:  " + convertLitersToGallons(-2));
		System.out.println("testing input value 4000000 should return 1056688.0:  " + convertLitersToGallons(4000000));
		
		// test convertCoinsToDollars
		
		System.out.println("\n-----convertCoinsToDollars testing(int quarters,int dimes, int nickels, int pennies)-------\n");
		System.out.println("Testing input values 0,0,0,0  should return 0.0:  " + convertCoinsToDollars(0, 0, 0, 0));
		System.out.println("Testing input values 1,1,1,1  should return 0.41:  " + convertCoinsToDollars(1, 1, 1, 1));
		System.out.println("Testing input values -2,-2,-2,-2  should return -0.82 :  " + convertCoinsToDollars(-2, -2, -2, -2));
		System.out.println("Testing input values 100,97,34,-2  should return 36.38 :  " + convertCoinsToDollars(100, 97, 34, -2));
		
		//test isEven
		
		System.out.println("\n-----isEven Method(int number) testing-------\n");
		System.out.println("testing input value 3 should return false:  "+ isEven(3));
		System.out.println("testing input value 0 should return true:  "+ isEven(0));
		System.out.println("testing input value -4 should return true:  "+isEven(-4));
		System.out.println("testing input value 32890 should return true:  "+isEven(32890));
		
		//test isNegative
		
		System.out.println("\n-----isNegative Method(int number) testing-------\n");
		System.out.println("testing input value 3 should return false:  "+ isNegative(3));
		System.out.println("testing input value 0 should return false:  "+ isNegative(0));
		System.out.println("testing input value -4 should return true:  "+isNegative(-4)); 
		
		//test isGameOver
		
		System.out.println("\n-----isGameOver(int playerScore, int numberOfLives, int gameLevel) testing-------\n");
		System.out.println("testing values 100, 1, 1 should retun false: "+ isGameOver(100, 1, 1));
		System.out.println("testing values 200, 1, 2 should retun false: "+ isGameOver(200, 1, 2));
		System.out.println("testing values 300, 1, 4 should retun false: "+ isGameOver(300, 1, 4));
		System.out.println("testing values 99, 1, 1 should retun true: "+ isGameOver(99, 1, 1));
		System.out.println("testing values 99, 0, 1 should retun true: "+ isGameOver(99, 0, 1));
		System.out.println("testing values 199, 1, 2, should retun true: "+ isGameOver(199, 1, 2));
		System.out.println("testing values 299, 1, 3, should retun true: "+ isGameOver(299, 1, 3));
		
		
		
		
		
		
	}//end main

}//end MethodLibrary class
