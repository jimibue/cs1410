package assign9;

import java.awt.Color;


import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * This class helps construct the Light Out Buttons
 * @author James Yeates
 */
public class LightOutButton extends JButton {
	
	private int value;
	private int row;
	private int col;
	
	//constructor
	public LightOutButton(int row, int col){
		
		//super("" + 0);//this doesn;t seem to do anything either.
		this.row = row;
		this.col = col;
		this.setBackground(Color.GREEN);
		this.setIcon(new ImageIcon("Users/jcc/Desktop/color.jpg"));
		validate();
		value = 0;
		}
	/**
	 * this method helps appends the appropriate
	 * integer on the button
	 */
	public void turnOn(){
		this.setText("" + value%2 );
	}
	/**
	 * change the value by one
	 */
	public void changeValue(){
		value++;
	}
	/**
	 * getter method for value
	 * @return 0 or 1
	 */
	public int getValue(){
		return value%2;
	}
	/**
	 * returns a string representation of the value
	 */
	public String toString(){
		return ""+value%2;
	}
	/**
	 * this method return the row of this 2-d array
	 * @return the row
	 */
	public int getRow(){
		return row;
	}
	/**
	 * this method return the col of this 2-d array
	 * @return the col
	 */
	public int getCol(){
		return col;
	}

	
}
