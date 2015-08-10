package assign6;



/**
 * This class uses objects and methods from the Fraction class to compute an  of pi. 
 * @author James Yeates
 *
 */
public class FractionExtra {

	public static void main(String[] args) {

		int  numberOfSteps = 0;
		Fraction intermiadate = new Fraction(0, 1);
		Fraction pi = new Fraction(0, 1);
		
		for (long i = 0; i < 4; i++) {

			long den = power(i);
			
			//Equation for pi
			intermiadate = (new Fraction(1, den)).multiply((new Fraction(4,
					(8 * i + 1)).subtract(new Fraction(2, (8 * i + 4)))
					.subtract(new Fraction(1, 8 * i + 5))
					.subtract(new Fraction(1, 8 * i + 6))));
			pi = pi.add(intermiadate);
			numberOfSteps++;

			
			/*
			 * These print statements below were used to determine when overflow occurred
			 */
			// System.out.println("max: " + Long.MAX_VALUE);
			// System.out.println("dif: " + (Long.MAX_VALUE -
			// pi.getDenimantor()));

			//System.out.println("den: " +pi.getDenimantor() + " " + i );
			//System.out.println(intermiadate.toString());
	}
	
		
		System.out.println("The fraction result of this computation is pi approx = " +pi.toString());
		System.out.println("The double result of this computaion is pi approx= " +pi.toDouble());
		System.out.println("The main computaion was performed " + numberOfSteps + " before overflow occured");

	}

	/**
	 * this helper method returns 16 to the nth power
	 * 
	 * @param exponent
	 * @return 16 the the nth power
	 */

	public static long power(long n) {
		if (n == 0)
			return 1;
		else
			return 16 * power(n - 1);
	}

}
