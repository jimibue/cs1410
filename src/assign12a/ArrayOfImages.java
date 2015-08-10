package assign12a;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ArrayOfImages extends ArrayList<BufferedImage> {
	

	private int currentIndex;
	
	public ArrayOfImages(){
		
		currentIndex=-1;
	}
	

	public int getCurrentPostion() {
		return currentIndex;
	}
	public void setCurrentPostion(int currentPostion) {
		this.currentIndex = currentPostion;
	}

	public void increamentCurrentPostion() {
		currentIndex++;
	}
	public void decrementCurrentPostion() {
		currentIndex--;
	}
	public boolean checkFowardStepEnabled(){
		return currentIndex+1<this.size();
	}
	public boolean checkBackStepEnabled(){
		System.out.println((currentIndex>0) +"--------/n/n");
		return currentIndex>0;
	}
	
	
	

}
