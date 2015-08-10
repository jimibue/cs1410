package assign4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Test {
	
	public static void main(String[] args) {
		
		
		String s = "thisa";
		
		System.out.println(s.compareTo("this"));
	}
	
	public static Scanner getScanner() {
		
		
		File file = new File("");
		
		JFileChooser fileChooser = new JFileChooser();
		
		int returnValue = fileChooser.showOpenDialog(null);
		
		if( returnValue == fileChooser.APPROVE_OPTION){
			try {
				file = fileChooser.getSelectedFile().getCanonicalFile();
				Scanner s = new Scanner(file);
				return s;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Scanner s = new Scanner(file);
			
			
		}
		else{
			System.exit(0);
		}
		return null;
	
		
		
		
		
	}

}
