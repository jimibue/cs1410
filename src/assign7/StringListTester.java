package assign7;
/**
 * This class test the StringList class
 * @author James Yeates
 *
 */

public class StringListTester {
	
	public static void main(String[] args) {
		
		StringList sList = new StringList();
		
		if(sList.size() != 0)
			System.out.println(getLine()+ " sList.size() != 0,  sList.size() equals should equal 0 but equals " +sList.size() );
		
		
		for(int i = sList.size(); i<10; i++)
			sList.insert("Yo", i);
			
		if( ! (sList.contains("Yo")))
			System.out.println(getLine() + " (sList.contains(\"Yo\")) should be true but is " +(sList.contains("Yo")));
		
		if (sList.contains("Yo0"))
			System.out.println(getLine() + " (sList.contains(\"Yo0\")) should be false but is " +(sList.contains("Yo0")));
		
		if (sList.size() != 10)
			System.out.println(getLine() + " sList.size() != 10, sList.size() equals " +sList.size()  );
		
		
		sList.remove("Yo");
		
		
		if( (sList.contains("Yo")))
			System.out.println(getLine() + " (sList.contains(\"Yo\")) should be true but is " +(sList.contains("Yo")));
		
		
		
		///////////L1 testing///////
		
		StringList l1 = new StringList();
		
		try{
			l1.insert(null,0);
			System.out.println(getLine() +" Exception should have been caught");
		}catch(IllegalArgumentException e){}
		
		try{
			l1.insert("zero", 1);
			System.out.println(getLine() + " Excaption should have been caught");
		}catch (IndexOutOfBoundsException e){}
		
		try{
			l1.insert("zero", -1);
			System.out.println(getLine() + " Excaption should have been caught");
		}catch (IndexOutOfBoundsException e){}
		
		
		for( int i = 0; i < 7; i++){
			l1.insert("yo", 0);
		}
		
		String s1 = "\"yo, yo, yo, yo, yo, yo, yo\"";
		String s2 = "\"zero, one, two, three, four, five, six, seven, yo, yo, yo, yo, yo, yo, yo\"";
		String s3 = "\"one, two, three, four, five, six, seven, yo, yo, yo, yo, yo, yo, yo\"";
		String s4 = "\"one, two, three, four, five, six, seven, yo, yo, yo, yo, yo, yo, yo, !!\"";
		String s5 = "\"one, two, three, four, five, six, seven, yo, yo, yo, yo, yo, yo, yo\"";
		
		
		if ( ! (l1.toString().equals(s1)))
			System.out.println(getLine() + " l1.to String should equal " + s1 + " equals " + l1.toString());
				
		l1.insert("one", 0);
		l1.insert("zero", 0);
		l1.insert("two", 2);
		l1.insert("three", 3);
		l1.insert("four", 4);
		l1.insert("five", 5);
		l1.insert("six", 6);
		l1.insert("seven", 7);
		
		
		
		if ( ! (l1.toString().equals(s2)))
			System.out.println(getLine() + " l1.to String should equal " + s2 + " equals " + l1.toString());
		
		l1.remove("zero");
		
		if ( ! (l1.toString().equals(s3)))
			System.out.println(getLine() + " l1.to String should equal " + s3 + " equals " + l1.toString());
		
		
		try{
			l1.insert("!!", 15);
			System.out.println(getLine() + " Should have thrown exception");
		}catch(IndexOutOfBoundsException e){}
		
		l1.insert( "!!", 14);
		
		if ( ! (l1.toString().equals(s4)))
			System.out.println(getLine() + " l1.to String should equal " + s4 + " equals " + l1.toString());
		
		
		l1.remove("!!");
		
		if ( ! (l1.toString().equals(s5)))
			System.out.println(getLine() + " l1.to String should equal " + s5 + " equals " + l1.toString());
		
		
		System.out.println("Testing done.");
	}
	
	
	
	public static String getLine() {
	    return " Failed at line: " +Thread.currentThread().getStackTrace()[2].getLineNumber();
	}

}
