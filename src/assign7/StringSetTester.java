package assign7;

/**
 * This class test the StringSet class
 * @author James Yeates
 *
 */

public class StringSetTester {
	
	public static void main(String[] args) {
		
		
		///Basic Testing///
		
		StringSet stringSet1 = new StringSet();
		
		if(! (stringSet1.toString().equals("{}")))
			System.out.println(getLine() + " s1.toString should equal \"{}\" but equals " + stringSet1.toString());	
		
		if(! (stringSet1.size() == 0))
			System.out.println(getLine() + "s1.size() should == 0 but equals " + stringSet1.size());
		
		stringSet1.insert("a");
		
		if(! (stringSet1.toString().equals("{a}")))
			System.out.println(getLine() + " s1.toString should equal \"{a}\" but equals " + stringSet1.toString());
		
		if(! (stringSet1.size() == 1))
			System.out.println(getLine() + "s1.size() should == 1 but equals " + stringSet1.size());
		
		stringSet1.insert("a");
		
		if(! (stringSet1.toString().equals("{a}")))
			System.out.println(getLine() + " s1.toString should equal \"{a}\" but equals " + stringSet1.toString());
		
		if(! (stringSet1.size() == 1))
			System.out.println(getLine() + "s1.size() should == 1 but equals " + stringSet1.size());
		
		stringSet1.insert("b");
		
		if(! (stringSet1.toString().equals("{a, b}")))
			System.out.println(getLine() + " s1.toString should equal \"{a, b}\" but equals " + stringSet1.toString());
		
		if(! (stringSet1.size() == 2))
			System.out.println(getLine() + "s1.size() should == 2 but equals " + stringSet1.size());
		
		stringSet1.remove("b");
		
		if(! (stringSet1.toString().equals("{a}")))
			System.out.println(getLine() + " s1.toString should equal \"{a}\" but equals " + stringSet1.toString());
		
		if(! (stringSet1.size() == 1))
			System.out.println(getLine() + "s1.size() should == 1 but equals " + stringSet1.size());
		
		stringSet1.remove("a");
		
		if(! (stringSet1.toString().equals("{}")))
			System.out.println(getLine() + " s1.toString should equal \"{}\" but equals " + stringSet1.toString());	
		
		if(! (stringSet1.size() == 0))
			System.out.println(getLine() + "s1.size() should == 0 but equals " + stringSet1.size());
		
		
		// less basic testing
		
		StringSet stringSet2 = new StringSet();
		String s1 = "{zero, one, two, three, four, five, six, seven, eight}";
		String s2 = "{zero, one, two, three, four, five, six, seven}";
		String s3 = "{one, two, three, four, five, six, seven}";
		
		
		stringSet2.insert("zero");
		stringSet2.insert("one");
		stringSet2.insert("two");
		stringSet2.insert("three");
		stringSet2.insert("four");
		stringSet2.insert("five");
		stringSet2.insert("six");
		stringSet2.insert("seven");
		stringSet2.insert("eight");
		stringSet2.insert("zero");
		stringSet2.insert("one");
		stringSet2.insert("two");
		stringSet2.insert("three");
		stringSet2.insert("four");
		stringSet2.insert("five");
		stringSet2.insert("six");
		stringSet2.insert("seven");
		stringSet2.insert("eight");
		
		if(!(stringSet2.toString().equals(s1)))
			System.out.println(getLine() + " stringSet2.toString() should be " + s1 + " but is " + stringSet2.toString());
		
		if(stringSet2.size() != 9)
			System.out.println(getLine() + " stringSet2.size() should equal 9 but is " +stringSet2.size());
		
		if(stringSet2.contains("Zero")){
			System.out.println(getLine());
		}
		if(!(stringSet2.contains("zero"))){
			System.out.println(getLine());
		}
		if(stringSet2.contains("Eight")){
			System.out.println(getLine());
		}
		if(!(stringSet2.contains("eight"))){
			System.out.println(getLine());
		}
		
		stringSet2.remove("eight");
		
		if(!(stringSet2.toString().equals(s2)))
			System.out.println(getLine() + " stringSet2.toString() should be " + s2 + " but is " + stringSet2.toString());
		
		if(stringSet2.size() != 8)
			System.out.println(getLine() + " stringSet2.size() should equal 9 but is " +stringSet2.size());
		
		stringSet2.remove("zero");
		
		if(!(stringSet2.toString().equals(s3)))
			System.out.println(getLine() + " stringSet2.toString() should be " + s3 + " but is " + stringSet2.toString());
		
		if(stringSet2.size() != 7)
			System.out.println(getLine() + " stringSet2.size() should equal 9 but is " +stringSet2.size());
		
		
		stringSet2.remove("one");
		stringSet2.remove("two");
		stringSet2.remove("three");
		stringSet2.remove("four");
		stringSet2.remove("five");
		stringSet2.remove("six");
		stringSet2.remove("seven");
		
		if(!(stringSet2.toString().equals("{}")))
			System.out.println(getLine() + " stringSet2.toString() should be \"{}\" but is " + stringSet2.toString());
		
		if(stringSet2.size() != 0)
			System.out.println(getLine() + " stringSet2.size() should equal 9 but is " +stringSet2.size());
		
		
		try{
			stringSet2.insert(null);
			System.out.println(getLine() + "IllegalArgument exception should have been thrown");
		}catch(IllegalArgumentException e){}
		try{
			stringSet2.contains(null);
			System.out.println(getLine() + "IllegalArgument exception should have been thrown");
		}catch(IllegalArgumentException e){}
		try{
			stringSet2.remove(null);
			System.out.println(getLine() + " IllegalArgumentExcept should have been thrown");
		}catch(IllegalArgumentException e){}
		
		
		//large
		StringSet stringSet3 = new StringSet();
		
		for(int i = 0; i < 1000; i ++){
			Integer a = i;
			stringSet3.insert(a.toString());
			
		}
		
		if( stringSet3.size() != 1000)
			System.out.println(getLine() + " stringSet2.size() should equal 1000 but is " +stringSet2.size());
		
		if(!(stringSet3.contains("0"))){
			System.out.println(getLine());
		}
		if(stringSet3.contains("1000")){
			System.out.println(getLine());
		}
		if(!(stringSet3.contains("999"))){
			System.out.println(getLine());
		}
		
		stringSet3.remove("999");
		if(stringSet3.contains("999")){
			System.out.println(getLine());
		}
		
		for(int i = 0; i < 999; i++){
			Integer a = i;
			stringSet3.remove(a.toString());
		}
		
		if(!(stringSet3.toString().equals("{}")))
			System.out.println(getLine() + " stringSet3.toString() should be \"{}\" but is " + stringSet3.toString());
		
		if(stringSet3.size() != 0)
			System.out.println(getLine() + " stringSet3.size() should equal 9 but is " +stringSet3.size());
			
			
		
		
		System.out.println("Testing done");
			
				
	}
	
	
	
	
	
	public static String getLine() {
	    return " Failed at line: " +Thread.currentThread().getStackTrace()[2].getLineNumber();
	}

}
