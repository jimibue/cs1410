package assign7;
/**
 * This class tests the DynamicArray2 class
 * @author James Yeates
 *
 */

public class DynamicArray2Tester {
	
	public static void main(String[] args) {
		
		
		DynamicArray2 tester = new DynamicArray2();
		
		if(tester.size() != 0){
			System.out.println("Failed at  " +getLine() + "tester.size should be 0 and is "+ tester.size());
		}
		if(tester.getDataLength() != 8){
			System.out.println("Failed at " + getLine() + " getDataLength should be 8 and is " + tester.getDataLength());
		}
		
		for(int i = 0; i<8; i++){
			tester.add("blank");
		}
		if(tester.size() != 8){
			System.out.println("Failed at " +getLine() + " tester.size should be 8 and is "+ tester.size());
		}
		if(tester.getDataLength() != 8){
			System.out.println("Failed at  " + getLine() + " getDataLength should be 8 and is " + tester.getDataLength());
		}
		if(!(tester.toString().equals("[blank, blank, blank, blank, blank, blank, blank, blank]")))
			System.out.println("Failed at  " + getLine());
		
		tester.add(0, "Yo!");
		if(!(tester.toString().equals("[Yo!, blank, blank, blank, blank, blank, blank, blank, blank]")))
			System.out.println("Failed at " + getLine() + " test.toString() is" + tester.toString());
		
	
		
		if(tester.size() != 9){
			System.out.println("Failed at " +getLine() + " tester.size should be 9 and is "+ tester.size());
		}
		tester.add(9, "Yo!");
		if(!(tester.toString().equals("[Yo!, blank, blank, blank, blank, blank, blank, blank, blank, Yo!]")))
			System.out.println("Failed at " + getLine() + " test.toString() is" + tester.toString());
		
		tester.remove(9);
		if(!(tester.toString().equals("[Yo!, blank, blank, blank, blank, blank, blank, blank, blank]")))
			System.out.println("Failed at " + getLine() + " test.toString() is" + tester.toString());
		
		if(tester.size() != 9){
			System.out.println("Failed at " +getLine() + " tester.size should be 9 and is "+ tester.size());
		}
		
		
		
		
		tester.remove(0);
		if(!(tester.toString().equals("[blank, blank, blank, blank, blank, blank, blank, blank]")))
			System.out.println("Failed at " + getLine() + " test.toString() is" + tester.toString());
		
		if(tester.size() != 8){
			System.out.println("Failed at " +getLine() + " tester.size should be 8 and is "+ tester.size());
		}
		tester.set(3, "three");
		if(!(tester.get(3).toString().equals("three")))
			System.out.println("Failed at " + getLine() + ", tester.get(3).toString() should be \"three\" but is " + tester.get(3).toString());
			
		
		try {
			System.out.println(tester.get(8).toString());
		}catch(IndexOutOfBoundsException e){}
		
		try {
			System.out.println(tester.get(9));
		}catch(IndexOutOfBoundsException e){}
		
		if(tester.getDataLength() != 16){
			System.out.println("Failed at " + getLine() + " getDataLength should be 16 and is " + tester.getDataLength());
		}
		
		DynamicArray2 tester2 = new DynamicArray2();
		
		for(int i = 0; i<9; i++){
			tester2.add("blank");
		}
		if(tester2.size() != 9){
			System.out.println("Failed at " +getLine() + " tester.size should be 9 and is "+ tester2.size());
		}
		if(tester2.getDataLength() != 16){
			System.out.println("Failed at " + getLine() + " getDataLength should be 16 and is " + tester2.getDataLength());
		}
		
		DynamicArray2 test1 = new DynamicArray2();
		
		test1.add("zero");
		test1.add("one");
		test1.add("two");
		test1.add("three");
		test1.add("four");
		test1.add("five");
		test1.add("six");
		test1.add("seven");
		
		if(! (test1.toString().equals("[zero, one, two, three, four, five, six, seven]"))){
			System.out.println("Failed at " + getLine());
		}
		
		
		for(int i = 8; i<16; i++)
			test1.add(i, "yo!");
		if(!( test1.toString().equals("[zero, one, two, three, four, five, six, seven," +
				" yo!, yo!, yo!, yo!, yo!, yo!, yo!, yo!]")))
			System.out.println("Failed at " + getLine());
		
		
		////////set testing/////////////
		
		DynamicArray2 test2 = new DynamicArray2();
		
		test2.add("zero");
		test2.add("one");
		test2.add("two");
		test2.add("three");
		test2.add("four");
		test2.add("five");
		test2.add("six");
		test2.add("seven");
		
		test2.set(7, "Yo");
		
		if(!( test2.toString().equals("[zero, one, two, three, four, five, six, Yo]")))
			System.out.println(getLine() + " test2.toString should equal \"[zero, one, two, three, four, five, six, Yo\"  but is" 
					+ test2.toString());
		
		test2.set(0, "Yo");
		
		if(!( test2.toString().equals("[Yo, one, two, three, four, five, six, Yo]")))
			System.out.println(getLine() + " test2.toString should equal \"[Yo, one, two, three, four, five, six, Yo\"  but is" 
					+ test2.toString());
		
		try{
			test2.set(-1, "uiou");
			System.out.println(getLine() + " Exception should have been caught");
		}catch ( IndexOutOfBoundsException e){}
		
		try{
			test2.set(8, "uiou");
			System.out.println(getLine() + " Exception should have been caught");
		}catch ( IndexOutOfBoundsException e){}
		
		for( int i = 0; i< 8; i++)
			test2.remove(0);
		
		if(!( test2.toString().equals("[]")))
			System.out.println(getLine() + " test2.toString should equal \"[]\"  but is" 
					+ test2.toString());
		
		try{
			test2.set(0, "uiou");
			System.out.println(getLine() + " Exception should have been caught");
		}catch ( IndexOutOfBoundsException e){}
		
		DynamicArray2 tester3 = new DynamicArray2();
		
		for(int i = 0; i< 5; i++)
			tester3.add(0, "yo");
			
		if (! (tester3.toString().equals("[yo, yo, yo, yo, yo]")))
				System.out.println(getLine() + " tester3.toString() should be \"[yo, yo, yo, yo, yo]\" but is " + tester3.toString());

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
