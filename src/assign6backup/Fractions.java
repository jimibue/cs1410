package assign6backup;

public class Fractions {

	private long numerator;
	private long denominator;
	
	/**
	 * this constructs a simplified fraction
	 * @param _numerator the numerator of the fraction of type long
	 * @param _denominator the denominator of the fraction of type long
	 */

	public Fractions(long _numerator, long _denominator) {

		// FILL IN this constructor according to the instructions below.

		// 1) To avoid divide-by-0 errors, denominators set to 0 are not
		// allowed.
		// Throw a RuntimeException, as needed.
		if (_denominator == 0) {
			throw new RuntimeException("division by 0");

		}
		if (_numerator < Long.MIN_VALUE || _numerator > Long.MAX_VALUE
				|| _denominator > Long.MAX_VALUE || _numerator < Long.MIN_VALUE)
			throw new RuntimeException("Overflow Error!");

		// 2) Initialize the two instance variables using the parameter values.
		numerator = _numerator;
		denominator = _denominator;

		// 3) Handle negative values consistently.
		// a) If both the numerator and denominator are negative, the
		// two negative signs cancel each other and the resulting
		// fraction is positive. For example, -3/-4 should be
		// represented as simply 3/4.
		// b) If only denominator is negative, transfer the negative
		// sign to the numerator. For example, 3/-4 should be
		// represented as -3/4.
		// c) If only the numerator is negative, keep the negative sign
		// with the numerator.

		if (numerator < 0 && denominator < 0 || denominator < 0
				&& numerator > 0) {
			numerator *= -1;
			denominator *= -1;
		}

		// 4) Reduce the fraction.
		// For example, the fraction 2/4 should be reduced to 1/2.
		// All fractions must be represented in reduced form; i.e.,
		// the numerator and denominator should not have any common factors.

		long tempDenomintar = Math.abs(denominator);
		long tempNumerator = Math.abs(numerator);
		long GCD = tempDenomintar;

		// if(tempNumerator> tempDenomintar){
		// long temp = tempDenomintar;
		// tempDenomintar = tempNumerator;
		// tempNumerator = temp;
		//
		// }
		GCD = gcd(tempDenomintar, tempNumerator);

		numerator /= GCD;
		denominator /= GCD;

	}

	// ADD a second constructor with one parameter for the numerator. When this
	// constructor is used, the denominator is assumed to be 1. For example, the
	// new Fraction(3) creates a fraction represented as 3/1.

	public Fractions(long numerator) {
		this.numerator = numerator;
		denominator = 1;
	}

	public Fractions add(Fractions other) {
		// FILL IN to return the sum of the fraction represented by this object
		// and the fraction represented by the parameter called other
		// (i.e., this + other).

		// DO NOT return null.
		// The following statement is a temporary placeholder to prevent a
		// compiler
		// error. Remove when you implement this method.
		return new Fractions(
				(this.numerator * other.denominator + other.numerator
						* this.denominator),
				(this.denominator * other.denominator));
	}

	// (For each of the next three methods that you are to write from scratch,
	// use the method header provided for the add method as a guide.)

	// ADD a method called subtract that returns the difference in the fraction
	// represented by this object and the fraction represented by the parameter
	// (i.e., this - other).

	public Fractions subtract(Fractions other) {
		return new Fractions(
				(this.numerator * other.denominator - other.numerator
						* this.denominator),
				(this.denominator * other.denominator));
	}

	// ADD a method called multiply that returns the product of the fraction
	// represented by this object and the fraction represented by the parameter
	// (i.e., this * other).
	public Fractions multiply(Fractions other) {
		return new Fractions(this.numerator * other.numerator, this.denominator
				* other.denominator);
	}

	// ADD a method called divide that returns the quotient of dividing the
	// fraction represented by this object by the fraction represented by the
	// parameter
	// (i.e., this / other).
	public Fractions divide(Fractions other) {
		return new Fractions(this.numerator * other.denominator,
				this.denominator * other.numerator);
	}

	public double toDouble() {
		// FILL IN to return the floating-point value equivalent to the fraction
		// represented by this object.

		// DO NOT return 0.0, unless appropriate for the fraction.
		// The following statement is a temporary placeholder to prevent a
		// compiler
		// error. Remove when you implement this method.
		return (double) this.numerator / this.denominator;
	}

	public String toString() {
		// FILL IN to return the fraction represented by this object as a
		// string (e.g., "1/2").

		// DO NOT return null.
		// The following statement is a temporary placeholder to prevent a
		// compiler
		// error. Remove when you implement this method.
		return numerator + "/" + denominator;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Fractions)) {
			return false;
		}

		Fractions rhs = (Fractions) other;

		// FILL IN to return true if the fraction represented by this object is
		// equivalent to the fraction called rhs.

		// DO NOT return false, unless appropriate for the fraction.
		// The following statement is a temporary placeholder to prevent a
		// compiler
		// error. Remove when you implement this method.
		if (this.numerator == rhs.numerator
				&& this.denominator == rhs.denominator)
			return true;
		else
			return false;

	}

	public long getDenimantor() {
		return this.denominator;
	}

	public static long gcd(long p, long q) {
		while (q != 0) {
			long temp = q;
			q = p % q;
			p = temp;
		}
		return p;
	}
}
