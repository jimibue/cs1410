package assign6;

/**
 * This class contains ways to create and perform basic mathematical operations
 * on fractions
 * 
 * @author James Yeates
 * 
 */

public class Fraction {

	// instance variables
	private long numerator;
	private long denominator;

	/**
	 * this constructs a simplified fraction
	 * 
	 * @param _numerator
	 *            the numerator of the fraction of type long
	 * @param _denominator
	 *            the denominator of the fraction of type long
	 */

	public Fraction(long _numerator, long _denominator) {

		// 1) To avoid divide-by-0 errors, denominators set to 0 are not
		if (_denominator == 0)
			throw new RuntimeException("division by 0");

		// 2) Initialize the two instance variables using the parameter values.
		numerator = _numerator;
		denominator = _denominator;

		// 3) Handle negative values consistently.

		if (numerator < 0 && denominator < 0 || denominator < 0
				&& numerator > 0) {
			numerator *= -1;
			denominator *= -1;
		}

		// 4) Reduce the fraction.

		long tempDenomintar = Math.abs(denominator);
		long tempNumerator = Math.abs(numerator);
		long GCD = gcd(tempDenomintar, tempNumerator);

		numerator /= GCD;
		denominator /= GCD;

	}

	/**
	 * Constructs a fraction with denominator set to 1
	 * 
	 * @param numerator
	 *            the numerator of the fraction of type long
	 */
	public Fraction(long numerator) {
		this.numerator = numerator;
		denominator = 1;
	}

	/**
	 * Returns the sum of 'this' Fraction and 'other' Fraction
	 * 
	 * @param other
	 *            the Fraction to be added to 'this'
	 * @return A new Fraction
	 */

	public Fraction add(Fraction other) {

		return new Fraction(
				(this.numerator * other.denominator + other.numerator
						* this.denominator),
				(this.denominator * other.denominator));
	}

	/**
	 * this method subtracts 'other' from 'this' Fraction and returns a new
	 * Fraction
	 * 
	 * @param other
	 *            Fraction subtracted from 'this'
	 * @return a new Fraction
	 */

	public Fraction subtract(Fraction other) {
		return new Fraction(
				(this.numerator * other.denominator - other.numerator
						* this.denominator),
				(this.denominator * other.denominator));
	}

	/**
	 * This method multiplies two Fractions
	 * 
	 * @param other
	 *            the Fraction to be multiplied with 'this'
	 * @return Fraction
	 */
	public Fraction multiply(Fraction other) {
		return new Fraction(this.numerator * other.numerator, this.denominator
				* other.denominator);
	}

	/**
	 * divides two Fraction
	 * @param other the fraction 'this' is divided by
	 * @return a new Fraction
	 */
	public Fraction divide(Fraction other) {
		return new Fraction(this.numerator * other.denominator,
				this.denominator * other.numerator);
	}
	
	/**
	 * takes 'this' Fraction and converts it to a double
	 * @return a double representation of a fraction
	 */

	public double toDouble() {
		
		return (double) this.numerator / this.denominator;
	}
	
	/**
	 * Returns a Fraction as a String
	 * @return String
	 */
	public String toString() {
	
		return numerator + "/" + denominator;
	}
	
	/**
	 * Checks to see if to Fraction are equal
	 * does not check for logical equality i.e.
	 * 1/2 does not equal 2/4
	 * 
	 * @param Object the Fraction to be checked for equality
	 * @return boolean
	 */

	public boolean equals(Object other) {
		if (!(other instanceof Fraction)) {
			return false;
		}

		Fraction rhs = (Fraction) other;

		if (this.numerator == rhs.numerator
				&& this.denominator == rhs.denominator)
			return true;
		else
			return false;

	}
	/**
	 * returns the denominator
	 * @return long
	 */

	public long getDenimantor() {
		return denominator;
	}
	
	/**
	 * This helper method finds the greatest common divisor of two integers
	 * 
	 * 
	 * @param p first long
	 * @param q second long
	 * @return the greatest common divisor
	 */
	public static long gcd(long p, long q) {
		while (q != 0) {
			long temp = q;
			q = p % q;
			p = temp;
		}
		return p;
	}

}
