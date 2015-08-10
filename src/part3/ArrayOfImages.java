package part3;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
/**
 * This class is used to create an object that holds an ArrayList of BufferedImages
 * @author James Yeates
 *
 */

public class ArrayOfImages extends ArrayList<BufferedImage> {
	

	private int currentIndex;
	
	public ArrayOfImages(){
		
		currentIndex=-1;
	}
	
	/**
	 * 
	 * @return the current position in the ArrayList
	 */
	public int getCurrentPostion() {
		return currentIndex;
	}
	public void setCurrentPostion(int currentPostion) {
		this.currentIndex = currentPostion;
	}
	/**
	 * increments the current position in the ArrayList
	 */

	public void increamentCurrentPostion() {
		currentIndex++;
	}
	/**
	 * decrements the current position in the ArrayList
	 */
	public void decrementCurrentPostion() {
		currentIndex--;
	}
	/**
	 * checks whether users should be able to 'redo' a previous action
	 * @return boolean
	 */
	public boolean checkFowardStepEnabled(){
		return currentIndex+1<this.size();
	}
	/**
	 * checks whether users should be able to 'undo' a previous action
	 * @return boolean
	
	 */
	public boolean checkBackStepEnabled(){
		System.out.println((currentIndex>0) +"--------/n/n");
		return currentIndex>0;
	}
	
	
	

}