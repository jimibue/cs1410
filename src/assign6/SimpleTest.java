package assign6;



public class SimpleTest {
	
	public static void main(String[] args) {
		
	
		//Fraction big = new Fraction(Integer.MAX_VALUE+1, 1);
		//Fraction bigger = new Fraction(Long.MAX_VALUE-2, 10000000000l);
		System.out.println(Long.MAX_VALUE-2);
		System.out.println("s " +(double)9223372036854775805l/1000000000000l);
		//System.out.println(bigger);
		System.out.println("done");
		
		
		Fraction f = new Fraction(1,2);
		
		System.out.println(f.getClass().equals(Fraction.class) );
		
		
	
	
	
	
	
			
			
		
		
		
	}
	
	/*
	 * 	public Fraction add(Fraction other) {
		
		return new Fraction((this.numerator*other.denominator + other.numerator *this.denominator),
				(this.denominator * other.denominator));
	}
	 */

}
