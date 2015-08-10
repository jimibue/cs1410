package assign3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App  extends LoopPatterns{
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		
		
	
		
//		System.out.println("enter some integer to find there average");
//		System.out.println(average(input));
//		
//		input.reset();
//		
//		System.out.println("enter some integer to find there sum");
//		System.out.println(sum(input));
		
		File file = new File("/Users/jcc/Desktop/test.txt");
		
		try {
			Scanner s = new Scanner(file);
			System.out.println(countWord(s, "by"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Scanner s = new Scanner(file);
			System.out.println(lastWord(s));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
