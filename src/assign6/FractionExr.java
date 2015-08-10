package assign6;





public class FractionExr {
	
	 
	
	public static void main(String[] args) {
		
		Fraction intermiadate = new Fraction(0,1);
		Fraction pi = new Fraction(0,1);
		String piString = "";
		
	
		//return pi as a fraction
		for(long i =0; i< 4; i++){
			
			long den = power(i);
			//System.out.println(den);
			
			intermiadate =( new Fraction(1, den))
					.multiply((new Fraction(4,(8*i+1)).subtract(new Fraction(2, (8*i + 4))) 
					.subtract(new Fraction(1, 8*i +5))
					.subtract(new Fraction(1,8*i+6))));
			
			//System.out.println("max: " + Long.MAX_VALUE);
			//System.out.println("dif: " + (Long.MAX_VALUE - pi.getDenimantor()));
			
			
			//System.out.println("den: " +pi.getDenimantor() + " " + i );
			System.out.println(intermiadate.toString());
			piString += intermiadate.toString() + " + ";
			pi = pi.add(intermiadate);
			
			
		}
		//System.out.println("max value " + Long.MAX_VALUE);
		//System.out.println("denimtor  " + pi.getDenimantor());
		
		System.out.println(pi.toString());
		System.out.println(piString);
		
		System.out.println(pi.toDouble());
		
	}
	
	/**
	 * this helper method returns 16 to the nth power
	 * @param exponent 
	 * @return 16 the the nth power
	 */
	
	public static long power(long n){
		if (n ==0)
			return 1;
		else		
			return 16 * power(n-1);
	}
	

}
