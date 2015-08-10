package assign6;



/**
 * This class test the Fraction class
 * @author James Yeates
 *
 */

public class FractionTester {
		
	public static void main(String args[]) {

		Fraction fourEighths = new Fraction(4, 8);
		Fraction zeroThirds = new Fraction (0, 3);
		
		
		//Fraction error = new Fraction(4,0);//throws RuntimeException
		
		Fraction alreadySimplified = new Fraction(-51,-100);
		
		Fraction trial1 = new Fraction(-500000,1000);
		
		Fraction oneThird1 = new Fraction(1,-3);
		
	
		double fourEighthsDouble = fourEighths.toDouble();
		if(fourEighthsDouble != 0.5)
			System.out.println("Test failed: The floating-point version of Fraction(4, 8) should be 0.5 but is " + fourEighthsDouble);
		
		double zeroThirdsDouble = zeroThirds.toDouble();
		if(zeroThirdsDouble != 0.0)
			System.out.println("Test failed: The floating-point version of Fraction (0, 3) should be 0.0 but is " + zeroThirdsDouble);
		
		double alreadySimplifiedDouble = alreadySimplified.toDouble();
		if(alreadySimplifiedDouble != 0.51)
			System.out.println("Test failed: The floating-point version of Fraction (-51, -100) should be .51 but is " + alreadySimplifiedDouble);
		
		double oneThirdDouble = oneThird1.toDouble();
		if(oneThirdDouble != 1.0/-3.0)
			System.out.println("Test failed: The floating-point version of Fraction (1,-3) should be -0.3333333333333333 but is " + oneThirdDouble);
		
		if(!fourEighths.equals(new Fraction(1, 2)))
			System.out.println("Test failed: Fraction(4, 8) should be equal to Fraction(1, 2)");
		
		// Caution: equals and toString methods must be correct to run this test
		
		
		Fraction oneFourth = new Fraction(1, 4);
		Fraction threeFourths = new Fraction(3, 4);
		Fraction threeFourthsAdd = fourEighths.add(oneFourth);
		
		if(!threeFourthsAdd.equals(threeFourths))
			System.out.println("Test failed: Fraction(4, 8) + Fraction(1, 4) should be \"3/4\" but is \"" + threeFourthsAdd + "\"");
		
		if(!fourEighths.equals(new Fraction(4, 8)) || !oneFourth.equals(new Fraction(1, 4)))
			System.out.println("Test failed: During Fraction(4, 8) + Fraction(1, 4), one or both of the operand fractions was modified.");
		
		if(!zeroThirds.add(oneFourth).equals(new Fraction(1,4)))
			System.out.println("Test Failed: \"zeroThirds.add(oneFourth) should be one fourth but is " +zeroThirds.add(oneFourth) );
		
		if(! new Fraction(0,100000).add(new Fraction(-99, 98)).equals(new Fraction (198*89,-196*89)))
			System.out.println("Test Failed> \"new Fraction(0,100000).add(new Fraction(-99/98)).equals(new Fraction (198*89,-196*89))\"" +
					"" +new Fraction(0,100000).add(new Fraction(-99/98)).toString() +" " + new Fraction (198*89,-196*89)+ " " + new Fraction(0,100000)
					+ " " + new Fraction(99/98) + "  " + new Fraction(98,99));
		
	   
		
		//* Uncomment after you implement the subtract method
		
		// Caution: equals and toString methods must be correct to run this test
		Fraction oneEighth = new Fraction(1, 8);
		Fraction threeEighths = new Fraction(3, 8);
		Fraction threeEighthsSubtract = fourEighths.subtract(oneEighth);
		
		if(!threeEighthsSubtract.equals(threeEighths))
			System.out.println("Test failed: Fraction(4, 8) - Fraction(1, 8) should be \"3/8\" but is \"" + threeEighthsSubtract + "\"");
		
		if(!fourEighths.equals(new Fraction(4, 8)) || !oneEighth.equals(new Fraction(1, 8)))
			System.out.println("Test failed: During Fraction(4, 8) - Fraction(1, 8), one or both of the operand fractions was modified.");
		//*/

		///* Uncomment after you implement the multiply method
		
		// Caution: equals and toString methods must be correct to run this test
		Fraction fiveThirds = new Fraction(5, 3);
		Fraction fiveSixths = new Fraction(5, 6);
		Fraction fiveSixthsMultiply = fourEighths.multiply(fiveThirds);
		
		if(!fiveSixthsMultiply.equals(fiveSixths))
			System.out.println("Test failed: Fraction(4, 8) * Fraction(5, 3) should be \"5/6\" but is \"" + fiveSixthsMultiply + "\"");
		
		if(!fourEighths.equals(new Fraction(4, 8)) || !fiveSixths.equals(new Fraction(5, 6)))
			System.out.println("Test failed: During Fraction(4, 8) * Fraction(5, 3), one or both of the operand fractions was modified.");
		//*/
		
		///* Uncomment after you implement the divide method

		// Caution: equals and toString methods must be correct to run this test
		Fraction oneThird = new Fraction(1, 3);
		Fraction threeHalves = new Fraction(3, 2);
		Fraction threeHalvesDivide = fourEighths.divide(oneThird);
		
		if(!threeHalvesDivide.equals(threeHalves))
			System.out.println("Test failed: Fraction(4, 8) / Fraction(1, 3) should be \"3/2\" but is \"" + threeHalvesDivide + "\"");
		
		if(!fourEighths.equals(new Fraction(4, 8)) || !oneThird.equals(new Fraction(1, 3)))
			System.out.println("Test failed: During Fraction(4, 8) / Fraction(1, 3), one or both of the operand fractions was modified.");
		//*/
		
		
		
		// Test second constructor
		Fraction five = new Fraction(5);
		
		String fiveString = five.toString();
		if(!(fiveString.equals("5/1")))
			System.out.println("Test failed: The string version of Fraction(5) should be \"5/1\" but is \"" + fiveString + "\"");

		double fiveDouble = five.toDouble();
		if(fiveDouble != 5.0)
			System.out.println("Test failed: The floating-point version of Fraction(5) should be 5.0 but is " + fiveDouble);
		
		if(!five.equals(new Fraction(5, 1)))
			System.out.println("Test failed: Fraction(5) should be equal to Fraction(5, 1)");
		
		
		// ADD at least three good tests per method (using those given as a guide).
		// Do this incrementally, one method at a time (easiest first).
		// Do not simply test the same features of your methods again and again.  
		// Attempt to test a wide range of possibilities (first the basics, then the interesting cases.)
		// Remember that as a tester, your job is to try breaking the class you have built.
		
		
		////////////////////////////////////////////////////////////////////////
		///////////////////ADDITIONAL TESTING////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		
		//toString, equals, first constructor testing
		
		Fraction bigOne = new Fraction(Long.MAX_VALUE ,Long.MAX_VALUE);
		
		if(! new Fraction(-1,-2).equals(new Fraction(1,2)))
			System.out.println("Failed at \"new Fraction(-1,-2).toString().equals((1/2))\"  " + new Fraction(-1,-2).toString() +" "+ getLine());
		
		if(! new Fraction(1,-2).toString().equals(("-1/2")))
			System.out.println("Failed at \"new Fraction(1,-2).toString().equals((-1/2))\"  " + new Fraction(1,-2).toString()+" "+ getLine());
		
		if(! new Fraction(-1,2).toString().equals(("-1/2")))
			System.out.println("Failed at \"new Fraction(-1,2).toString().equals((-1/2))\"  " + new Fraction(-1,2).toString()+" "+ getLine());
		
		String zeroThirdsString = zeroThirds.toString();
		if(!(zeroThirdsString.equals("0/1")))
			System.out.println("Test failed: The string version of Fraction(0,1) should be \"0/3\" but is \"" + zeroThirdsString + "\""+" "+ getLine());
		
		String alreadySimpifliedString = alreadySimplified.toString();
		if(!(alreadySimpifliedString.equals("51/100")))
			System.out.println("Test failed: The string version of Fraction(51,100) should be \"51/100\" but is \"" + alreadySimpifliedString + "\""
				+" "+ getLine());
		
		String trial1String = trial1.toString();
		if(!(trial1String.equals("-500/1")))
			System.out.println("Test failed: The string version of Fraction(-500000,1000); should be \"-500/1\" but is \"" + trial1String + "\""+
				" "+ getLine());
		
		String bigOneString = bigOne.toString();
		if((!bigOneString.equals("1/1")))
			System.out.println("Test failed: The string version of Fraction(Long.MAX_VALUE,Long.MAX_VALUE) ; should be \"1/1\" but is \"" + bigOneString+ "\""+" "+ getLine());
		
		if( new Fraction(Long.MAX_VALUE,Long.MAX_VALUE+1).equals(new Fraction(9223372036854775807l, 9223372036854775806l))){
			System.out.println("Failed at: " + getLine());
		}
		if(! (new Fraction(100, 51).toString().equals("100/51")))
			System.out.println("failed at " + getLine() + "  " + new Fraction(100, 51).toString());
		
		Fraction ab = new Fraction(100, 50);
		Fraction bc = new Fraction(100,50);
		
		if(!(ab.equals(bc)))
			System.out.println("failed at " + getLine() + " " + ab.toString() + " " + bc.toString());
			
		if(!( new Fraction(-100, 50).toString().equals("-2/1")))
			System.out.println("failed at " + getLine());
		
		if(!( new Fraction(100, -50).toString().equals("-2/1")))
			System.out.println("failed at " + getLine() + " " + new Fraction(100, -50).toString());
		
		
		
		//add  testing
		
		Fraction oneHalf = new Fraction(1,2);
		Fraction negativeOneHalf = new Fraction(-1,2);
		
		
		if(!( oneHalf.add(negativeOneHalf)).equals(new Fraction(0,1)))
			System.out.println("Test Failed: oneHalf.add(negativeOneHalf)).equals(0/1)" + getLine());
		
		
		if(! (negativeOneHalf.add(negativeOneHalf)).equals(new Fraction(-1,1)))
			System.out.println("Failed at \"negativeOneHalf.add(negativeOneHalf)).equals(new Fraction(-1,1)\" "+ getLine());
		
		if(! new Fraction(0,100000).add(new Fraction(-99, 98)).equals(new Fraction (198*89,-196*89)))
			System.out.println("Test Failed> \"new Fraction(0,100000).add(new Fraction(-99/98)).equals(new Fraction (198*89,-196*89))\"" +
					"" +new Fraction(0,100000).add(new Fraction(-99/98)).toString() +" " + new Fraction (198*89,-196*89)+ " " + new Fraction(0,100000)
					+ " " + new Fraction(99/98) + "  " + new Fraction(98,99));
		
		//subtract testing
		
		if(!( oneHalf.subtract(negativeOneHalf)).equals(new Fraction(1,1)))
			System.out.println("Test Failed: oneHalf.subtract(negativeOneHalf)).equals(new Fraction(0,1) " + getLine());
		
		if(! (negativeOneHalf.subtract(negativeOneHalf)).equals(new Fraction(0,1)))
			System.out.println("Failed at \"negativeOneHalf.subtract(negativeOneHalf)).equals(new Fraction(0,1)\" "+ getLine());
		
		if(!( new Fraction(5,16).subtract(new Fraction(3,4))).equals(new Fraction(-7,16)))
			System.out.println("Test Failed at " + getLine());
		
		
		// multiply testing
		
		if(!( oneHalf.multiply(negativeOneHalf)).equals(new Fraction(-1,4)))
			System.out.println("Test Failed: oneHalf.mulitply(negativeOneHalf)).equals(new Fraction(-1,4) " + getLine());
		
		if(! (negativeOneHalf.multiply(negativeOneHalf)).equals(new Fraction(1,4)))
			System.out.println("Failed at \"negativeOneHalf.mulitply(negativeOneHalf)).equals(new Fraction(1,4)\" "+ getLine());
		
		if(! ( new Fraction(-4).multiply(new Fraction(-1,2)).equals(new Fraction(2)))){
			System.out.println("failed" + getLine());
		}
		
		// divide testing
		
		if(!( oneHalf.divide(negativeOneHalf)).equals(new Fraction(-1,1)))
			System.out.println("Test Failed: oneHalf.divide(negativeOneHalf)).equals(new Fraction(-1,1) " + getLine());
		
		if(! (negativeOneHalf.divide(negativeOneHalf)).equals(new Fraction(1,1)))
			System.out.println("Failed at \"negativeOneHalf.divide(negativeOneHalf)).equals(new Fraction(1,1)\" "+ getLine());
		
		if(! ( new Fraction(-4).divide(new Fraction(-1,2)).equals(new Fraction(8))))
			System.out.println("failed" + getLine());
		
		//////// More random Testing///////////////////////////////
		double sum = 0.0;
		
	
		for ( long i = 0; i< 100; i ++){
			 sum +=  new Fraction(1, i+1).multiply(new Fraction(1,i+1)).toDouble();
			
		}
		//System.out.println(sum);
		
		//System.out.println(Math.sqrt(sum*6));
		if(!( Math.round(Math.sqrt(sum*6))==3))
			System.out.println("Failed " +  Math.round(Math.sqrt(sum*6)));
		
		sum = 0.0;
		double sumDivide = 0.0;
		
	
		for ( long i = 0; i< 1000; i ++){
			 sumDivide +=  new Fraction(1, i+1).divide(new Fraction(i+1,1)).toDouble();
			 sum +=  new Fraction(1, i+1).multiply(new Fraction(1,i+1)).toDouble();
		}
		
		if(sum != sumDivide)
			System.out.println("failed at " + getLine());
		
		
		System.out.println("Testing Done");
	}
	
	
	/** 
	 * This helper method prints the line it was called on
	 * @return  - Current line number.
	 */ 
	public static String getLine() {
	    return "line: " +Thread.currentThread().getStackTrace()[2].getLineNumber();
	}

}
